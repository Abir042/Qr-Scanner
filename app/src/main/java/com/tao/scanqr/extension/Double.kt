package com.tao.scanqr.extension

fun Double?.orZero(): Double {
    return this ?: 0.0
}