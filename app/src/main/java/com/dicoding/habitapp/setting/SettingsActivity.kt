package com.dicoding.habitapp.setting

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.SwitchPreference
import com.dicoding.habitapp.R
import com.dicoding.habitapp.notification.NotificationWorker
import com.dicoding.habitapp.utils.DarkMode

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings, SettingsFragment())
                .commit()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)

            //TODO 11 : Update theme based on value in ListPreference
            val darkMode = findPreference<ListPreference>(getString(R.string.pref_key_dark)) as ListPreference
            darkMode.setOnPreferenceChangeListener { _, newValue ->
                when(newValue.toString()) {
                    getString(R.string.pref_dark_follow_system) -> updateTheme(DarkMode.FOLLOW_SYSTEM.value)
                    getString(R.string.pref_dark_on) -> updateTheme(DarkMode.ON.value)
                    getString(R.string.pref_dark_off) -> updateTheme(DarkMode.OFF.value)
                }
                true
            }
        }

        private fun updateTheme(mode: Int): Boolean {
            AppCompatDelegate.setDefaultNightMode(mode)
            requireActivity().recreate()
            return true
        }
    }
}