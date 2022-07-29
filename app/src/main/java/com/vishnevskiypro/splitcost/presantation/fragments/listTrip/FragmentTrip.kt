package com.vishnevskiypro.splitcost.presantation.fragments.listTrip

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment
import com.google.android.material.shape.MaterialShapeDrawable
import com.vishnevskiypro.splitcost.R
import com.vishnevskiypro.splitcost.databinding.FragmentTripBinding
import com.vishnevskiypro.splitcost.presantation.BottomAppBarCutCornersTopEdge
import com.vishnevskiypro.splitcost.presantation.fragments.addTrip.AddTrip
import com.vishnevskiypro.splitcost.viewmodel.TripViewModel


class FragmentTrip : Fragment(R.layout.fragment_trip) {

    private lateinit var binding: FragmentTripBinding
    private lateinit var mTripViewModel: TripViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentTripBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val topEdge: BottomAppBarTopEdgeTreatment = BottomAppBarCutCornersTopEdge(
            binding.bottomAppBarTrip.fabCradleMargin,
            binding.bottomAppBarTrip.fabCradleRoundedCornerRadius,
            binding.bottomAppBarTrip.cradleVerticalOffset,
        )

        val babBackground = binding.bottomAppBarTrip.background as MaterialShapeDrawable
        babBackground.shapeAppearanceModel = babBackground.shapeAppearanceModel
            .toBuilder()
            .setTopEdge(topEdge)
            .build()
        binding.addTrip.setColorFilter(Color.WHITE)

        val fragmentAddTrip = AddTrip()

        binding.addTrip.setOnClickListener {

            parentFragmentManager.beginTransaction().apply {
                replace(R.id.containerMainActivity, fragmentAddTrip)
                addToBackStack(null)
                commit()
            }
        }

        val tripAdapter = ListTripAdapter()
        val recyclerViewTrip = binding.recyclerViewTrip
        recyclerViewTrip.adapter = tripAdapter
        recyclerViewTrip.layoutManager = LinearLayoutManager(requireContext())

        mTripViewModel = ViewModelProvider(this).get(TripViewModel::class.java)
        mTripViewModel.readAllTrips.observe(
            viewLifecycleOwner, Observer { trip ->
                tripAdapter.setTripList(trip)
            }
        )

        super.onViewCreated(view, savedInstanceState)
    }
}