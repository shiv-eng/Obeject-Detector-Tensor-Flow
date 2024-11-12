package com.example.objectdetector.domain.usecases.userconfig

import com.example.objectdetector.domain.manager.datastore.LocalUserConfigManager


class WriteUserConfig(
    private val userConfigManager: LocalUserConfigManager
) {


    suspend operator fun invoke() {
        userConfigManager.writeUserConfig()
    }
}