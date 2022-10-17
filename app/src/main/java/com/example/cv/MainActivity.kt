package com.example.cv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cv.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

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
                    tab.text = "About me"
                }
                2->{
                    tab.text = "Work"
                }
                3->{
                    tab.text = "Contact"
                }
            }
        }.attach()

        floating_action_button.setOnClickListener {

            //send data from MainActivity to HomeFragment using Bundle
            val bundle = Bundle()
            bundle.putString("category", "ComPro student at MIU.")
            bundle.putString("name", "Abdulhakim Edao")
            val fragment = HomeFragment()
            fragment.arguments = bundle

//            val intent2 = Intent(this, HomeFragment::class.java)
//            intent2.putExtra("category", "ComPro student at MIU.")
//            intent2.putExtra("name", "Abdulhakim Edao")
//            startActivity(intent2)
            var intent = Intent(this, AddSkill::class.java)
            startActivity(intent)
        }
    }
}