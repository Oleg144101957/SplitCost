package com.vishnevskiypro.splitcost.presantation.fragments.addCost

import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.vishnevskiypro.splitcost.R
import com.vishnevskiypro.splitcost.databinding.FragmentAddCostBinding
import com.vishnevskiypro.splitcost.model.Cost
import com.vishnevskiypro.splitcost.presantation.fragments.listCost.FragmentCost
import com.vishnevskiypro.splitcost.viewmodel.CostViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class AddCost : Fragment() {

    private lateinit var binding: FragmentAddCostBinding
    private lateinit var mCostViewModel: CostViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddCostBinding.inflate(layoutInflater, container, false)
        mCostViewModel = ViewModelProvider(this).get(CostViewModel::class.java)

        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonAdd.setOnClickListener {
            insertCostToDatabase()
        }

        super.onViewCreated(view, savedInstanceState)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun insertCostToDatabase() {
        val id: Int = 0
        val date: String = getTimeAndDateForCost()
        val description: String = binding.nameOfCost.text.toString()
        val amount: String = binding.amountTextInput.text.toString()
        val userId: String = binding.whoPaidInput.text.toString()
        val tripId: String = "1"

        if (inputCheck(description, amount, userId)){
            val cost = Cost(id, date, description, amount, userId, tripId)
            mCostViewModel.addCostToTable(cost)

            val fragmentCost = FragmentCost()
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.containerMainActivity, fragmentCost)
                commit()
            }



            Toast.makeText(requireContext(), "Cost added", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(requireContext(), "Fill all fields please", Toast.LENGTH_LONG).show()
        }



    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getTimeAndDateForCost(): String{
        val datePattern = "dd-MM-yyyy' 'HH:mm:ss"
        val formatter = DateTimeFormatter.ofPattern(datePattern)
        return LocalDateTime.now().format(formatter)
    }

    fun inputCheck(_description: String, _amount: String, _user_id: String): Boolean {
        return !(TextUtils.isEmpty(_description) && TextUtils.isEmpty(_amount) && TextUtils.isEmpty(_user_id))
    }

}