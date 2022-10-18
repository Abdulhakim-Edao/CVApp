package com.example.cv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.home_list.view.*

class HomeAdapter(var context: Context, var str1:ArrayList<String>, var str2:ArrayList<String>) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    var string1 = str1

    var string2 = str2

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent?.context).inflate(R.layout.home_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.linear.apply{
            tv1.text = string1[position]
            tv2.text = string2[position]
        }

//        holder.itemView.ll.setOnClickListener{
//            var intent = Intent(this.activity, EditHome::class.java)
//
//            intent.putExtra("header", string1[position])
//            intent.putExtra("body", string2[position])
//            startActivity(intent)
//        }
    }

    override fun getItemCount(): Int {
        return string2.size
    }
}