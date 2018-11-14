package com.example.lenovo.footballclub

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_view.view.*
import org.jetbrains.anko.AnkoContext

class Adapter(private val context: Context, private val items: List<Item>, private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(ItemView().createView(AnkoContext.create(parent.context)))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(item: Item, listener: (Item) -> Unit) {

            itemView.name.text = item.name
            Glide.with(itemView.context).load(item.image).into(itemView.image)
            itemView.setOnClickListener { listener(item) }
        }
    }
}