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
            "ft/sec",
            "knot",
        )
        val currency = listOf(
            "American Dollar",
            "Australian Dollar",
            "British Pound",
            "Euro",
            "Kenyan Shs",
        )

        val measurements = listOf("Length","Speed","Currency","Time")
        val measurementsAdapter = ArrayAdapter(requireActivity(),R.layout.item_spinner2,measurements)
        binding.spMeasurements.apply {
            adapter=measurementsAdapter
            height to 30
        }


        var measurementItem = Any()


        binding.spMeasurements.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
            @SuppressLint("UseCompatLoadingForDrawables")
            override fun onItemSelected(adapter: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val item = adapter?.getItemAtPosition(position)
                when(item){
                    "Length" -> {
                        Toast.makeText(requireContext(),"Length has been selected",Toast.LENGTH_LONG).show()
                        val categoriesAdapter = ArrayAdapter(requireActivity(),R.layout.item_spinner,length)
                        binding.upperLayout.background = resources.getDrawable(R.drawable.length_gradient)
                        binding.spCategoriesBefore.adapter = categoriesAdapter
                        binding.spCategoriesAfter.adapter = categoriesAdapter
                        binding.tvResult.setTextColor(resources.getColor(R.color.etLength))
                    }
                    "Time" -> {
                        Toast.makeText(activity?.applicationContext,"Time has been selected",Toast.LENGTH_LONG).show()
                        val categoriesAdapter = ArrayAdapter(requireActivity(),R.layout.item_spinner,time)
                        binding.spCategoriesBefore.adapter = categoriesAdapter
                        binding.spCategoriesAfter.adapter = categoriesAdapter
                    }
                    "Speed" -> {
                        Toast.makeText(activity?.applicationContext,"Speed has been selected",Toast.LENGTH_LONG).show()
                        val categoriesAdapter = ArrayAdapter(requireActivity(),R.layout.item_spinner,speed)
                        binding.spCategoriesBefore.adapter = categoriesAdapter
                        binding.spCategoriesAfter.adapter = categoriesAdapter
                        binding.upperLayout.background = resources.getDrawable(R.drawable.speed_gradient)
                    }
                    "Currency" -> {
                        Toast.makeText(activity?.applicationContext,"Currency has been selected",Toast.LENGTH_LONG).show()
                        val categoriesAdapter = ArrayAdapter(requireActivity(),R.layout.item_spinner,currency)
                        binding.spCategoriesBefore.adapter = categoriesAdapter
                        binding.spCategoriesAfter.adapter = categoriesAdapter
                        binding.upperLayout.background = resources.getDrawable(R.drawable.currency_gradient)
                    }
                    else-> Toast.makeText(activity?.applicationContext,"nothing has been selected",Toast.LENGTH_LONG).show()
                }
                measurementItem=item!!
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        var itemBefore = ""
        var itemAfter = ""

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
                TODO("Not yet implemented")
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

        println(measurementItem.toString())

        val value =  binding.etConverterOne.text.toString()

        binding.tvResult.text= convertLength(itemBefore,itemAfter,value).toString()

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

    //function to convert a given length to a different length unit
    fun convertLength(lengthBefore:String, lengthAfter:String, value : String): Double{
        return when(lengthBefore){
            "Kilometre"-> {
                when(lengthAfter){
                    "Kilometre" -> value.toDouble()*1.0
                    "Metre" -> value.toDouble()*1000
                    "Centimeter"-> value.toDouble() * 100000
                    else->0.0
                }
            }
            "Metre"->{
                when(lengthAfter){
                    "Kilometre" -> value.toDouble()/1000
                    "Metre" -> value.toDouble()*1
                    "Centimeter"-> value.toDouble() * 100
                    else->0.0
                }
            }
            else -> when(lengthAfter){
                "Kilometre" -> value.toDouble()/100000
                "Metre" -> value.toDouble()*100
                "Centimeter"-> value.toDouble() * 1
                else->0.0
            }
        }
    }
}
