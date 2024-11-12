package com.example.objectdetector.domain.usecases.userconfig

import com.example.objectdetector.domain.manager.datastore.LocalUserConfigManager
import kotlinx.coroutines.flow.Flow


class ReadUserConfig(
    private val userConfigManager: LocalUserConfigManager
) {


    operator fun invoke(): Flow<Boolean> {
        return userConfigManager.readUserConfig()
    }
}