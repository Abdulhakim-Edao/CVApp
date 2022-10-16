package com.example.cv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cv.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tlayout.tabGravity = TabLayout.GRAVITY_FILL
        val myadapter = MyAdapter(this)
        binding.vpager.adapter = myadapter
        TabLayoutMediator(binding.tlayout, binding.vpager){tab, position ->
            when(position){
                0->{
                    tab.text = "Home"
                    tab.setIcon(R.drawable.home)
                }
                1->{
                    tab.text = "About me"
                    tab.setIcon(R.drawable.person)
                }
                2->{
                    tab.text = "Work"
                    tab.setIcon(R.drawable.work)
                }
                3->{
                    tab.text = "Contact"
                    tab.setIcon(R.drawable.contact)
                }
            }
        }.attach()
    }
}