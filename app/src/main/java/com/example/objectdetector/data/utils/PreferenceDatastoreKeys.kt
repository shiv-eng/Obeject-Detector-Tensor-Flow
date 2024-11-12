package com.example.objectdetector.data.utils

import androidx.datastore.preferences.core.booleanPreferencesKey
import com.example.objectdetector.utils.Constants

object PreferenceDatastoreKeys {
    val USER_CONFIG = booleanPreferencesKey(name = Constants.USER_CONFIG)
}