package com.tao.scanqr.extension

fun Long?.orZero(): Long {
    return this ?: 0L
}