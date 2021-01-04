package com.example.dindin_miniassign

import android.graphics.Color
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.reflect.KProperty
import com.example.dindin_miniassign.ViewPagerFragment as ViewPagerFragment1


private const val NUM_PAGES = 3
private const val NUM_PAGES_2 = 4

class MainActivity : AppCompatActivity() {


    private lateinit var viewPager: ViewPager2
    private lateinit var viewPager_2: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var tabLayout_2: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewPager = findViewById(R.id.viewpager)
        viewPager_2 = findViewById(R.id.viewpager_2)
        tabLayout = findViewById(R.id.tablayout)
        tabLayout_2 = findViewById(R.id.tablayout_2)


        val pagerAdapter = ScreenSlidePagerAdapter(this)
        viewPager.adapter = pagerAdapter

        val pagerAdapter2 = ScreenSlidePagerAdapter_2(this)
        viewPager_2.adapter = pagerAdapter2


        TabLayoutMediator(tabLayout, viewPager)
        { tab, position ->}.attach()

        TabLayoutMediator(tabLayout_2, viewPager_2)
        { tab, position ->

        }.attach()
    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }





    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

        override fun createFragment(position: Int): Fragment {

            val  fragment : ViewPagerFragment1 = com.example.dindin_miniassign.ViewPagerFragment()

            when(position){
                0 -> fragment.arguments = Bundle().apply {
                    putString("view","1")
                    Log.d("positionfrag","1")
                }


                1 -> fragment.arguments = Bundle().apply {
                    putString("view","2")
                    Log.d("positionfrag","2")
                }


                2 -> fragment.arguments = Bundle().apply {
                    putString("view","3")
                    Log.d("positionfrag","3")

                }

            }


            return fragment
        }

        override fun getItemCount(): Int = NUM_PAGES
    }

    private inner class ScreenSlidePagerAdapter_2(fa: FragmentActivity) : FragmentStateAdapter(fa) {

        override fun createFragment(position: Int): Fragment {

            val  fragment : ViewPagerFragment_2 = com.example.dindin_miniassign.ViewPagerFragment_2()

            when(position){
                0 -> fragment.arguments = Bundle().apply {
                    putString("view","1")
                    Log.d("positionfrag","1")
                }


                1 -> fragment.arguments = Bundle().apply {
                    putString("view","2")
                    Log.d("positionfrag","2")
                }


                2 -> fragment.arguments = Bundle().apply {
                    putString("view","3")
                    Log.d("positionfrag","3")

                }

            }


            return fragment
        }

        override fun getItemCount(): Int = NUM_PAGES_2
    }
}