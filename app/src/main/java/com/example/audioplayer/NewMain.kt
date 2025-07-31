package com.example.audioplayer

import android.annotation.SuppressLint
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

class NewMain : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        enableEdgeToEdge()
        setContentView(R.layout.main_layout_new)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main_layout_new)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val viewPager = findViewById<ViewPager2>(R.id.fragmentPager)
        viewPager.adapter = MyViewPagerAdapter(
            fragmentManager = supportFragmentManager,
            lifecycle = lifecycle
        )
    }

    class MyViewPagerAdapter(
        fragmentManager: FragmentManager,
        lifecycle: Lifecycle
    ) : FragmentStateAdapter(fragmentManager, lifecycle){
        override fun getItemCount(): Int {
            return 4
        }

        override fun createFragment(position: Int): Fragment {
            return when (position){
                0 -> Search_Fragment()
                1 -> Favorites_Fragment()
                2 -> Responses_Fragment()
                else -> Profile_Fragment()
            }
        }

    }


    private fun setSearchActivity(){
        findViewById<Button>(R.id.buttonSearch).setOnClickListener {
            val intent = Intent(this,Search_Fragment::class.java)
            startActivity(intent)
        }
    }

    private fun setFavoritesActivity(){
        findViewById<Button>(R.id.buttonFavorites).setOnClickListener {
            val intent = Intent(this,Favorites_Fragment::class.java)
            startActivity(intent)
        }
    }

    private fun setResponsesActivity(){
        findViewById<Button>(R.id.buttonResponse).setOnClickListener {
            val intent = Intent(this,Responses_Fragment::class.java)
            startActivity(intent)
        }
    }

    private fun setProfileActivity(){
        findViewById<Button>(R.id.buttonProfile).setOnClickListener {
            val intent = Intent(this,Profile_Fragment::class.java)
            startActivity(intent)
        }
    }
}