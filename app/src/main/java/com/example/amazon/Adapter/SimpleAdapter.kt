package com.example.amazon.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.amazon.Model.DataClass
import com.example.amazon.R

class SimpleAdapter( val classList: ArrayList<DataClass>) : RecyclerView.Adapter<SimpleAdapter.ViewHolder>() {
    private lateinit var mListener: onItemClickListener
    interface onItemClickListener {
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }
    class ViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val title = itemView.findViewById<TextView>(R.id.title)
        val textl = itemView.findViewById<TextView>(R.id.year)
        val description = itemView.findViewById<TextView>(R.id.genre)
        val imageb = itemView.findViewById<ImageButton>(R.id.imageB)
        val dateM=itemView.findViewById<TextView>(R.id.date)


        fun bindItem(user: DataClass) {
            title.text = user.title
            textl.text = user.text1
            description.text = user.des
            dateM.text=user.date
            imageb.setImageResource(user.image)
        }

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ViewHolder(v, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(classList[position])
    }

    override fun getItemCount(): Int {
        return classList.size

    }

}


