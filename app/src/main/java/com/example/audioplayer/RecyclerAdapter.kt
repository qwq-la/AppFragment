package com.example.audioplayer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.song_element_view, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun getItemCount() = 1

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
    }
}

class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view){

}