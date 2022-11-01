package com.example.win9.presenters

import com.example.win9.services.ApiInterface
import com.example.win9.views.TermsView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moxy.InjectViewState
import moxy.MvpPresenter
import moxy.presenter.InjectPresenter
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

@InjectViewState
class TermsPresenter() : MvpPresenter<TermsView>() {
    suspend fun requestApi() {
        CoroutineScope(Dispatchers.IO).launch {
            var apiInterface = ApiInterface::class.java
            val retrofit = Retrofit.Builder()
                .baseUrl("http://49.12.202.175/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(apiInterface)
            val response = retrofit.getTerms().awaitResponse()

            if (response.isSuccessful) {
                viewState.onCompleteDataApi(response.body()!!)
            } else {
                viewState.onErrorDataApi(response.message().toString())
            }
        }
    }
}
