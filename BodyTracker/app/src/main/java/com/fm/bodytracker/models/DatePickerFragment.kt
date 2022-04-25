package com.fm.bodytracker.models

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.activityViewModels
import com.fm.bodytracker.R
import java.util.*

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    private val viewModel: BodyTrackerViewModel by activityViewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        // Use the current date as the default date in the picker
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        // Create a new instance of DatePickerDialog and return it
        val setdate = DatePickerDialog(requireActivity(),R.style.customDatePickerStyle, this,  year, month, day)
        setdate.setTitle("Your Birthday")
        return  setdate

    }



    override fun onDateSet(view: DatePicker, year: Int, month: Int, day: Int) {
        viewModel.birthday(year, month, day)
    }
}