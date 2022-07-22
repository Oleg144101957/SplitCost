package com.vishnevskiypro.splitcost.presantation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vishnevskiypro.splitcost.R

class CostScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cost_screen)

        val fragmentCost = FragmentCost(this)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.containerCostScreen, fragmentCost)
            commit()
        }
    }
}