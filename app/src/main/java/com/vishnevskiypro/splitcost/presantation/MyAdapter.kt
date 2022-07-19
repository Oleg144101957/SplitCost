package com.vishnevskiypro.splitcost.presantation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vishnevskiypro.splitcost.R
import kotlinx.android.synthetic.main.cost_item.view.*

class MyAdapter (val arrayList:ArrayList<Model>):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        fun bindItems(model: Model){
            itemView.paidBy.text=model.paidBy
            itemView.dateCost.text=model.date
            itemView.description_cost.text=model.description
            itemView.avatarImage.setImageResource(model.avatar)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cost_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

    }
}