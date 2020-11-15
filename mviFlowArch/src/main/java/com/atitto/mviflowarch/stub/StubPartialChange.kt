package com.atitto.mviflowarch.stub

import com.atitto.mviflowarch.base.BasePartialChange

open class StubPartialChange : BasePartialChange<StubViewState> {
    override fun reduceToState(initialState: StubViewState) = StubViewState()
}