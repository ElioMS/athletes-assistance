package com.egs.demo_zsports.features.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.egs.demo_zsports.R
import com.egs.demo_zsports.features.athletes.views.AthletesActivity
import com.egs.demo_zsports.helpers.NavigationHelper
import kotlinx.android.synthetic.main.navigation_toolbar.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initEvents()
    }

    private fun initEvents() {
        nv_profile.visibility = View.GONE
        nv_back.setOnClickListener { NavigationHelper.redirectTo(this, AthletesActivity::class.java) }
    }
}
