package com.example.lab2android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListAdapter(
    private val itemList: List<ItemData>,
    private val onItemClick: (ItemData) -> Unit
) : RecyclerView.Adapter<ListAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.imageView)
        val titleTextView: TextView = view.findViewById(R.id.textViewTitle)
        val descriptionTextView: TextView = view.findViewById(R.id.textViewDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val itemData = itemList[position]
        holder.titleTextView.text = itemData.title
        holder.descriptionTextView.text = itemData.description

        Glide.with(holder.itemView.context)
            .load(itemData.imageUrl)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error)
            .into(holder.imageView)

        holder.itemView.setOnClickListener {
            onItemClick(itemData)
        }
    }

    override fun getItemCount() = itemList.size
}
