package com.fm.bodytracker

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.text.set
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.fm.bodytracker.databinding.FragmentProfileBinding
import com.fm.bodytracker.models.BodyTrackerViewModel
import com.fm.bodytracker.models.DatePickerFragment

// TODO: Rename parameter arguments, choose names that match


class ProfileFragment : Fragment() {


   lateinit var binding : FragmentProfileBinding
   private val viewModel: BodyTrackerViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile,container,false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.spMeasuresUnit?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                val selectedunit = binding?.spMeasuresUnit?.selectedItem.toString()
                viewModel.selectUnit(selectedunit)

            }
        }


    }



}