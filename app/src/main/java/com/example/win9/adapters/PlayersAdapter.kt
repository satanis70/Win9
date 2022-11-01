package com.example.win9.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.win9.R
import com.example.win9.model.BestPlayer
import org.w3c.dom.Text

class PlayersAdapter(val list: List<BestPlayer>) :
    RecyclerView.Adapter<PlayersAdapter.MainHolder>() {
    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.image_view_player)
        val tvNamePlayer = itemView.findViewById<TextView>(R.id.name_player)
        val tvRank = itemView.findViewById<TextView>(R.id.rank_player)
        val tvTeam = itemView.findViewById<TextView>(R.id.team_player)
        val tvStyle = itemView.findViewById<TextView>(R.id.style_player)
        val tvDescription = itemView.findViewById<TextView>(R.id.description_player)

        fun bind(
            image: String,
            name: String,
            rank: String,
            team: String,
            style: String,
            description: String
        ) {
            Glide.with(itemView.context)
                .load(image)
                .into(imageView)
            tvNamePlayer.text = name
            tvRank.text = rank
            tvTeam.text = team
            tvStyle.text = style
            tvDescription.text = description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_players, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(
            list[position].img,
            list[position].name,
            list[position].rank,
            list[position].team,
            list[position].playerstyle,
            list[position].description
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }
}