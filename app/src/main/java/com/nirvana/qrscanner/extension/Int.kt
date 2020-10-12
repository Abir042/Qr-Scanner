package com.nirvana.qrscanner.extension

fun Int?.orZero(): Int {
    return this ?: 0
}