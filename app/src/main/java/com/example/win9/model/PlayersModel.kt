package com.example.win9.model


import com.google.gson.annotations.SerializedName

data class PlayersModel(
    @SerializedName("best_players")
    val bestPlayers: List<BestPlayer>
)