package com.example.objectdetector.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

/**
 * A Composable function that displays the onboarding screens using a pager.
 * It allows users to swipe through different pages with content introducing the app's features.
 * Depending on the current page, it shows appropriate navigation buttons and updates the onboarding progress indicator.
 *
 * @param event A lambda that emits OnBoardingEvent to the host of the Composable when certain user actions occur.
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    event: (OnBoardingEvent) -> Unit
) {
    val pagerCoroutineScope = rememberCoroutineScope()
    pagerCoroutineScope.launch {
        event(OnBoardingEvent.WriteUserConfigToDataStore)
    }
}