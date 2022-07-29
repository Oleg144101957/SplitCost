package com.vishnevskiypro.splitcost.presantation.fragments.listTrip

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.vishnevskiypro.splitcost.R
import com.vishnevskiypro.splitcost.databinding.TripItemBinding
import com.vishnevskiypro.splitcost.model.Trip
import com.vishnevskiypro.splitcost.presantation.fragments.listCost.FragmentCost

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
                listPersonsOfTrip.text = trip.tripPerson
                tripAvatarImage.setImageResource(R.drawable.ic_baseline_train_24)
                tripLayout.setOnClickListener {

                    val action = FragmentTripDirections.actionFragmentTripToFragmentCost2(trip)
                    binding.root.findNavController().navigate(action)

                }
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