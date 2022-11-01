package com.example.win9.views

import com.example.win9.model.PlayersModel
import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface PlayersView: MvpView {
    fun onCompleteDataApi(playersModel: PlayersModel)
    fun onErrorDataApi(error: String)
}