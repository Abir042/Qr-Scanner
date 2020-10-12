package com.nirvana.qrscanner.extension

fun Double?.orZero(): Double {
    return this ?: 0.0
}