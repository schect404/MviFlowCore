package com.atitto.mviflowarch.extensions

import android.content.Context
import android.transition.Fade
import android.transition.TransitionInflater
import android.transition.TransitionSet
import androidx.fragment.app.Fragment

private const val MOVE_DEFAULT_TIME: Long = 300
private const val FADE_DEFAULT_TIME: Long = 100

fun Fragment.animateExit() {
    val exitFade = Fade()
    exitFade.duration = MOVE_DEFAULT_TIME
    exitTransition = exitFade
}

fun Fragment.animateEnter() {
    val enterFade = Fade()
    enterFade.duration = MOVE_DEFAULT_TIME
    enterFade.startDelay = FADE_DEFAULT_TIME
    enterTransition = enterFade
}

fun Fragment.animateShared(context: Context) {
    sharedElementEnterTransition = TransitionSet().apply {
        addTransition(TransitionInflater.from(context).inflateTransition(android.R.transition.move))
        duration = MOVE_DEFAULT_TIME
    }
}