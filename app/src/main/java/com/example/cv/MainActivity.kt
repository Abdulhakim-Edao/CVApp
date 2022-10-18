package com.example.cv

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
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

    // override option menu function to inflate the menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_items, menu)
        return true
    }
    // override on options item selected function to handle the menu item click
    override fun onOptionsItemSelected(item: android.view.MenuItem): Boolean {
        when(item.itemId){
            R.id.linkedin -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/abdulhakim-edao-1b1b1b1b1/"))
                startActivity(intent)
            }
            R.id.github -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Abdulhakim-Edao"))
                startActivity(intent)
            }
            R.id.email -> {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/html"
                intent.putExtra(Intent.EXTRA_EMAIL, "abdulhakim.sirko@miu.edu")
                intent.putExtra(Intent.EXTRA_SUBJECT, "CV Building App")
                intent.putExtra(Intent.EXTRA_TEXT, "This is CV Building App test, \n\nThank you.")
                startActivity(Intent.createChooser(intent, "Send Email"))
            }
            R.id.instagram -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/absolute_abb/"))
                startActivity(intent)
            }
            R.id.whatsapp -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/6124618437"))
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}