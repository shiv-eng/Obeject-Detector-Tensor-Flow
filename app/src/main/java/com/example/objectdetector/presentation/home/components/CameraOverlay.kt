package com.example.objectdetector.presentation.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.objectdetector.domain.model.Detection
import com.example.objectdetector.presentation.common.DrawDetectionBox


@Composable
fun CameraOverlay(detections: List<Detection>) {
    Box(modifier = Modifier.fillMaxSize()) {
        detections.forEach { detection ->
            DrawDetectionBox(detection)
        }
    }
}