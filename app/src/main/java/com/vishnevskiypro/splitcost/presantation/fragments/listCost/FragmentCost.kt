package com.vishnevskiypro.splitcost.presantation.fragments.listCost

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
import com.vishnevskiypro.splitcost.presantation.BottomAppBarCutCornersTopEdge
import com.vishnevskiypro.splitcost.presantation.fragments.addCost.AddCost


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
                replace(R.id.containerMainActivity, fragmentAddCost)
                addToBackStack(null)
                commit()
            }

        }
    }

}