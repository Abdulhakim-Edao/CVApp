package com.example.cv

import android.app.Activity.RESULT_OK
import android.content.Intent
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

        //recieve data from MainActivity to HomeFragment using Bundle
        val bundle = arguments
        if (bundle != null) {
            val category = bundle.getString("category").toString()
            val name = bundle.getString("name").toString()
            string1.add(category)
            string2.add(name)
        }

//        val cat = arguments?.getString("category")
//        val name = arguments?.getString("name")
        string1.add("About Me")
        string1.add("Achievements")
        string1.add("Blogs")
        string1.add("Honors & Awards")
        string1.add("Achievements & Awards")
        string1.add("Blogs & Publications")
//        if(cat != null && name != null){
//            string2.add(cat)
//            string2.add(name)
//        }

        string2.add("Abdulhakim Edao, ComPro student at MIU.")
        string2.add("I have won 3rd place in the 2019 MIU Hackathon.")
        string2.add("I have a blog on Medium.")
        string2.add("Abdulhakim Edao, ComPro student at MIU.")
        string2.add("I have won 3rd place in the 2019 MIU Hackathon.")
        string2.add("I have a blog on Medium.")





        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    //update the recyclerview when the fragment is resumed from the AddSkill activity
    override fun onResume() {
        super.onResume()
        myAdapter.notifyDataSetChanged()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myAdapter = HomeAdapter(requireContext(), string1, string2)
        rvv.adapter = myAdapter
        rvv.layoutManager = LinearLayoutManager(activity)
        rvv.hasFixedSize()

    }

    //update the recyclerview when the fragment is resumed from the AddSkill activity after the view is created
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        myAdapter.notifyDataSetChanged()
    }

    // override function to update the data in the recyclerview when the user add new skill in AddSkill.kt




}