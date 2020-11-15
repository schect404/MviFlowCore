package com.atitto.mviflowarch.stub

import com.atitto.mviflowarch.base.BaseActor

class StubActor : BaseActor<StubViewIntent, StubModelIntent, StubViewState, StubPartialChange>() {

    override val initialState: StubViewState
        get() = StubViewState()

    override fun StubPartialChange.getSingleEvent(): StubModelIntent? {
        return StubModelIntent()
    }

}