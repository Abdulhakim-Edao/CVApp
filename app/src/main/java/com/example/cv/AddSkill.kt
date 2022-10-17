package com.example.cv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_skill.*

class AddSkill : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_skill)


        save.setOnClickListener {
            var skillCat = skill_category.text.toString()
            var skillName = skill_name.text.toString()
            val bundle = Bundle()
            val myFragment = HomeFragment()
            bundle.putString("category", skillCat)
            bundle.putString("name", skillName)
            myFragment.arguments = bundle
            finish()
        }
        goBack.setOnClickListener {
            finish()
        }

    }
}