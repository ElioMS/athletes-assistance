package com.egs.demo_zsports.features.register.views.dialogs

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.egs.demo_zsports.R
import com.egs.demo_zsports.features.login.LoginActivity
import com.egs.demo_zsports.helpers.NavigationHelper
import kotlinx.android.synthetic.main.dialog_register_success.*

class RegisterSuccessDialog (context: Context, val activity: Activity) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_register_success)
        initEvents()
    }

    private fun initEvents() {
        btn_close_dialog.setOnClickListener {
            this.dismiss()
            NavigationHelper.redirectTo(activity, LoginActivity::class.java)
        }
    }
}