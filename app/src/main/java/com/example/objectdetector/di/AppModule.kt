package com.example.objectdetector.di

import android.app.Application
import android.content.Context
import com.example.objectdetector.data.manager.datastore.LocalUserConfigManagerImpl
import com.example.objectdetector.data.manager.objectDetection.ObjectDetectionManagerImpl
import com.example.objectdetector.domain.manager.datastore.LocalUserConfigManager
import com.example.objectdetector.domain.manager.objectDetection.ObjectDetectionManager
import com.example.objectdetector.domain.usecases.detection.DetectObjectUseCase
import com.example.objectdetector.domain.usecases.userconfig.ReadUserConfig
import com.example.objectdetector.domain.usecases.userconfig.UserConfigUseCases
import com.example.objectdetector.domain.usecases.userconfig.WriteUserConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.modules.ApplicationContextModule
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module(includes = [ApplicationContextModule::class])
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideLocalUserConfigManager(
        application: Application
    ): LocalUserConfigManager = LocalUserConfigManagerImpl(application)

    @Provides
    @Singleton
    fun provideObjectDetectionManager(
        @ApplicationContext context: Context
    ): ObjectDetectionManager = ObjectDetectionManagerImpl(
        context
    )


    // Use-Cases
    @Provides
    @Singleton
    fun provideUserConfigUseCases(
        localUserConfigManager: LocalUserConfigManager
    ): UserConfigUseCases = UserConfigUseCases(
        readUserConfig = ReadUserConfig(localUserConfigManager),
        writeUserConfig = WriteUserConfig(localUserConfigManager)
    )

    @Provides
    @Singleton
    fun provideDetectObjectUseCase(
        objectDetectionManager: ObjectDetectionManager
    ): DetectObjectUseCase = DetectObjectUseCase(
        objectDetectionManager = objectDetectionManager
    )
}