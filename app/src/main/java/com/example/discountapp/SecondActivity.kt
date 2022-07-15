package com.example.discountapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.example.discountapp.databinding.ActivitySecondBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import java.io.IOException

class SecondActivity : AppCompatActivity() {

    private var parseItems = mutableListOf<ProductItem>()
    private val adapter = ParseAdapter()

    lateinit var secondBinding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        secondBinding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(secondBinding.root)
        initRecycleView()
        GlobalScope.launch {
            GetData()
            Log.d("ParseInfo", "${parseItems.size}")
        }
    }

    private fun initRecycleView(){
        secondBinding.apply{
            secondRecyclerView.layoutManager = GridLayoutManager(this@SecondActivity,2)
            secondBinding.secondRecyclerView.adapter = adapter
        }
    }

    private fun GetData() {
        try {
            var doc = Jsoup.connect("https://lenta.com/catalog/moloko-syr-yajjco/syr/").get()
            var data = doc.select("div.sku-card-small-container")
            var size = data.size

            for (i in 0 until size) {
                var imgUrl = doc
                    .select("div.square__inner")
                    .select("img")
                    .eq(i)
                    .attr("src")

                var title = doc
                    .select("div.sku-card-small-header")
                    .eq(i)
                    .text()
                parseItems.add(ProductItem(imgUrl, title))
            }
            GlobalScope.launch(Dispatchers.Main){
                adapter.set(parseItems)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}