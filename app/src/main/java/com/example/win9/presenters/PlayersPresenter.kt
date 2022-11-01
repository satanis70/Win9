package com.example.win9.presenters

import com.example.win9.services.ApiInterface
import com.example.win9.views.PlayersView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moxy.InjectViewState
import moxy.MvpPresenter
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory


@InjectViewState
class PlayersPresenter(): MvpPresenter<PlayersView>() {
    suspend fun requestApi(){
        GlobalScope.launch{
            val apiInterface = ApiInterface::class.java
            val retrofit = Retrofit.Builder()
                .baseUrl("http://49.12.202.175/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(apiInterface)

            val response = retrofit.getPlayers().awaitResponse()

            if (response.isSuccessful){
                viewState.onCompleteDataApi(response.body()!!)
            } else {
                viewState.onErrorDataApi(response.message().toString())
            }
        }
    }
}