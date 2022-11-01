package com.example.win9.views

import com.example.win9.model.PlayersModel
import com.example.win9.model.TermsModel
import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = OneExecutionStateStrategy::class)
interface TermsView: MvpView {
    fun onCompleteDataApi(termsModel: TermsModel)
    fun onErrorDataApi(error: String)
}