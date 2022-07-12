package com.example.discountapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ShopsFragment : Fragment(){

    val shopList = listOf(
        ShopItem(R.drawable.image2, "krutoy1"),
        ShopItem(R.drawable.image2, "krutoy2"),
        ShopItem(R.drawable.image2, "krutoy3"),
        ShopItem(R.drawable.image2, "krutoy4"),
        ShopItem(R.drawable.image2, "krutoy5"),
        ShopItem(R.drawable.image2, "krutoy6"),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_shops, container, false)

        initRecycleView(view)

        return view
    }

    private fun initRecycleView(view: View){

        var adapter = ShopItemAdapter()
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(activity, 2)

        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : ShopItemAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                var intent = Intent(this@ShopsFragment.context, SecondActivity::class.java)
                startActivity(intent)
            }

        })
    }


}