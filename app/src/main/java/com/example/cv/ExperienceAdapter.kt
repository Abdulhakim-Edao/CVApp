package com.example.cv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.experience_list.view.*
import kotlinx.android.synthetic.main.fragment_experience.view.*
import kotlinx.android.synthetic.main.home_list.view.*


class ExperienceAdapter(var context: Context, var experienceList: ArrayList<ExperienceModel>) : RecyclerView.Adapter<ExperienceAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.experience_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


            holder.itemView.jobTitle.text = experienceList[position].jobTitle
            holder.itemView.companyName.text = experienceList[position].companyName
            holder.itemView.dateFrom.text = experienceList[position].dateFrom
            holder.itemView.logo.setImageResource( experienceList[position].image)
            holder.itemView.description.text = experienceList[position].description

//        holder.itemView.linear.apply{
//            jobTitle.text = experienceList[position].jobTitle
//            tv2.text = string2[position]
//        }

    }




    override fun getItemCount(): Int {
        return experienceList.size
    }


}