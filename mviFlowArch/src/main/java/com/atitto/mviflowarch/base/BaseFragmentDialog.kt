package com.atitto.mviflowarch.base

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.*

abstract class BaseFragmentDialog<VI : BaseViewIntent,
        SI : BaseModelIntent, S : BaseViewState,
        PC: BasePartialChange<S>> : DialogFragment() {

    abstract val actor: BaseActor<VI, SI, S, PC>

    abstract val navigator: BaseNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigator.attachFragmentManager(fragmentManager)
        actor.onCreate()

        lifecycleScope.launchWhenStarted {
            actor.singleEvent
                .onEach(::handleSingleEvent)
                .catch { }
                .collect()
        }

        lifecycleScope.launchWhenStarted {
            actor.viewState
                ?.onEach(::render)
                ?.catch {  }
                ?.collect()
        }

        lifecycleScope.launchWhenStarted {
            actor.progressVisible
                .onEach(::handleProgress)
                .collect()
        }

        lifecycleScope.launchWhenStarted {
            actor.errorFlow
                .filterNotNull()
                .onEach(::handleError)
                .collect()
        }
    }

    open fun handleError(error: String) {
        /*Implement your own error handling*/
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

    open fun handleProgress(isProgressFlowing: Boolean) {
        /*Implement your own progress handling*/
    }

    override fun onStart() {
        super.onStart()

        intents()
            ?.onEach(actor::processIntent)
            ?.launchIn(lifecycleScope)
    }

    open fun intents(): Flow<VI>? = null

    open fun handleSingleEvent(event: SI) {}

    open fun render(state: S) {}

    override fun onDestroy() {
        super.onDestroy()
        navigator.release()
    }

}