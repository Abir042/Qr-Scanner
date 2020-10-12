package com.nirvana.qrscanner.extension

fun Boolean?.orFalse(): Boolean {
    return this ?: false
}