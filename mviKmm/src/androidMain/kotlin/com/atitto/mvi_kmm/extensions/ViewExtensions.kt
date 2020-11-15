package com.atitto.mvi_kmm.extensions

import android.view.View
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.visibleIfOrGone(predicate: () -> Boolean) {
    if (predicate()) visible() else gone()
}

fun View.visibleIfOrInvisible(predicate: () -> Boolean) {
    if (predicate()) visible() else invisible()
}

fun View.disable() {
    alpha = 0.7f
    isClickable = false
    isEnabled = false
}

fun View.enable() {
    alpha = 1f
    isClickable = true
    isEnabled = true
}

fun EditText.stringText() = text?.toString() ?: ""

fun View.enableIf(predicate: () -> Boolean) {
    if (predicate()) enable() else disable()
}

fun RecyclerView.attachAdapter(listAdapter: RecyclerView.Adapter<*>) {
    adapter ?: run { adapter = listAdapter }
}