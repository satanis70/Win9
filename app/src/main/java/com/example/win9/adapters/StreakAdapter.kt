package com.example.win9.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.win9.R
import com.example.win9.model.Streak

class StreakAdapter(val list: List<Streak>) : RecyclerView.Adapter<StreakAdapter.MainHolder>(){
    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvCountStreak = itemView.findViewById<TextView>(R.id.count_streak)
        val tvTeam = itemView.findViewById<TextView>(R.id.team_streak)
        val tvDescription = itemView.findViewById<TextView>(R.id.description_streak)
        fun bind(count: String, team: String, description: String){
            tvCountStreak.text = count
            tvTeam.text = team
            tvDescription.text = description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_streaks, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(list[position].streak, list[position].team, list[position].description)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}