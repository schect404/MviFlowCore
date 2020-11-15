package com.atitto.mvi_kmm.stub

import com.atitto.mvi_kmm.base.BasePartialChange

open class StubPartialChange : BasePartialChange<StubViewState> {
    override fun reduceToState(initialState: StubViewState) = StubViewState()
}