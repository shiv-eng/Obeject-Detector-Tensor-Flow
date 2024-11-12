package com.example.objectdetector.domain.usecases.userconfig


data class UserConfigUseCases(
    val readUserConfig: ReadUserConfig,
    val writeUserConfig: WriteUserConfig
)