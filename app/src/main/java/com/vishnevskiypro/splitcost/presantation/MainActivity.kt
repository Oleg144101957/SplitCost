package com.vishnevskiypro.splitcost.presantation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.vishnevskiypro.splitcost.R
import com.vishnevskiypro.splitcost.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }


        val intent = Intent(this, CostScreen::class.java)



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


//        val myAdapter= MyAdapter(arrayList)
//        recyclerView.layoutManager=LinearLayoutManager(this)
//        recyclerView.adapter= myAdapter


        //Let's code

    }
}