package com.tao.scanqr.feature.tabs.create.barcode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.tao.scanqr.R
import com.tao.scanqr.extension.isNotBlank
import com.tao.scanqr.extension.textString
import com.tao.scanqr.feature.tabs.create.BaseCreateBarcodeFragment
import com.tao.scanqr.model.schema.Other
import com.tao.scanqr.model.schema.Schema
import kotlinx.android.synthetic.main.fragment_create_pdf417.*

class CreatePdf417Fragment : BaseCreateBarcodeFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_create_pdf417, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edit_text.requestFocus()
        edit_text.addTextChangedListener {
            parentActivity.isCreateBarcodeButtonEnabled = edit_text.isNotBlank()
        }
    }

    override fun getBarcodeSchema(): Schema {
        return Other(edit_text.textString)
    }
}