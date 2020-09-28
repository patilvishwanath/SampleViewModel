package com.vp.sampleviewmodel

import android.database.Observable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: SampleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtHashCode.text = this.hashCode().toString()

        btnIncrement.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
               viewModel.increment()
            }
        })

        btnDecrement.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                viewModel.decrement()
            }
        })


        val a = ArrayList<String>()
        a.add("Test")
        a.add("Testt")
        a.add("Testt")

        setUpViewModel()

        val b = listOf("VP","KP","SP")
       



    }

    private fun setUpViewModel() {
        viewModel = ViewModelProvider(this).get(SampleViewModel::class.java)
        viewModel.liveData.observe(this,object :Observer<Int>{
            override fun onChanged(t: Int?) {
                textView.text = t.toString()
            }
        })

    }


}