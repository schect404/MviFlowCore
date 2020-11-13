package com.atitto.mviflowarch.base

interface BasePartialChange<T> {
    fun reduceToState(initialState: T): T
}