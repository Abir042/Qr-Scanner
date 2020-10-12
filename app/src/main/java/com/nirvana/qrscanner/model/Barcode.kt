package com.nirvana.qrscanner.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.nirvana.qrscanner.model.schema.BarcodeSchema
import com.nirvana.qrscanner.usecase.BarcodeDatabaseTypeConverter
import com.google.zxing.BarcodeFormat
import java.io.Serializable

@Entity(tableName = "codes")
@TypeConverters(BarcodeDatabaseTypeConverter::class)
data class Barcode(
        @PrimaryKey(autoGenerate = true) val id: Long = 0,
        val text: String,
        val formattedText: String,
        val format: BarcodeFormat,
        val schema: BarcodeSchema,
        val date: Long,
        val isGenerated: Boolean = false,
        var isFavorite: Boolean = false,
        val errorCorrectionLevel: String? = null,
        val country: String? = null
) : Serializable