package com.example.weatherapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter : RecyclerView.Adapter<adapter.viewholder>() {

    var  source :MutableList<WeatherItem>?=null

    class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var txtmain :TextView = itemView.findViewById(R.id.txtmain)
        var txtdescription :TextView = itemView.findViewById(R.id.txtdescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return viewholder(view)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
      var items = source?.get(position)
        holder.txtmain.text = items?.main
        holder.txtdescription.text = items?.description
    }

    override fun getItemCount(): Int {
        return source?.size ?:0
    }

    fun getdata(data1 : MutableList<WeatherItem>){
        source=data1
        notifyDataSetChanged()

    }

}