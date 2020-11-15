package com.atitto.mvi_kmm.base

import com.atitto.mvi_kmm.vm.ViewModel
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

abstract class BaseActor<VI : BaseViewIntent, SI : BaseModelIntent, S : BaseViewState, PC : BasePartialChange<S>> :
    ViewModel() {

    protected abstract val initialState: S

    protected val eventChannel = BroadcastChannel<SI>(capacity = Channel.BUFFERED)
    private val intentChannel = BroadcastChannel<VI>(capacity = Channel.CONFLATED)

    private val intentFlow = intentChannel.asFlow()

    val progressVisible: MutableStateFlow<Boolean> = MutableStateFlow(false)

    suspend fun processIntent(intent: VI) {
        intentChannel.send(intent)
    }

    val singleEvent: Flow<SI> = eventChannel.asFlow()

    var viewState: MutableStateFlow<S>? = null
        private set

    val errorFlow = MutableStateFlow<String?>(null)

    open fun onCreate() {
        viewState = MutableStateFlow(initialState)
        intentFlow
            .handleIntent()
            .onEach { it.getSingleEvent()?.let { pushSingleEvent(it) } }
            .scan(initialState) { vs, change -> change.reduceToState(vs) }
            .onEach {
                viewState?.value = it
            }
            .launchIn(viewModelScope)

    }

    protected suspend fun pushSingleEvent(event: SI) {
        eventChannel.send(event)
    }

    //handle view intent and returning flow with partial change
    open fun Flow<VI>.handleIntent(): Flow<PC> = flowOf()

    //get single event if needed
    open fun PC.getSingleEvent(): SI? = null

    protected fun <T> Flow<T>.runWithProgress(rethrowError: Boolean = false) =
        onStart {
            progressVisible.value = true
        }.onEach {
            progressVisible.value = false
        }.catch {
            progressVisible.value = false
            if(rethrowError) throw it
            else  {
                errorFlow.value = transformError(it)
            }
        }

    protected fun <T> Flow<T>.runWithoutProgress(rethrowError: Boolean = false) =
        catch {
            if(rethrowError) throw it
            else {
                errorFlow.value = transformError(it)
            }
        }

    protected open fun transformError(error: Throwable): String? {
        /*Implement your error handling*/
        return error.message
    }

}