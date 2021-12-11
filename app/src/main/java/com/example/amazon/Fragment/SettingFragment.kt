package com.example.amazon.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.example.amazon.Activity.ChangepasswordActivity
import com.example.amazon.Activity.HelpFaqActivity
import com.example.amazon.Activity.LoginActivity
import com.example.amazon.R

class SettingFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_setting, container, false)
        val changeB= view.findViewById<ImageButton>(R.id.changeButton)
        val faqB= view.findViewById<ImageButton>(R.id.faqButton)
        val logout =view.findViewById<TextView>(R.id.logout)
        val changePassword=view.findViewById<LinearLayout>(R.id.changePass)
        val helpFaq=view.findViewById<LinearLayout>(R.id.help_faq)

        changePassword.setOnClickListener {
            val intent = Intent(activity, ChangepasswordActivity::class.java)
            startActivity(intent)
        }
        helpFaq.setOnClickListener {
            val intent = Intent(activity, HelpFaqActivity::class.java)
            startActivity(intent)
        }

        changeB.setOnClickListener {
            val intent = Intent(activity, ChangepasswordActivity::class.java)
            startActivity(intent)
        }
        faqB.setOnClickListener {
            val intent = Intent(activity, HelpFaqActivity::class.java)
            startActivity(intent)
        }
        logout.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        val button =view.findViewById<ImageButton>(R.id.imButton)
        val navOptions = NavOptions.Builder().setPopUpTo(R.id.setting, true).build()
        button.setOnClickListener{
            findNavController().navigate(R.id.action_setting_to_complete,null,navOptions)

        }


        return view
    }


}