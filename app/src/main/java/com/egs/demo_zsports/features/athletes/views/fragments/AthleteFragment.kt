package com.egs.demo_zsports.features.athletes.views.fragments

import android.os.Bundle
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
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_athlete, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navigationBottom: BottomNavigationView = view.findViewById(R.id.navigation_bottom)
        navigationBottom.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        binding.setVariable(BR.viewModel, model)
//        initFragmentEvents()
    }

    override fun showAthleteProfile() {
        NavigationHelper.changeFragment(fragmentManager!!, R.id.main_container, AthleteProfileFragment(), "AthleteProfileFragment")
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_assistance -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_logout -> {
                NavigationHelper.redirectTo(activity!!, LoginActivity::class.java)
            }
        }
        false
    }

}
