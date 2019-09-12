package com.egs.demo_zsports.features.athletes.views.fragments

import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.egs.demo_zsports.BR
import com.egs.demo_zsports.R
import com.egs.demo_zsports.databinding.FragmentAthleteBinding
import com.egs.demo_zsports.features.athletes.viewmodel.AthleteViewModel
import com.egs.demo_zsports.features.athletes.views.AthleteNavigator
import com.egs.demo_zsports.features.login.LoginActivity
import com.egs.demo_zsports.helpers.NavigationHelper
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.io.File
import java.io.FileOutputStream
import java.net.URL
import android.content.Intent
import android.net.Uri
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.egs.demo_zsports.features.profile.ProfileActivity
import com.egs.demo_zsports.model.Athlete
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.navigation_toolbar.*
import org.json.JSONObject


class AthleteFragment : Fragment(), AthleteNavigator {

    private lateinit var binding: FragmentAthleteBinding
    private lateinit var model: AthleteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        model = activity?.run {
            ViewModelProviders.of(this)[AthleteViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        model.setNavigator(this)
        model.loadAthletes()
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_athlete, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navigationBottom: BottomNavigationView = view.findViewById(R.id.navigation_bottom)
        navigationBottom.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        binding.setVariable(BR.viewModel, model)
        initEvents()
    }

    override fun showAthleteProfile() {
        NavigationHelper.changeFragment(fragmentManager!!, R.id.main_container, AthleteProfileFragment(), "AthleteProfileFragment")
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_assistance -> {

                AndroidNetworking.get("http://192.168.1.9:8000/api/v1/athletes/pdf")
                    .setPriority(Priority.MEDIUM)
                    .build()
                    .getAsJSONObject(object : JSONObjectRequestListener {
                        override fun onResponse(response: JSONObject) {
                            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://192.168.1.9:8000/${response["data"]}.pdf"))
                            startActivity(browserIntent)
                        }

                        override fun onError(error: ANError) {
                            Log.e("ddd", error.errorBody.toString())
                        }
                    })


            }
            R.id.navigation_logout -> {
                NavigationHelper.redirectTo(activity!!, LoginActivity::class.java)
            }
        }
        false
    }

    private fun initEvents() {
        nv_back.visibility = View.GONE
        nv_profile.setOnClickListener { NavigationHelper.redirectTo(activity!!, ProfileActivity::class.java) }
    }

}
