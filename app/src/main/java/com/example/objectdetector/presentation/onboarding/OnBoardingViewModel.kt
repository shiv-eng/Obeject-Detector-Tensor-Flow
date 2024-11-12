package com.example.objectdetector.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.objectdetector.domain.usecases.userconfig.UserConfigUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val userConfigUseCases: UserConfigUseCases
): ViewModel() {

    fun onEvent(event: OnBoardingEvent) {
        when(event) {
            is OnBoardingEvent.WriteUserConfigToDataStore -> {
                writeUserConfig()
            }
        }
    }

    /**
     * Calls WriteUserConfig Use-Case to save the User-Config flag into UserPreference Datastore
     */
    private fun writeUserConfig() {
        viewModelScope.launch {
            userConfigUseCases.writeUserConfig()
        }
    }
}