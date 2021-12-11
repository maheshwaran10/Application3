package com.example.amazon.Activity

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.amazon.Adapter.VersionAdapter
import com.example.amazon.Model.Versions
import com.example.amazon.R

class HelpFaqActivity : AppCompatActivity() {

    val versionList=ArrayList<Versions>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help_faq)
        supportActionBar?.hide()
        val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        val versionAdapter =VersionAdapter(versionList)
        val imb=findViewById<ImageButton>(R.id.imButton)

        imb.setOnClickListener {
            finish()
        }
        recyclerView.adapter= versionAdapter
        recyclerView.setHasFixedSize(true)


        initData()
    }

    private fun initData() {
        versionList.add(Versions("Where can i pick the bike from?",
            "You can pick the bike from any of our zones which are listed on the app"))
        versionList.add(Versions("Where can i drop off the bike?",
            "You need to drop the bike at geo fenced area (green zone) from the city."))
        versionList.add(Versions("Is there any depost that i have to pay?",
        "You need to drop the bike at geo fenced area (green zone) from the city."))
        versionList.add(Versions("Is there any limit on the Kilometers?",
            "You can pick the bike from any of our zones which are listed on the app"))
        versionList.add(Versions("Is there any age limit to rent the bike?",
        "You need to drop the bike at geo fenced area (green zone) from the city."))
        versionList.add(Versions("Is there any depost that i have to pay?",
        "You can pick the bike from any of our zones which are listed on the app"))


    }


}