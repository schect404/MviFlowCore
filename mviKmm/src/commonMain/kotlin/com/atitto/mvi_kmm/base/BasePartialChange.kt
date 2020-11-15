package com.atitto.mvi_kmm.base

interface BasePartialChange<T> {
    fun reduceToState(initialState: T): T
}