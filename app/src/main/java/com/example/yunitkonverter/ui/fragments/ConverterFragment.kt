package com.example.yunitkonverter.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.yunitkonverter.R
import com.example.yunitkonverter.databinding.FragmentConverterBinding
import java.text.SimpleDateFormat
import java.util.*

class ConverterFragment : Fragment() {
    lateinit var binding : FragmentConverterBinding
    var itemBefore = ""
    var itemAfter = ""
    var measurementItem = Any()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_converter, container, false)
        val length = listOf(
            "Kilometre",
            "Metre",
            "Centimetre",
        )
        val time = listOf(
            "Year",
            "Month",
            "Week",
            "Day",
            "Hour",
            "Minute",
            "Second",
            "Millisecond",
            "Nanosecond",
            "Inch",
            "Nautical Mile",
            "Furlong",
            "Light Year"
        )
        val speed = listOf(
            "km/hr",
            "mi/hr",
            "mtr/sec",
        )
        val currency = listOf(
            "Us Dollar",
            "Au Dollar",
            "GBP",
            "Euro",
            "KShs",
        )
        val measurements = listOf("Length","Speed","Currency","Time")

        val measurementsAdapter = ArrayAdapter(requireActivity(),R.layout.item_spinner2,measurements)
        binding.spMeasurements.apply {
            adapter=measurementsAdapter
            height to 30
        }


        binding.spMeasurements.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            @SuppressLint("UseCompatLoadingForDrawables", "ResourceType")
            override fun onItemSelected(adapter: AdapterView<*>?, view: View?, position: Int, id: Long) {

                val item = adapter?.getItemAtPosition(position)
                when(item){
                    "Length" -> {
                        val categoriesAdapter = ArrayAdapter(requireActivity(),R.layout.item_spinner,length)
                        binding.upperLayout.background = resources.getDrawable(R.drawable.length_gradient)
                        binding.spCategoriesBefore.adapter = categoriesAdapter
                        binding.spCategoriesAfter.adapter = categoriesAdapter
                        binding.btnCalculate.setBackgroundColor(resources.getColor(R.color.etLength))
                        binding.tvResult.setTextColor(resources.getColor(R.color.etLength))
                    }
                    "Time" -> {
                        val categoriesAdapter = ArrayAdapter(requireActivity(),R.layout.item_spinner,time)
                        binding.spCategoriesBefore.adapter = categoriesAdapter
                        binding.spCategoriesAfter.adapter = categoriesAdapter
                        binding.upperLayout.background = resources.getDrawable(R.drawable.time_gradient)
                        binding.btnCalculate.setBackgroundColor(resources.getColor(R.color.time))
                        binding.tvResult.setTextColor(resources.getColor(R.color.time))
                    }
                    "Speed" -> {
                        val categoriesAdapter = ArrayAdapter(requireActivity(),R.layout.item_spinner,speed)
                        binding.spCategoriesBefore.adapter = categoriesAdapter
                        binding.spCategoriesAfter.adapter = categoriesAdapter
                        binding.btnCalculate.setBackgroundColor(resources.getColor(R.color.speedStart))
                        binding.upperLayout.background = resources.getDrawable(R.drawable.speed_gradient)
                        binding.tvResult.setTextColor(resources.getColor(R.color.speedStart))
                    }
                    "Currency" -> {
                        val categoriesAdapter = ArrayAdapter(requireActivity(),R.layout.item_spinner,currency)
                        binding.spCategoriesBefore.adapter = categoriesAdapter
                        binding.spCategoriesAfter.adapter = categoriesAdapter
                        binding.btnCalculate.setBackgroundColor(resources.getColor(R.color.currency))
                        binding.upperLayout.background = resources.getDrawable(R.drawable.currency_gradient)
                        binding.tvResult.setTextColor(resources.getColor(R.color.currency))
                    }
                    else-> Toast.makeText(activity?.applicationContext,"nothing has been selected",Toast.LENGTH_LONG).show()
                }
                measurementItem=item!!
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }



        binding.spCategoriesBefore.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                adapter: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val item = adapter?.getItemAtPosition(position)

                itemBefore= item as String
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        binding.spCategoriesAfter.onItemSelectedListener= object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                adapter: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val item = adapter?.getItemAtPosition(position)
                itemAfter= item as String
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        binding.btnCalculate.setOnClickListener {
            calculateResult(measurementItem)
        }

        showDate()
        return binding.root
    }

    fun calculateResult(item:Any){
        when(item){
            "Length"->{
                val value =  binding.etConverterOne.text.toString()
                val result = convertLength(itemBefore,itemAfter,value)
                binding.tvResult.text=result.toString()
            }
            "Speed"->{
                val value =  binding.etConverterOne.text.toString()
                val result = convertSpeed(itemBefore,itemAfter,value)
                binding.tvResult.text=result.toString()

            }
        }

    }



    //A function to show today's date on the screen
    private fun showDate(){
        val today = Calendar.DATE
        val dateFormat = SimpleDateFormat("dd.MM.yyy")
        val currentDate = dateFormat.format(Date())
        binding.tvDate.text =currentDate

    }

    //function to convert a given length to a different length unit
    fun convertLength(lengthBefore:String, lengthAfter:String, value : String): Double{
        return when(lengthBefore){
            "Kilometre"-> {
                when(lengthAfter){
                    "Kilometre" -> value.toDouble()*1.0
                    "Metre" -> value.toDouble()*1000
                    "Centimetre"-> value.toDouble() * 100000
                    else->0.0
                }
            }
            "Metre"->{
                when(lengthAfter){
                    "Kilometre" -> value.toDouble()/1000
                    "Metre" -> value.toDouble()*1
                    "Centimetre"-> value.toDouble() * 100
                    else->0.0
                }
            }
            else -> when(lengthAfter){
                "Kilometre" -> value.toDouble()/100000
                "Metre" -> value.toDouble()*100
                "Centimetre"-> value.toDouble() * 1
                else->0.0
            }
        }
    }

    //function to convert speed units
    fun convertSpeed(speedBefore:String, speedAfter:String, value : String): Double{
        return when(speedBefore){
            "km/hr"-> {
                when(speedAfter){
                    "km/hr" -> value.toDouble()*1.0
                    "mtr/sec" -> value.toDouble()*0.278
                    "mi/hr"-> value.toDouble() * 0.621
                    else->0.0
                }
            }
            "mtr/sec"->{
                when(speedAfter){
                    "km/hr" -> value.toDouble()*3.6
                    "mtr/sec" -> value.toDouble()*1.0
                    "mi/hr"-> value.toDouble() * 2.23
                    else->0.0
                }
            }
            else -> when(speedAfter){
                "km/hr" -> value.toDouble()*1.60934
                "mtr/sec" -> value.toDouble()*0.44704
                "mi/hr"-> value.toDouble() * 1.0
                else->0.0
            }
        }
    }
}
