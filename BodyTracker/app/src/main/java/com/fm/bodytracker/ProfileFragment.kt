package com.fm.bodytracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.fm.bodytracker.database.Profile
import com.fm.bodytracker.databinding.FragmentProfileBinding
import com.fm.bodytracker.models.BodyTrackerViewModel
import com.fm.bodytracker.models.BodyTrackerViewModelFactory

// TODO: Rename parameter arguments, choose names that match


class ProfileFragment : Fragment() {

    lateinit var profile :Profile

   private val viewModel: BodyTrackerViewModel by activityViewModels{
    BodyTrackerViewModelFactory(
    (activity?.application as ProfileApplication).database
    .profileDao()
    )
}

    private var _binding : FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       // _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile,container,false)
        _binding = FragmentProfileBinding.inflate(inflater,container,false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    private fun isEntryValid():Boolean {
        return viewModel.isEntryValid(
            binding.edtName.text.toString(),
            binding.edtHeight.text.toString(),
            viewModel.unitHeight.toString(),
            binding.edtBirthDate.toString(),
            viewModel.gender.toString()

        )
    }

    private fun addNewItem() {
        if (isEntryValid()) {
            viewModel.addNewItem(1,
            binding.edtName.text.toString(),
            binding.edtHeight.text.toString(),
            viewModel.unitHeight.value.toString(),
            viewModel.birthdaydte.value.toString(),
            viewModel.gender.value.toString()
            )

          //  val action = AddItemFragmentDirections.actionAddItemFragmentToItemListFragment()
         //   findNavController().navigate(action)
        }
    }

    private fun bind(profile: Profile) {
        binding.apply {
            edtName.setText(profile.name)
            edtBirthDate.setText(profile.dateOfBirth)
            edtHeight.setText(profile.height.toString())
            when (profile.hUnit) {
                "Centimeters" -> spMeasuresUnit.setSelection(0)
                "Feet" -> spMeasuresUnit.setSelection(1)
                else -> spMeasuresUnit.setSelection(2)
            }
            when (profile.gender) {
               "Male" -> rbMale.setChecked(true);
                else -> rbFemale.setChecked(true);
            }
        }
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

        viewModel.retrieveItem(1).observe(this.viewLifecycleOwner){
                selectedItem ->
            profile = selectedItem
            bind(profile)
        }

        binding.saveButton.setOnClickListener { addNewItem() }

    }



}