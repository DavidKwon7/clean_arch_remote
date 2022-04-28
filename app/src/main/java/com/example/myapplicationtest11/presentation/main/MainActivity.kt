package com.example.myapplicationtest11.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.myapplicationtest11.R
import com.example.myapplicationtest11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

   fun observe() {
       mainViewModel.eventUserRepo.observe(this, Observer {
           (binding.rvMain.adapter as MainAdapter).addData(it)
       })
   }

    fun clickSearchBtn(view: View) {
        val etSearch = binding.etSearch
        binding.btnGetData.setOnClickListener {
            mainViewModel.getUserRepo(etSearch.text.toString())
        }
    }
}