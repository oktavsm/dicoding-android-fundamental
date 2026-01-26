package com.dicoding.myviewmodel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.dicoding.myviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        displayResult()

        activityMainBinding.btnCalculate.setOnClickListener {

            val width = activityMainBinding.edtWidth.text.toString()
            val height = activityMainBinding.edtHeight.text.toString()
            val length = activityMainBinding.edtLength.text.toString()

            when{
                width.isEmpty() -> {
                    activityMainBinding.edtWidth.error = "Kosong"
                }
                height.isEmpty() -> {
                    activityMainBinding.edtHeight.error = "Kosong"
                }
                length.isEmpty() -> {
                    activityMainBinding.edtLength.error = "Kosong"
                }
                else -> {
                    viewModel.calculate(width, height, length)
                    displayResult()
                }

            }
        }

    }

    private fun displayResult() {
        activityMainBinding.tvResult.text = viewModel.result.toString()
    }
}