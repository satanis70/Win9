package com.example.win9.model


import com.google.gson.annotations.SerializedName

data class Streak(
    val description: String,
    val streak: String,
    val team: String
)