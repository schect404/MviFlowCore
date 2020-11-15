package com.atitto.mvi_kmm.base

import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.atitto.mvi_kmm.extensions.animateEnter
import com.atitto.mvi_kmm.extensions.animateExit
import com.atitto.mvi_kmm.extensions.animateShared
import java.lang.ref.WeakReference

abstract class BaseNavigator(@IdRes private val idContainer: Int): Navigable {

    private var fragmentManager: WeakReference<FragmentManager?> = WeakReference(null)

    fun attachFragmentManager(fragmentManager: FragmentManager?) {
        this.fragmentManager = WeakReference(fragmentManager)
    }

    fun release() {
        fragmentManager.clear()
    }

    fun back() {
        fragmentManager.get()?.popBackStack()
    }

    override fun go(targetFragment: Fragment, vararg sharedViews: View) {
        fragmentManager.get()?.goWithAnimation(targetFragment, *sharedViews)
    }

    override fun go(targetFragment: Fragment, fragmentManager: FragmentManager?, vararg sharedViews: View) {
        fragmentManager?.goWithAnimation(targetFragment, *sharedViews)
    }

    override fun go(targetFragment: Fragment, fragmentManager: FragmentManager?, idContainer: Int, vararg sharedViews: View) {
        fragmentManager?.goWithAnimation(targetFragment, *sharedViews, idContainer = idContainer)
    }

    override fun goWithBack(targetFragment: Fragment, vararg sharedViews: View) {
        fragmentManager.get()?.goWithAnimationAndBack(targetFragment, *sharedViews)
    }

    override fun goWithBack(targetFragment: Fragment, fragmentManager: FragmentManager?, vararg sharedViews: View) {
        fragmentManager?.goWithAnimationAndBack(targetFragment, *sharedViews)
    }

    override fun goWithBack(targetFragment: Fragment, fragmentManager: FragmentManager?, idContainer: Int, vararg sharedViews: View) {
        fragmentManager?.goWithAnimationAndBack(targetFragment, *sharedViews, idContainer = idContainer)
    }

    override fun goWithBackReplace(targetFragment: Fragment, vararg sharedViews: View) {
        fragmentManager.get()?.goWithAnimationAndBack(targetFragment, *sharedViews)
    }

    override fun goWithBackReplace(targetFragment: Fragment, fragmentManager: FragmentManager?, vararg sharedViews: View) {
        fragmentManager?.goWithAnimationAndBack(targetFragment, *sharedViews)
    }

    override fun goWithBackReplace(targetFragment: Fragment, fragmentManager: FragmentManager?, idContainer: Int, vararg sharedViews: View) {
        fragmentManager?.goWithAnimationAndBack(targetFragment, *sharedViews, idContainer = idContainer)
    }

    private fun FragmentManager.goWithAnimation(targetFragment: Fragment, vararg sharedViews: View, idContainer: Int? = null) {

        val previousFragment = findFragmentById(idContainer ?: this@BaseNavigator.idContainer) ?: return
        previousFragment.animateExit()

        targetFragment.animateShared(previousFragment.requireContext())
        targetFragment.animateEnter()

        beginTransaction()
            .replace(idContainer ?: this@BaseNavigator.idContainer, targetFragment)
            .apply { sharedViews.forEach { addSharedElement(it, it.transitionName) } }
            .commit()

    }

    private fun FragmentManager.goWithAnimationAndBack(targetFragment: Fragment, vararg sharedViews: View, idContainer: Int? = null) {

        val previousFragment = findFragmentById(idContainer ?: this@BaseNavigator.idContainer) ?: return
        previousFragment.animateExit()

        targetFragment.animateShared(previousFragment.requireContext())
        targetFragment.animateEnter()

        beginTransaction()
            .add(idContainer ?: this@BaseNavigator.idContainer, targetFragment)
            .apply { sharedViews.forEach { addSharedElement(it, it.transitionName) } }
            .addToBackStack(targetFragment::class.java.name)
            .commit()

    }

    fun FragmentManager.goWithAnimationAndBackReplace(targetFragment: Fragment, vararg sharedViews: View, idContainer: Int? = null) {

        val previousFragment = findFragmentById(idContainer ?: this@BaseNavigator.idContainer) ?: return
        previousFragment.animateExit()

        targetFragment.animateShared(previousFragment.requireContext())
        targetFragment.animateEnter()

        beginTransaction()
            .replace(idContainer ?: this@BaseNavigator.idContainer, targetFragment)
            .apply { sharedViews.forEach { addSharedElement(it, it.transitionName) } }
            .addToBackStack(targetFragment::class.java.name)
            .commit()

    }

}