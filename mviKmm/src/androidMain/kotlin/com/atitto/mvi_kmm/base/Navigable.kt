package com.atitto.mvi_kmm.base

import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

interface Navigable {
    /*Go without adding to backstack*/
    fun go(targetFragment: Fragment, vararg sharedViews: View)
    fun go(targetFragment: Fragment, fragmentManager: FragmentManager?, vararg sharedViews: View)
    fun go(targetFragment: Fragment, fragmentManager: FragmentManager?, idContainer: Int, vararg sharedViews: View)

    /*Go with adding to backstack using FragmentTransaction.add*/
    fun goWithBack(targetFragment: Fragment, vararg sharedViews: View)
    fun goWithBack(targetFragment: Fragment, fragmentManager: FragmentManager?, vararg sharedViews: View)
    fun goWithBack(targetFragment: Fragment, fragmentManager: FragmentManager?, idContainer: Int, vararg sharedViews: View)

    /*Go with adding to backstack using FragmentTransaction.replace*/
    fun goWithBackReplace(targetFragment: Fragment, vararg sharedViews: View)
    fun goWithBackReplace(targetFragment: Fragment, fragmentManager: FragmentManager?, vararg sharedViews: View)
    fun goWithBackReplace(targetFragment: Fragment, fragmentManager: FragmentManager?, idContainer: Int, vararg sharedViews: View)
}