package com.egs.demo_zsports.features.splash.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.egs.demo_zsports.R
import com.egs.demo_zsports.features.login.LoginActivity
import com.egs.demo_zsports.helpers.NavigationHelper


class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed({
            NavigationHelper.redirectTo(activity!!, LoginActivity::class.java)
        }, 3000)
    }
}
