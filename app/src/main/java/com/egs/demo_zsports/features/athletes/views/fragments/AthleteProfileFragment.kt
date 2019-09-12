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
import com.egs.demo_zsports.databinding.FragmentAthleteProfileBinding
import com.egs.demo_zsports.features.athletes.viewmodel.AthleteViewModel
import com.egs.demo_zsports.features.profile.ProfileActivity
import com.egs.demo_zsports.helpers.NavigationHelper
import kotlinx.android.synthetic.main.fragment_athlete_profile.*
import kotlinx.android.synthetic.main.navigation_toolbar.*
import java.text.SimpleDateFormat
import java.util.*

class AthleteProfileFragment : Fragment() {

    private lateinit var binding: FragmentAthleteProfileBinding
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
        model.showScheduleDialog.set(false)
        val sdf = SimpleDateFormat("dd/M/yyyy")
        val currentDate = sdf.format(Date())

        model.today.set(currentDate)
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_athlete_profile, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(BR.viewModel, model)
        initEvents()
    }

    private fun initEvents() {
        nv_back.setOnClickListener { activity!!.onBackPressed() }
        nv_profile.setOnClickListener { NavigationHelper.redirectTo(activity!!, ProfileActivity::class.java) }
    }
}
