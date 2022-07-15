package com.example.discountapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.discountapp.databinding.ShopItemBinding

class ShopItemAdapter : RecyclerView.Adapter<ShopItemAdapter.ViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    val shopList = listOf(
        ShopItem(R.drawable.lenta, "Лента"),
        ShopItem(R.drawable.okey, "krutoy2"),
        ShopItem(R.drawable.magnit, "krutoy3"),
        ShopItem(R.drawable.pyaterochka, "krutoy4"),
        ShopItem(R.drawable.metro, "krutoy5"),
        ShopItem(R.drawable.vkusvil, "krutoy6"),
    )

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }


    class ViewHolder(item: View, listener: onItemClickListener) : RecyclerView.ViewHolder(item){
        val binding = ShopItemBinding.bind(item)

        init{
            item.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

        fun bind(shop: ShopItem){
            binding.shopImage.setImageResource(shop.ImageUrl)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shop_item, parent, false)
        return ViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(shopList[position])
    }

    override fun getItemCount(): Int {
        return shopList.size
    }


}