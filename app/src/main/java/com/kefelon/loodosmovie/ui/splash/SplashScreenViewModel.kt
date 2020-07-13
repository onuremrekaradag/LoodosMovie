package com.kefelon.loodosmovie.ui.splash

import androidx.lifecycle.MutableLiveData
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.get
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.kefelon.loodosmovie.R
import com.kefelon.loodosmovie.base.BaseViewModel
import javax.inject.Inject

class SplashScreenViewModel @Inject constructor() : BaseViewModel() {

    var remoteConfigLogo = MutableLiveData<String>()

    override fun start() {
        getLogoText()
    }

    override fun stop() = Unit

    private fun getLogoText() {
        val remoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 10000
        }
        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(R.xml.default_config)
        remoteConfig.fetch().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                remoteConfigLogo.value = remoteConfig["logoText"].asString()
            }
        }
    }
}