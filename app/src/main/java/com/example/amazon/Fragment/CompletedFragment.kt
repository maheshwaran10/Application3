package com.example.amazon.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.amazon.Activity.CompletedDetailActivity
import com.example.amazon.Adapter.CompleteAdapter
import com.example.amazon.Model.DataClass2
import com.example.amazon.R

class CompletedFragment : Fragment() {

    val users = ArrayList<DataClass2>()

    init {
        users.add(DataClass2("Battery Issue", "TN 05 AB 1234", "random street, 23 area mylapore",R.drawable.ic_vector,"Completed On 25th May"))
        users.add(DataClass2("Battery Problem", "TN 05 AB 1234", "random street, 23 area mylapore",R.drawable.ic_vector,"Completed On 25th May"))
        users.add(DataClass2("Battery Issue", "TN 05 AB 1234", "random street, 23 area mylapore",R.drawable.ic_vector,"Completed On 25th May"))
        users.add(DataClass2("Battery Issue", "TN 05 AB 1234", "random street, 23 area mylapore",R.drawable.ic_vector,"Completed On 25th May"))

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_completed, container, false)

        val button = view.findViewById<ImageButton>(R.id.imButton)
        val navOptions = NavOptions.Builder().setPopUpTo(R.id.complete, true).build()
        button.setOnClickListener {
            findNavController().navigate(R.id.action_complete_to_home,null,navOptions)


        }
        val rv=view. findViewById<RecyclerView>(R.id.recycler)
        rv.apply {
            layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
            adapter= CompleteAdapter(users)
        }

        var adapter = CompleteAdapter(users)
        rv.adapter = adapter
        adapter.setOnItemClickListener(object : CompleteAdapter.onItemClickListener {
            override fun onItemClick(position : Int){

                val dataClass2 = users[position]
                val gTitle: String = dataClass2.title
                val gText: String = dataClass2.text1


                val intent = Intent(activity,CompletedDetailActivity::class.java)

                intent.putExtra("iTitle", gTitle)
                intent.putExtra("iText", gText)
                startActivity(intent)
            }
        })


        return view

    }
}