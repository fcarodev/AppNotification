package com.portfolio.appnotification.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.portfolio.appnotification.model.NotificationPush

class PageAdapter(val lst:NotificationPush, fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return lst.assetUrl!!.size
    }

    override fun getItem(position: Int): Fragment {
        return Fragment1(lst.assetUrl!![position])
    }


}