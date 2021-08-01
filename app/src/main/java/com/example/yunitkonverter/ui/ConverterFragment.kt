package com.example.yunitkonverter.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.example.yunitkonverter.R
import com.example.yunitkonverter.databinding.FragmentConverterBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class ConverterFragment : Fragment() {
    lateinit var binding : FragmentConverterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentConverterBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_converter, container, false)
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
        val categoriesAdapter = ArrayAdapter(requireActivity(),R.layout.support_simple_spinner_dropdown_item,length)
        val measurementsAdapter = ArrayAdapter(requireActivity(),R.layout.support_simple_spinner_dropdown_item,measurements)
        binding.spCategories.adapter = categoriesAdapter
        binding.spMeasurements.adapter=measurementsAdapter
        return binding.root
    }
}
