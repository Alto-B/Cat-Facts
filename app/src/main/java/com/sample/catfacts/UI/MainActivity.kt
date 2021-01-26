package com.sample.catfacts.UI

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.sample.catfacts.R
import com.sample.catfacts.ViewModel.ViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel:ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("Fact", "called the method")
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        new_fact_btn.setOnClickListener { newFact()}
        newFact()
    }

    private fun newFact(){
        viewModel.newFact(this@MainActivity)
        fact_text.text = viewModel.updateText()
    }
}
