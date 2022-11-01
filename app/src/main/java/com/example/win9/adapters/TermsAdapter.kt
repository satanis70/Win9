package com.example.win9.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.win9.R
import com.example.win9.model.Term

class TermsAdapter(val list: List<Term>) : RecyclerView.Adapter<TermsAdapter.MainHolder>(){
    inner class MainHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvName = itemView.findViewById<TextView>(R.id.name_terms)
        val tvDescription = itemView.findViewById<TextView>(R.id.description_terms)
        fun bind(name: String, description: String){
            tvName.text = name
            tvDescription.text = description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_terms, parent, false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(list[position].name, list[position].description)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}