package com.example.discountapp

import android.content.Context
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.discountapp.databinding.ProductItemBinding
import com.squareup.picasso.Picasso
import org.jsoup.helper.DataUtil.load

class ParseAdapter() : RecyclerView.Adapter<ParseAdapter.ViewHolder>() {

    private var list = mutableListOf<ProductItem>()

    private lateinit var context : Context

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item){
        private lateinit var parseItem: ProductItem
        var binding = ProductItemBinding.bind(item)


        fun bind(parseItem: ProductItem){
            this.parseItem = parseItem
            binding.textView2.text = parseItem.title
            Picasso.get().load(parseItem.itemUrl).into(binding.imageView)
        }

    }

    fun set(list: MutableList<ProductItem>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParseAdapter.ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])

    }

    override fun getItemCount(): Int {
        return list.size
    }

}