package com.tao.scanqr

import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import androidx.multidex.MultiDexApplication
import com.tao.scanqr.di.settings
import com.tao.scanqr.usecase.Logger
import io.reactivex.plugins.RxJavaPlugins

class App : MultiDexApplication() {

    override fun onCreate() {
        handleUnhandledRxJavaErrors()
        enableStrictModeIfNeeded()
        applyTheme()
        super.onCreate()
    }

    private fun applyTheme() {
        settings.reapplyTheme()
    }

    private fun handleUnhandledRxJavaErrors() {
        RxJavaPlugins.setErrorHandler { error ->
            Logger.log(error)
        }
    }

    private fun enableStrictModeIfNeeded() {
        if (true) {
            return
        }

        StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                        .detectAll()
                        .penaltyLog()
                        .penaltyDialog()
                        .build()
        )

        StrictMode.setVmPolicy(
                VmPolicy.Builder()
                        .detectAll()
                        .penaltyLog()
                        .penaltyDropBox()
                        .build()
        )
    }
}