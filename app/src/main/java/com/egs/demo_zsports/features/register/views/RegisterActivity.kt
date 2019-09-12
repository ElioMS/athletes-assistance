package com.egs.demo_zsports.features.register.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.egs.demo_zsports.BR
import com.egs.demo_zsports.R
import com.egs.demo_zsports.databinding.ActivityRegisterBinding
import com.egs.demo_zsports.features.athletes.viewmodel.AthleteViewModel
import com.egs.demo_zsports.features.register.viewmodel.RegisterViewModel
import com.egs.demo_zsports.features.register.views.dialogs.RegisterSuccessDialog
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterNavigator {


    private lateinit var model: RegisterViewModel
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        model = ViewModelProviders.of(this)[RegisterViewModel::class.java]
        model.setNavigator(this)
        binding.setVariable(BR.viewModel, model)
        binding.executePendingBindings()
        initEvents()
    }

    override fun showSuccessDialog() {
        val dialog = RegisterSuccessDialog(this, this)
        dialog.show()
    }

    private fun initEvents() {
        go_back.setOnClickListener { onBackPressed() }
    }
}
