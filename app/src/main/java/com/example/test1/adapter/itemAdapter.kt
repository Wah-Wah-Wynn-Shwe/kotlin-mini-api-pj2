package com.example.test1.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.test1.Model.item
import com.example.test1.R

class itemAdapter(context: Context, private var items: List<item>?) :
    RecyclerView.Adapter<itemAdapter.itemViewHolder>() {



    inner class itemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val status: TextView
        val totalresults: TextView
        val articles: TextView

        init {
            status = itemView.findViewById(R.id.status) as TextView
            totalresults = itemView.findViewById(R.id.totalresults) as TextView
            articles = itemView.findViewById(R.id.articles) as TextView

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_item, parent, false)
        return itemViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        val movie = items!![position]
        Log.d("Wellplayed", "" + movie)
        holder.status.text = movie.getStatus()
        holder.totalresults.text = movie.getTotalresults()
        holder.articles.text = movie.getArticles()
    }





    override fun getItemCount(): Int {
        return items!!.size

    }

    fun setitems(items: List<item>) {
        this.items = items
        notifyDataSetChanged()
    }
}
