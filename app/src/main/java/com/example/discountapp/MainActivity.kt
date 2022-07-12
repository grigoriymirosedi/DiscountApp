package com.example.discountapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.discountapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val shopsFragment = ShopsFragment()
    private val goodsFragment = GoodsFragment()
    private val favouriteFragment = FavouriteFragment()
    private val settingsFragment = SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setFragment(shopsFragment)

        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.shops -> { setFragment(shopsFragment) }
                R.id.goods -> { setFragment(goodsFragment) }
                R.id.favourite -> { setFragment(favouriteFragment) }
                R.id.settings -> { setFragment(settingsFragment) }
            }
            true
        }

    }

     private fun setFragment(fragment: Fragment){
         val fragmentTrans = supportFragmentManager.beginTransaction()
         fragmentTrans.replace(binding.frameLayout.id, fragment)
         fragmentTrans.commit()
     }

}