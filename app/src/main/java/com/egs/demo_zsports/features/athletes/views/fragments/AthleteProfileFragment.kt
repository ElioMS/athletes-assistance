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
import kotlinx.android.synthetic.main.fragment_athlete_profile.*

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
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_athlete_profile, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setVariable(BR.viewModel, model)
    }


}
