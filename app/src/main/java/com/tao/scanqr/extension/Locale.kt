package com.tao.scanqr.extension

import java.util.*

val Locale?.isRussian: Boolean
    get() = this?.language == "ru"