package com.tao.scanqr.extension

fun Boolean?.orFalse(): Boolean {
    return this ?: false
}