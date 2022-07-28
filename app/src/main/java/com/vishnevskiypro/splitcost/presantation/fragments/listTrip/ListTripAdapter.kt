package com.vishnevskiypro.splitcost.presantation.fragments.listTrip

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vishnevskiypro.splitcost.R
import com.vishnevskiypro.splitcost.databinding.TripItemBinding
import com.vishnevskiypro.splitcost.model.Trip

class ListTripAdapter : RecyclerView.Adapter<ListTripAdapter.TripHolder>(){

    private var tripList = emptyList<Trip>()

    fun setTripList(trips: List<Trip>){
        this.tripList = trips
        notifyDataSetChanged()
    }

    class TripHolder(view: View) : RecyclerView.ViewHolder(view){
        private val binding = TripItemBinding.bind(view)
        fun bind(trip: Trip){
            binding.apply {
                tripName.text = trip.tripName
                tripAvatarImage.setImageResource(R.drawable.ic_baseline_train_24)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripHolder {
        return TripHolder(LayoutInflater.from(parent.context).inflate(R.layout.trip_item, parent, false))
    }


    override fun onBindViewHolder(holder: TripHolder, position: Int) {
        holder.bind(tripList[position])
    }


    override fun getItemCount(): Int {
        return tripList.size
    }

}