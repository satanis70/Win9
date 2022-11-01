package com.example.win9.views

import com.example.win9.model.PlayersModel
import com.example.win9.model.StreaksModel
import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface StreakView: MvpView {
    fun onCompleteDataApi(streaksModel: StreaksModel)
    fun onErrorDataApi(error: String)
}