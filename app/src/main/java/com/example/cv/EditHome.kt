package com.example.cv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_home.*

class EditHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_home)
        var intent = intent
        editHeader.text = intent.getStringExtra("header")
        editBody.setText(intent.getStringExtra("body"))
    }
}