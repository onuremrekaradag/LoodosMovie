package com.kefelon.loodosmovie.ui.main

import androidx.lifecycle.ViewModelProvider
import com.kefelon.loodosmovie.R
import com.kefelon.loodosmovie.base.BaseActivity
import com.kefelon.loodosmovie.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var dataBinding: ActivityMainBinding


    override fun initViews() {

        viewModel = ViewModelProvider(
            this@MainActivity,
            viewModelFactory
        ).get(MainViewModel::class.java)

    }

    override fun getLayoutId(): Int = R.layout.activity_main

}