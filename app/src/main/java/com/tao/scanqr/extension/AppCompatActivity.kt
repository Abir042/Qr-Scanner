package com.tao.scanqr.extension

import androidx.appcompat.app.AppCompatActivity
import com.tao.scanqr.feature.common.dialog.ErrorDialogFragment

fun AppCompatActivity.showError(error: Throwable?) {
    val errorDialog =
            ErrorDialogFragment.newInstance(
                    this,
                    error
            )
    errorDialog.show(supportFragmentManager, "")
}