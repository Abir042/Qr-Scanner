package com.nirvana.qrscanner.extension

import java.util.*

val Locale?.isRussian: Boolean
    get() = this?.language == "ru"