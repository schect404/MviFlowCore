package com.atitto.mvi_kmm.stub

import com.atitto.mvi_kmm.base.BaseActor

class StubActor : BaseActor<StubViewIntent, StubModelIntent, StubViewState, StubPartialChange>() {

    override val initialState: StubViewState
        get() = StubViewState()

    override fun StubPartialChange.getSingleEvent(): StubModelIntent? {
        return StubModelIntent()
    }

}