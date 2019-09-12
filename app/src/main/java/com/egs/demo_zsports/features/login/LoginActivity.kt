package com.egs.demo_zsports.features.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.egs.demo_zsports.R
import com.egs.demo_zsports.features.athletes.views.AthletesActivity
import com.egs.demo_zsports.features.register.views.RegisterActivity
import com.egs.demo_zsports.helpers.NavigationHelper
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initEvents()
    }

    private fun initEvents() {
        btn_log_in.setOnClickListener { NavigationHelper.redirectTo(this, AthletesActivity::class.java) }
        btn_create_account.setOnClickListener { NavigationHelper.redirectTo(this, RegisterActivity::class.java) }
    }
}
