package com.nirvana.qrscanner.feature.tabs.settings.theme

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.nirvana.qrscanner.R
import com.nirvana.qrscanner.di.settings
import com.nirvana.qrscanner.extension.applySystemWindowInsets
import com.nirvana.qrscanner.extension.unsafeLazy
import com.nirvana.qrscanner.feature.BaseActivity
import com.nirvana.qrscanner.usecase.Settings
import kotlinx.android.synthetic.main.activity_choose_theme.*

class ChooseThemeActivity : BaseActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, ChooseThemeActivity::class.java)
            context.startActivity(intent)
        }
    }

    private val buttons by unsafeLazy {
        listOf(button_system_theme, button_light_theme, button_dark_theme)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_theme)
        supportEdgeToEdge()
        initToolbar()
    }

    override fun onResume() {
        super.onResume()
        showInitialSettings()
        handleSettingsChanged()
    }

    private fun supportEdgeToEdge() {
        root_view.applySystemWindowInsets(applyTop = true, applyBottom = true)
    }

    private fun initToolbar() {
        toolbar.setNavigationOnClickListener { finish() }
    }

    private fun showInitialSettings() {
        val theme = settings.theme
        button_system_theme.isChecked = theme == Settings.THEME_SYSTEM
        button_light_theme.isChecked = theme == Settings.THEME_LIGHT
        button_dark_theme.isChecked = theme == Settings.THEME_DARK
    }

    private fun handleSettingsChanged() {
        button_system_theme.setCheckedChangedListener { isChecked ->
            if (isChecked.not()) {
                return@setCheckedChangedListener
            }

            uncheckOtherButtons(button_system_theme)
            settings.theme = Settings.THEME_SYSTEM
        }

        button_light_theme.setCheckedChangedListener { isChecked ->
            if (isChecked.not()) {
                return@setCheckedChangedListener
            }

            uncheckOtherButtons(button_light_theme)
            settings.theme = Settings.THEME_LIGHT
        }

        button_dark_theme.setCheckedChangedListener { isChecked ->
            if (isChecked.not()) {
                return@setCheckedChangedListener
            }

            uncheckOtherButtons(button_dark_theme)
            settings.theme = Settings.THEME_DARK
        }
    }

    private fun uncheckOtherButtons(checkedButton: View) {
        buttons.forEach { button ->
            if (checkedButton !== button) {
                button.isChecked = false
            }
        }
    }
}