package com.example.amazon.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.amazon.Model.Versions
import com.example.amazon.R

class VersionAdapter(val versionList: List<Versions>):RecyclerView.Adapter<VersionAdapter.ViewHolder>() {
    class ViewHolder(view: View) :RecyclerView.ViewHolder(view){
        var codeNametxt :TextView =view.findViewById(R.id.code_name)
        var descriptionText :TextView =view.findViewById(R.id.description)
        var constaintLayout :ConstraintLayout=view.findViewById(R.id.constraint)
        var expandableLayout :RelativeLayout=view.findViewById(R.id.expanded_layout)
        var downButton:ImageButton=view.findViewById(R.id.downB)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val versions :Versions = versionList[position]

        holder.codeNametxt.text=versions.codeName
        holder.descriptionText.text=versions.description

        val isExpandable : Boolean = versionList[position].expandable
        holder.expandableLayout.visibility = if (isExpandable) View.VISIBLE else View.GONE
        holder.constaintLayout.setOnClickListener {
            val versions=versionList[position]
            versions.expandable =!versions.expandable
            notifyItemChanged(position)
        }
        val isExpandable1 : Boolean = versionList[position].expandable
        holder.expandableLayout.visibility = if (isExpandable1) View.VISIBLE else View.GONE
        holder.downButton.setOnClickListener {
            val versions1=versionList[position]
            versions1.expandable =!versions.expandable
            notifyItemChanged(position)
        }

    }

    override fun getItemCount(): Int {
        return versionList.size
    }
}