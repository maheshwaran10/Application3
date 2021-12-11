package com.example.amazon.Model

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.amazon.R
import java.lang.ref.WeakReference

class ItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

   private val view= WeakReference(itemView)

    private var textViewTitle:TextView?=null
    private var textViewText1:TextView?=null
    private var textViewDEs:TextView?=null
    private var imageViewImage:ImageButton?=null

    var itemModel:DataClass?=null
    init {

        view.get()?.let {
            textViewTitle=it.findViewById(R.id.title)
            textViewText1=it.findViewById(R.id.year)
            textViewDEs=it.findViewById(R.id.genre)
            imageViewImage=it.findViewById(R.id.imageB)

        }
    }
    fun updateView(){
        textViewTitle?.text = itemModel?.title
        textViewText1?.text = itemModel?.text1
        textViewDEs?.text = itemModel?.des
        imageViewImage?.setImageResource(R.drawable.ic_vector)
    }

}