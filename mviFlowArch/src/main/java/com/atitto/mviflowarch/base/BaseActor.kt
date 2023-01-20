package com.atitto.mviflowarch.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

abstract class BaseActor<VI : BaseViewIntent, S : BaseViewState> :
    ViewModel() {

    val progressVisible: MutableStateFlow<Boolean> = MutableStateFlow(false)

    val errorFlow = MutableStateFlow<String?>(null)

    protected fun <T> Flow<T>.runWithProgress(rethrowError: Boolean = false) =
        onStart {
            progressVisible.value = true
        }.onEach {
            progressVisible.value = false
        }.catch {
            progressVisible.value = false
            if (rethrowError) throw it
            else {
                errorFlow.value = transformError(it)
            }
        }

    protected fun <T> Flow<T>.runWithoutProgress(rethrowError: Boolean = false) =
        catch {
            if (rethrowError) throw it
            else {
                errorFlow.value = transformError(it)
            }
        }

    protected open fun transformError(error: Throwable): String? {
        /*Implement your error handling*/
        return error.message
    }

    private val initialState: S by lazy { createInitialState() }

    private val viewIntentFlow = MutableSharedFlow<VI>()

    private val _singleEventFlow = MutableSharedFlow<BaseModelIntent>()
    val singleEventFlow: SharedFlow<BaseModelIntent> = _singleEventFlow

    /**
     * Current state of the view. This state is updated
     * every time an event is produced in the ViewModel.
     */
    private val viewStateFlow = MutableStateFlow(initialState)
    val state: StateFlow<S> = viewStateFlow
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = initialState
        )

    /**
     * Returns the initial state of the view.
     */
    abstract fun createInitialState(): S

    /**
     * Handles the intent of type BaseViewIntent produced **from** the view.
     * Each intent is mapped to a StateReducer to update the state of the view.
     */
    abstract fun Flow<VI>.handleIntent(): Flow<BasePartialChange<S>>

    /**
     * Process an intent of type BaseViewIntent. This intent
     * will produce a change in the current state of the view.
     */
    fun processIntent(intent: VI) = viewModelScope.launch { viewIntentFlow.emit(intent) }

    /**
     * Dispatch an event of type BaseSingleEvent. This event
     * will produce a change in the single event flow.
     */
    private fun dispatchSingleEvent(event: BaseModelIntent) =
        viewModelScope.launch { _singleEventFlow.emit(event) }

    protected open fun getSingleEventFromStateReducer(state: BasePartialChange<S>): BaseModelIntent? =
        null

    init {
        viewIntentFlow
            .conflate()
            .handleIntent()
            .onEach { getSingleEventFromStateReducer(it)?.let(::dispatchSingleEvent) }
            .scan(initialState) { viewState, change -> change.reduceToState(viewState) }
            .onEach { setState(it) }
            .launchIn(viewModelScope)
    }

    private fun setState(state: S) {
        viewStateFlow.value = state
    }
}