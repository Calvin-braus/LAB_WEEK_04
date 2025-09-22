package com.example.lab_week_04

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

// List tab yang akan ditampilkan
val TABS_FIXED = listOf(
    R.string.starbucks_title,
    R.string.janjijiwa_title,
    R.string.kopikenangan_title
)

val TABS_DESC = listOf(
    R.string.starbucks_desc,
    R.string.janjijiwa_desc,
    R.string.kopikenangan_desc
)

class CafeAdapter(private val fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = TABS_FIXED.size

    override fun createFragment(position: Int): Fragment {
        val desc = fragment.requireContext().getString(TABS_DESC[position])
        return CafeDetailFragment.newInstance(desc)
    }
}


