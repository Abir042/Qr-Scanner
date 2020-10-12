package com.nirvana.qrscanner.feature

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.startapp.sdk.adsbase.AutoInterstitialPreferences
import com.startapp.sdk.adsbase.StartAppAd
import com.startapp.sdk.adsbase.StartAppSDK


abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        StartAppSDK.init(this, "209748320");

        StartAppAd.enableAutoInterstitial();

        StartAppAd.setAutoInterstitialPreferences(
                AutoInterstitialPreferences()
                        .setSecondsBetweenAds(60)
                        .setActivitiesBetweenAds(3)
        )

        super.onCreate(savedInstanceState)
        window.decorView.systemUiVisibility = window.decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
    }
}