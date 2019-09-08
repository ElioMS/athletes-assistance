package com.egs.demo_zsports.features.athletes.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.egs.demo_zsports.R
import com.egs.demo_zsports.features.athletes.views.fragments.AthleteFragment
import com.egs.demo_zsports.features.login.LoginActivity
import com.egs.demo_zsports.features.profile.ProfileActivity
import com.egs.demo_zsports.helpers.NavigationHelper
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.navigation_toolbar.*

class AthletesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_athletes)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_container, AthleteFragment(), "AthleteFragment")
        fragmentTransaction.commit()

        initEvents()


    }

    private fun initEvents() {
        nv_back.visibility = View.GONE
        nv_profile.setOnClickListener { NavigationHelper.redirectTo(this, ProfileActivity::class.java) }
    }


}
