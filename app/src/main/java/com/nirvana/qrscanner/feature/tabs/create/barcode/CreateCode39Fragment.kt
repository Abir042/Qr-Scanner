package com.nirvana.qrscanner.feature.tabs.create.barcode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.nirvana.qrscanner.R
import com.nirvana.qrscanner.extension.isNotBlank
import com.nirvana.qrscanner.extension.textString
import com.nirvana.qrscanner.feature.tabs.create.BaseCreateBarcodeFragment
import com.nirvana.qrscanner.model.schema.Other
import com.nirvana.qrscanner.model.schema.Schema
import kotlinx.android.synthetic.main.fragment_create_code_39.*

class CreateCode39Fragment : BaseCreateBarcodeFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_create_code_39, container, false)
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