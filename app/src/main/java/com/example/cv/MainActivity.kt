package com.example.cv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.cv.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myadapter = MyAdapter(this)
        binding.vpager.adapter = myadapter
        binding.tlayout.tabGravity = TabLayout.GRAVITY_FILL
        TabLayoutMediator(binding.tlayout, binding.vpager){tab, position ->
            when(position){
                0->{
                    tab.text = "Home"
                }
                1->{
//                    floating_action_button.isVisible = false
                    tab.text = "About me"
                }
                2->{
//                    floating_action_button.isVisible = false
                    tab.text = "Work"
                }
                3->{
//                    floating_action_button.isVisible = false
                    tab.text = "Contact"
                }
            }
        }.attach()

        // check if the tab is homefragment and set the visibility of the floating action button to true
        binding.vpager.registerOnPageChangeCallback(object : androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                floating_action_button.isVisible = position == 0
            }
        })
        floating_action_button.setOnClickListener {
            var intent = Intent(this, AddSkill::class.java)
            startActivity(intent)
        }

    }
}