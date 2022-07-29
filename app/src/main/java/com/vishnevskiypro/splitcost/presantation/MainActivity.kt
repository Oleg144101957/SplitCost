package com.vishnevskiypro.splitcost.presantation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.vishnevskiypro.splitcost.R
import com.vishnevskiypro.splitcost.databinding.ActivityMainBinding
import com.vishnevskiypro.splitcost.presantation.fragments.listTrip.FragmentTrip
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTrip = FragmentTrip()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.containerMainActivity, fragmentTrip)
            commit()
        }
    }
}