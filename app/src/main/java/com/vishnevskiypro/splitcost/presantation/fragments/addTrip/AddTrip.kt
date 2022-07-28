package com.vishnevskiypro.splitcost.presantation.fragments.addTrip

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.vishnevskiypro.splitcost.R
import com.vishnevskiypro.splitcost.databinding.FragmentAddTripBinding
import com.vishnevskiypro.splitcost.databinding.FragmentTripBinding
import com.vishnevskiypro.splitcost.model.Trip
import com.vishnevskiypro.splitcost.presantation.fragments.listTrip.FragmentTrip
import com.vishnevskiypro.splitcost.viewmodel.TripViewModel


class AddTrip : Fragment(R.layout.fragment_add_trip) {

    private lateinit var binding: FragmentAddTripBinding
    private lateinit var mTripViewModel: TripViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddTripBinding.inflate(layoutInflater, container, false)
        mTripViewModel = ViewModelProvider(this).get(TripViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonAddTrip.setOnClickListener {
            insertTripToDatabase()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun insertTripToDatabase() {
        val id = 0
        val tripName = binding.nameTripInput.text.toString()
        val tripPersons = binding.personTripInput.toString()
        val tripAvatar = "train"

        if(inputCheck(tripName, tripPersons)){
            val trip = Trip(id, tripName, tripPersons, tripAvatar)
            mTripViewModel.addTripToTable(trip)
            Toast.makeText(requireContext(), "Trip added", Toast.LENGTH_LONG).show()
            val fragmentTrip = FragmentTrip()
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.containerMainActivity, fragmentTrip)
                commit()
            }

        } else {
            Toast.makeText(requireContext(), "Fill All Fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(tripName: String, tripPersons: String ): Boolean {
        return !(TextUtils.isEmpty(tripName) && TextUtils.isEmpty(tripPersons))
    }
}