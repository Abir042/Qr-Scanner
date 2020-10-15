package com.tao.scanqr.extension

fun Int?.orZero(): Int {
    return this ?: 0
}