package com.example.amazon.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.amazon.Model.DataClass
import com.example.amazon.Model.ItemViewHolder
import com.example.amazon.R

class TestAdapter(private val onLoadMore: ()->Unit):RecyclerView.Adapter<ItemViewHolder>() {
    val list = mutableListOf<DataClass>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder((LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
       holder.itemModel = list[position]
        holder.updateView()
        if (position ==list.size -1){
            onLoadMore

        }
    }

    override fun getItemCount(): Int {
       return list.size
    }
    fun reload(list:MutableList<DataClass>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun loadMore(list:MutableList<DataClass>){
        this.list.addAll(list)
        notifyItemRangeChanged(this.list.size +1,list.size)

    }
}