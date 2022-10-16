package com.example.cv

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyAdapter(fragmentActivity: FragmentActivity):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 4

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->HomeFragment()
            1->AboutmeFragment()
            2->ExperienceFragment()
            3->ContactFragment()
            else->Fragment()
        }
    }
}