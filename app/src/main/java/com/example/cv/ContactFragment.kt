package com.example.cv

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment


class ContactFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_contact, container, false)

        // register fragment for onClick event
        val linkedin = view.findViewById<LinearLayout>(R.id.linkedin)
        linkedin.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/abdulhakim-edao-1b1b1b1b1/"))
            startActivity(intent)
        }
        val github = view.findViewById<LinearLayout>(R.id.github)
        github.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Abdulhakim-Edao"))
            startActivity(intent)
        }

        val email = view.findViewById<LinearLayout>(R.id.email)
        email.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/html"
            intent.putExtra(Intent.EXTRA_EMAIL, "abdulhakim.sirko@miu.edu")
            intent.putExtra(Intent.EXTRA_SUBJECT, "CV Building App")
            intent.putExtra(Intent.EXTRA_TEXT, "This is CV Building App test, \n\nThank you.")
            startActivity(Intent.createChooser(intent, "Send Email"))
        }

        val mobile = view.findViewById<LinearLayout>(R.id.mobile)
        mobile.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel: +1 612 461 8437")
            startActivity(intent)
        }

        return view
    }
}