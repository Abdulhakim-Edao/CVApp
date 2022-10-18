package com.example.cv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*


class ExperienceFragment : Fragment() {

    lateinit var experienceAdapter: ExperienceAdapter


    var string1:ArrayList<String> = ArrayList()
    var string2:ArrayList<String> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        setUpExperienceModels()
        return inflater.inflate(R.layout.fragment_experience, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        experienceAdapter = ExperienceAdapter(requireContext(), experienceList)
        rvv.adapter = experienceAdapter
        rvv.layoutManager = LinearLayoutManager(activity)
        rvv.hasFixedSize()
    }

    var experienceList: ArrayList<ExperienceModel> = ArrayList()
    var images: Array<Int> = arrayOf(
        R.drawable.google,
        R.drawable.meta,
        R.drawable.amazon,
    )

    // create a model class for each of our items
    private fun setUpExperienceModels(){
        // get the array from the resources
        var companyName = resources.getStringArray(R.array.company_name)
        var jobTitle = resources.getStringArray(R.array.job_title)
        var date = resources.getStringArray(R.array.date)
        var description = resources.getStringArray(R.array.description)


        // create a instance of the foodModel with each item in the array

        for(i in companyName.indices){
            experienceList.add(ExperienceModel(companyName[i], jobTitle[i], date[i], images[i], description[i]))
        }


    }


}