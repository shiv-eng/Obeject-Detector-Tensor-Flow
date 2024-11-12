package com.example.objectdetector.data.manager.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import com.example.objectdetector.utils.extensions.datastore
import com.example.objectdetector.data.utils.PreferenceDatastoreKeys
import com.example.objectdetector.domain.manager.datastore.LocalUserConfigManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Defines an implementation of LocalUserConfigManager for managing user configuration data.
 * This implementation injects a Context to interact with DataStore preferences.
 */
class LocalUserConfigManagerImpl @Inject constructor(
    private val context: Context
): LocalUserConfigManager {


    override suspend fun writeUserConfig() {
        // Using extension function obtain instance of 'userConfigDatastore' to write value
        context.datastore.edit { userConfigDatastore ->
            userConfigDatastore[PreferenceDatastoreKeys.USER_CONFIG] = true
        }
    }


    override fun readUserConfig(): Flow<Boolean> {
        return context.datastore.data
            .map { preferences ->
                preferences[PreferenceDatastoreKeys.USER_CONFIG] ?: false
        }
    }

}