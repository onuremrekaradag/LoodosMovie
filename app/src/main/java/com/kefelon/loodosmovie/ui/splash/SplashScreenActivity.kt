package com.kefelon.loodosmovie.ui.splash

import android.content.Intent
import android.os.Handler
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kefelon.loodosmovie.R
import com.kefelon.loodosmovie.base.BaseActivity
import com.kefelon.loodosmovie.databinding.ActivitySplashScreenBinding
import com.kefelon.loodosmovie.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : BaseActivity() {

    private lateinit var viewModel: SplashScreenViewModel

    private lateinit var dataBinding: ActivitySplashScreenBinding

    private lateinit var dataObserver: Observer<String>

    override fun getLayoutId(): Int = R.layout.activity_splash_screen

    override fun initViews() {
        viewModel = ViewModelProvider(
            this@SplashScreenActivity,
            viewModelFactory
        ).get(SplashScreenViewModel::class.java)
        dataBinding = ActivitySplashScreenBinding.inflate(layoutInflater).apply {
            this.viewModelSplashScreen = viewModel
        }

        observeLiveData()

        viewModel.start()
    }

    private fun observeLiveData() {
        dataObserver = Observer {
            textViewRemoteConfig.text = it
            Handler().postDelayed({
                val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }, 3000)
        }
        viewModel.remoteConfigLogo.observe(this, dataObserver)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.stop()
    }

}