package com.atitto.mviflowarch.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.*

abstract class BaseFragment<VI : BaseViewIntent,
        SI : BaseModelIntent, S : BaseViewState,
        PC: BasePartialChange<S>> : Fragment() {

    abstract val actor: BaseActor<VI, SI, S, PC>

    abstract val navigator: BaseNavigator

    abstract val layoutRes: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(layoutRes, container, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigator.attachFragmentManager(fragmentManager)
        actor.onCreate()

        lifecycleScope.launchWhenStarted {
            actor.singleEvent
                .onEach { handleSingleEvent(it) }
                .catch { }
                .collect()
        }

        lifecycleScope.launchWhenStarted {
            actor.viewState
                ?.onEach { render(it) }
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        intents()
            ?.onEach { actor.processIntent(it) }
            ?.launchIn(lifecycleScope)
    }

    open fun handleError(error: String) {
        /*Implement your own error handling*/
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

    open fun handleProgress(isProgressFlowing: Boolean) {
        /*Implement your own progress handling*/
    }

    open fun intents(): Flow<VI>? = null

    open fun handleSingleEvent(event: SI) {}

    open fun render(state: S) {}

    override fun onDestroy() {
        super.onDestroy()
        navigator.release()
    }

}