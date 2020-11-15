package com.atitto.mvi_kmm.stub

import com.atitto.mvi_kmm.base.BaseFragment

abstract class SimpleFragment : BaseFragment<StubViewIntent, StubModelIntent, StubViewState, StubPartialChange>() {

    override val actor = StubActor()

}