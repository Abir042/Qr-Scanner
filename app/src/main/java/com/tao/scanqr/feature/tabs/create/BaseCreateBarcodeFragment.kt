package com.tao.scanqr.feature.tabs.create

import androidx.fragment.app.Fragment
import com.tao.scanqr.extension.*
import com.tao.scanqr.model.Contact
import com.tao.scanqr.model.schema.Other
import com.tao.scanqr.model.schema.Schema

abstract class BaseCreateBarcodeFragment : Fragment() {
    protected val parentActivity by unsafeLazy { requireActivity() as CreateBarcodeActivity }

    open val latitude: Double? = null
    open val longitude: Double? = null

    open fun getBarcodeSchema(): Schema = Other("")
    open fun showPhone(phone: String) {}
    open fun showContact(contact: Contact) {}
    open fun showLocation(latitude: Double?, longitude: Double?) {}
}