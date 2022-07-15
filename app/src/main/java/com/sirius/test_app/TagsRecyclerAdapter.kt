package com.sirius.test_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class TagsRecyclerAdapter(private val tags: List<String>) : RecyclerView
.Adapter<TagsRecyclerAdapter.TagsViewHolder>() {

    class TagsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: Button = itemView.findViewById(R.id.butTag)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_tags_item, parent, false)
        return TagsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TagsViewHolder, position: Int) {
        holder.button.text = tags[position]
    }

    override fun getItemCount() = tags.size
}