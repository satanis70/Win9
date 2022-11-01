package com.example.win9.services

import com.example.win9.model.BestPlayer
import com.example.win9.model.PlayersModel
import com.example.win9.model.StreaksModel
import com.example.win9.model.TermsModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("/win9/best_players_2022.json")
    fun getPlayers(): Call<PlayersModel>
    @GET("/win9/terms.json")
    fun getTerms(): Call<TermsModel>
    @GET("/win9/streaks.json")
    fun getStreak(): Call<StreaksModel>
}