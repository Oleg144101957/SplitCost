package com.vishnevskiypro.splitcost.presantation

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment
import com.google.android.material.shape.MaterialShapeDrawable
import com.vishnevskiypro.splitcost.R
import com.vishnevskiypro.splitcost.databinding.FragmentCostBinding


class FragmentCost(context: Context) : Fragment(R.layout.fragment_cost) {

    lateinit var binding: FragmentCostBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCostBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val topEdge: BottomAppBarTopEdgeTreatment = BottomAppBarCutCornersTopEdge(
            binding.bottomAppBar.fabCradleMargin,
            binding.bottomAppBar.fabCradleRoundedCornerRadius,
            binding.bottomAppBar.cradleVerticalOffset)
        val babBackground = binding.bottomAppBar.background as MaterialShapeDrawable
        //It requires 1.1.0-alpha10
        babBackground.shapeAppearanceModel = babBackground.shapeAppearanceModel
            .toBuilder()
            .setTopEdge(topEdge)
            .build()
        binding.addCost.setColorFilter(Color.WHITE)

        val fragmentAddCost = AddCost()

        binding.addCost.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.containerCostScreen, fragmentAddCost)
                addToBackStack(null)
                commit()
            }

        }

        val arrayList= ArrayList<Model>()
        arrayList.add(Model("Date: 24.10.2022 12:35","Paid by Blagoveshenskiy Ivan","MCDonalds 125$",R.drawable.avatar))
        arrayList.add(Model("Date: 24.10.2022 12:35","Paid by Vishya","Gas 25$",R.drawable.avatar))
        arrayList.add(Model("Date: 24.10.2022 12:35","Paid by Oleg","Hotel 12$",R.drawable.avatar))
        arrayList.add(Model("Date: 24.10.2022 12:35","Paid by Ivan","Train 75$",R.drawable.avatar))
        arrayList.add(Model("Date: 24.10.2022 12:35","Paid by Slim","Taxi 25$",R.drawable.avatar))
        arrayList.add(Model("Date: 24.10.2022 12:35","Paid by Den","Drugs 1250$",R.drawable.avatar))
        arrayList.add(Model("Date: 24.10.2022 12:35","Paid by Blagoveshenskiy Ivan","MCDonalds 125$",R.drawable.avatar))
        arrayList.add(Model("Date: 24.10.2022 12:35","Paid by Vishya","Gas 25$",R.drawable.avatar))
        arrayList.add(Model("Date: 24.10.2022 12:35","Paid by Oleg","Hotel 12$",R.drawable.avatar))
        arrayList.add(Model("Date: 24.10.2022 12:35","Paid by Ivan","Train 75$",R.drawable.avatar))
        arrayList.add(Model("Date: 24.10.2022 12:35","Paid by Slim","Taxi 25$",R.drawable.avatar))
        arrayList.add(Model("Date: 24.10.2022 12:35","Paid by Den","Drugs 1250$",R.drawable.avatar))

        val myAdapter= MyAdapter(arrayList)
        binding.recyclerViewCost.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewCost.adapter = myAdapter



    }

}