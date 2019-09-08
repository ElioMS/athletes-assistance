package com.egs.demo_zsports.features.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.egs.demo_zsports.R
import com.egs.demo_zsports.features.splash.fragments.SplashFragment

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_container, SplashFragment(), "SplashFragment")
        fragmentTransaction.commit()
    }
}
