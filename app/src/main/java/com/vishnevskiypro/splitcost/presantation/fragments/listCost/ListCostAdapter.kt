package com.vishnevskiypro.splitcost.presantation.fragments.listCost

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vishnevskiypro.splitcost.R
import com.vishnevskiypro.splitcost.databinding.CostItemBinding
import com.vishnevskiypro.splitcost.model.Cost

class ListCostAdapter : RecyclerView.Adapter<ListCostAdapter.CostHolder>(){

    private var costList = emptyList<Cost>()

    fun setCostList(costsList: List<Cost>){
        this.costList = costsList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CostHolder {
        return CostHolder(LayoutInflater.from(parent.context).inflate(R.layout.cost_item, parent, false))
    }


    override fun onBindViewHolder(holder: CostHolder, position: Int) {
        holder.bind(costList[position])
    }


    override fun getItemCount(): Int {
        return costList.size
    }

    class CostHolder(view: View) : RecyclerView.ViewHolder(view){
        private val binding = CostItemBinding.bind(view)

        fun bind(cost: Cost){
            binding.apply {
                dateCost.text = cost.date
                descriptionCost.text = cost.description
                paidBy.text = cost.user_id.toString()
                amountCost.text = cost.amount.toString()
                avatarImage.setImageResource(R.drawable.avatar)
            }
        }
    }
}