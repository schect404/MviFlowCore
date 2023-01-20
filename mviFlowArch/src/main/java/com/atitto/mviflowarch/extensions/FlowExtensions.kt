package com.atitto.mviflowarch.extensions

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import androidx.viewpager2.widget.ViewPager2
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicReference

fun View.clicks(): Flow<View> {
    return callbackFlow {
        setOnClickListener { trySend(it) }
        awaitClose { setOnClickListener(null) }
    }
}

fun CheckBox.checkChanges(): Flow<Boolean> {
    return callbackFlow {
        setOnCheckedChangeListener { buttonView, isChecked ->
            if(buttonView.isPressed) trySend(isChecked)
        }
        awaitClose { setOnCheckedChangeListener(null) }
    }
}

fun EditText.textChanges(): Flow<String> {
    return callbackFlow<String> {
        val listener = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) = Unit
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) = Unit
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(hasFocus()) trySend(s?.toString() ?: "")
            }
        }
        addTextChangedListener(listener)
        awaitClose { removeTextChangedListener(listener) }
    }.onStart { emit(text?.toString() ?: "") }
}

fun ViewPager2.pageChanges(): Flow<Int> {
    return callbackFlow<Int> {
        val listener = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                trySend(position)
            }
        }
        registerOnPageChangeCallback(listener)
        awaitClose { unregisterOnPageChangeCallback(listener) }
    }
}

private object UNINITIALIZED

fun <A, B, R> Flow<A>.withLatestFrom(other: Flow<B>, transform: suspend (A, B) -> R): Flow<R> {
    return flow {
        coroutineScope {
            val latestB = AtomicReference<Any>(UNINITIALIZED)
            val outerScope = this

            launch {
                try {
                    other.collect { latestB.set(it) }
                } catch (e: CancellationException) {
                    outerScope.cancel(e) // cancel outer scope on cancellation exception, too
                }
            }

            collect { a ->
                val b = latestB.get()
                if (b != UNINITIALIZED) {
                    @Suppress("UNCHECKED_CAST")
                    emit(transform(a, b as B))
                }
            }
        }
    }
}