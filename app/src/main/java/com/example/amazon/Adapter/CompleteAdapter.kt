package com.example.amazon.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.amazon.Model.DataClass2
import com.example.amazon.R

class CompleteAdapter(val completeList :ArrayList<DataClass2>):
    RecyclerView.Adapter<CompleteAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    class ViewHolder(itemView: View, listener: onItemClickListener) :RecyclerView.ViewHolder(itemView){
        val title2 =itemView.findViewById<TextView>(R.id.title)
        val text2 =itemView.findViewById<TextView>(R.id.year)
        val description = itemView.findViewById<TextView>(R.id.genre)
        val imageb = itemView.findViewById<ImageButton>(R.id.imageB)
        val completeOn = itemView.findViewById<TextView>(R.id.complete)
        fun bindItems(users:DataClass2){
            title2.text=users.title
            text2.text=users.text1
            description.text = users.des
            completeOn.text=users.complete
            imageb.setImageResource(users.image)
        }
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.row2,parent,false)
        return ViewHolder(v,mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(completeList[position])

    }

    override fun getItemCount(): Int {
        return completeList.size

    }
}