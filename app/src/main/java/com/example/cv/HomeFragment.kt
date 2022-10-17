package com.example.cv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    lateinit var myAdapter: HomeAdapter
    var string1:ArrayList<String> = ArrayList()
    var string2:ArrayList<String> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val cat = arguments?.getString("category")
        val name = arguments?.getString("name")
        string1.add("About Me")
        string1.add("Achievements")
        string1.add("Blogs")
        string1.add("Honors & Awards")
        string1.add("Achievements & Awards")
        string1.add("Blogs & Publications")
        if(cat != null && name != null){
            string2.add(cat)
            string2.add(name)
        }

        string2.add("Abdulhakim Edao, ComPro student at MIU.")
        string2.add("I have won 3rd place in the 2019 MIU Hackathon.")
        string2.add("I have a blog on Medium.")
        string2.add("Abdulhakim Edao, ComPro student at MIU.")
        string2.add("I have won 3rd place in the 2019 MIU Hackathon.")
        string2.add("I have a blog on Medium.")

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myAdapter = HomeAdapter(requireContext(), string1, string2)
        rvv.adapter = myAdapter
        rvv.layoutManager = LinearLayoutManager(activity)
        rvv.hasFixedSize()
    }



}