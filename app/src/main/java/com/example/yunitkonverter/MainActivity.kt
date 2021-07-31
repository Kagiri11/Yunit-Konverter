package com.example.yunitkonverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var myLife: MyLife
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println(myLife.getBetter())
       }
}

//To tell hilt that this is a dependency, we mark it's constructor with @Inject
@ActivityScoped
class MyLife @Inject constructor(private val alt:AlternateLife) {
    //up there I have done constructor injection
    fun getBetter():String{
        return "Charles you need to get better with Kotlin ${alt.evenBetter()}"
    }
}

@ActivityScoped
class AlternateLife @Inject constructor(){
    fun evenBetter():String{
        return "And you will live the life you want"
    }
}

@AndroidEntryPoint
class NewFragment : Fragment(){
    @Inject lateinit var alt1 : AlternateLife

}