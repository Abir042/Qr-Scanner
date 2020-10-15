package com.tao.scanqr.model

import androidx.room.TypeConverters
import com.tao.scanqr.usecase.BarcodeDatabaseTypeConverter
import com.google.zxing.BarcodeFormat

@TypeConverters(BarcodeDatabaseTypeConverter::class)
data class ExportBarcode(
        val date: Long,
        val format: BarcodeFormat,
        val text: String
)