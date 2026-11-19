package com.example.ladymobile.pertemuan_12

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class TwelfthPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CatFactFragment()
            1 -> PicsumGalleryFragment()
            else -> CatFactFragment()
        }
    }
}
