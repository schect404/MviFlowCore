package com.atitto.mviflowarch.stub

import com.atitto.mviflowarch.base.BaseFragment

abstract class SimpleFragment : BaseFragment<StubViewIntent, StubModelIntent, StubViewState, StubPartialChange>() {

    override val actor = StubActor()

}