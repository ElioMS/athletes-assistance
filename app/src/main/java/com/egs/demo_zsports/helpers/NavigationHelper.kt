package com.egs.demo_zsports.helpers

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

object NavigationHelper {

    fun redirectTo(activity: Activity, c: Class<*>) {
        val page = Intent(activity, c)
        activity.startActivity(page)
    }

    fun redirecToWithData(activity: Activity, c: Class<*>, data: Int) {
        val page = Intent(activity, c)
        page.putExtra("data", data)
        activity.startActivity(page)
    }

    fun changeFragment(fragmentManager: FragmentManager, layout: Int, newFrag: Fragment, fragName: String) {
        fragmentManager!!.beginTransaction()
            .replace(layout, newFrag)
            .addToBackStack(fragName)
            .commit()
    }
}