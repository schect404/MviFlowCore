package com.atitto.mvi_kmm.vm

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlin.native.internal.GC

@ThreadLocal
private var isGCWorking = false

actual open class ViewModel actual constructor() {
    // for now dispatcher fixed on Main. after implementing multithread coroutines on native - we can change it
    protected actual val viewModelScope: CoroutineScope = CoroutineScope(Dispatchers.Main)

    actual open fun onCleared() {
        viewModelScope.cancel()
        // run Kotlin/Native GC
        if (!isGCWorking) {
            isGCWorking = true
            GC.collect()
            isGCWorking = false
        }
    }
}