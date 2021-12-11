package com.example.amazon.Fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.amazon.Activity.HomeDetailActivity
import com.example.amazon.Adapter.SimpleAdapter
import com.example.amazon.Model.DataClass
import com.example.amazon.R

class HomeFragment : Fragment() {
    val users = ArrayList<DataClass>()
    val list = ArrayList<DataClass>()


    init {
        users.add(
            DataClass(
                "Battery Issue",
                "TN 05 AB 1234",
                "random street, 23 area mylapore",
                R.drawable.ic_vector,"16-11-2021"
            )
        )
        users.add(
            DataClass(
                "Battery Problem",
                "TN 05 AB 1234",
                "random street, 23 area mylapore",
                R.drawable.ic_vector,"16-11-2021"
            )
        )
        users.add(
            DataClass(
                "Battery Issue",
                "TN 05 AB 1234",
                "random street, 23 area mylapore",
                R.drawable.ic_vector,"16-11-2021"
            )
        )
        users.add(
            DataClass(
                "Battery Issue",
                "TN 05 AB 1234",
                "random street, 23 area mylapore",
                R.drawable.ic_vector,"17-11-2021"
            )
        )
        users.add(
            DataClass(
                "Battery Issue",
                "TN 05 AB 1234",
                "random street, 23 area mylapore",
                R.drawable.ic_vector,"17-11-2021"
            )
        )
        users.add(
            DataClass(
                "Battery Issue",
                "TN 05 AB 1234",
                "random street, 23 area mylapore",
                R.drawable.ic_vector,"18-11-2021"
            )
        )
        users.add(
            DataClass(
                "Battery Issue",
                "TN 05 AB 1234",
                "random street, 23 area mylapore",
                R.drawable.ic_vector,"18-11-2021"
            )
        )
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val swipeRefreshLayout = view.findViewById<SwipeRefreshLayout>(R.id.swipe)
        swipeRefreshLayout.setOnRefreshListener {
            Handler().postDelayed(Runnable {
                swipeRefreshLayout.isRefreshing = false
            }, 1000)
        }
        val hashMap: HashMap<String, ArrayList<DataClass>> = HashMap<String, ArrayList<DataClass>>()

        for (k in users){
            if (hashMap.isEmpty()){
                list.add(k)
                hashMap[k.date] = list
            }else {
                hashMap.containsKey(k.date)
                list.add(k)
            }
            hashMap[k.date] = list
            if (hashMap.containsKey(k.date)){
                list.add(k)
                hashMap[k.date] = list
            }else{
                hashMap.containsKey(k.date)
                list.add(k)
            }

        }


        val rv = view.findViewById<RecyclerView>(R.id.recycler_view)
        rv.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = SimpleAdapter(users)
        }
        val adapter = SimpleAdapter(users)
        rv.adapter = adapter
        adapter.setOnItemClickListener(object : SimpleAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {

                val dataClass = users[position]
                val gTitle: String = dataClass.title
                val gText: String = dataClass.text1
                val gDes: String = dataClass.des
                val gImage: Int = dataClass.image
                val intent = Intent(activity, HomeDetailActivity::class.java)

                intent.putExtra("iTitle", gTitle)
                intent.putExtra("iText", gText)
                intent.putExtra("iDes", gDes)
                intent.putExtra("iImage", gImage)

                startActivity(intent)
            }
        })


        return view

    }
}