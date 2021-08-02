package com.example.yunitkonverter.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.widget.ResourceManagerInternal.get
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.example.yunitkonverter.R
import com.example.yunitkonverter.databinding.FragmentConverterBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.reflect.Array.get
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class ConverterFragment : Fragment() {
    lateinit var binding : FragmentConverterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_converter, container, false)
        val length = listOf(
            "Kilometre",
            "Miles",
            "Metre",
            "Centimetre",
            "Millimetre",
            "Micrometre",
            "Nanometer",
            "Yard",
            "Feet",
            "Inch",
            "Nautical Mile",
            "Furlong",
            "Light Year"
        )


        val measurements = listOf("Length","Area","Speed","Currency","Time","Volume","Mass")
        val categoriesAdapter = ArrayAdapter(requireActivity(),R.layout.item_spinner,length)
        val measurementsAdapter = ArrayAdapter(requireActivity(),R.layout.item_spinner2,measurements)
        binding.spCategories.adapter = categoriesAdapter
        binding.spMeasurements.adapter=measurementsAdapter

        binding.spMeasurements.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        showDate()
        return binding.root
    }

    //A function to show today's date on the screen
    private fun showDate(){
        val today = Calendar.DATE
        val dateFormat = SimpleDateFormat("dd.MM.yyy")
        val currentDate = dateFormat.format(Date())
        binding.tvDate.text =currentDate
    }
}
