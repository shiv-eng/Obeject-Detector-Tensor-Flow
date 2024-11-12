package com.example.objectdetector.presentation.home.components

import androidx.camera.view.LifecycleCameraController
import androidx.camera.view.PreviewView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.LifecycleOwner


@Composable
fun CameraPreview(
    controller: LifecycleCameraController,
    modifier: Modifier = Modifier,
    onPreviewSizeChanged: (IntSize) -> Unit
) {
    val lifeCycleOwner: LifecycleOwner = LocalLifecycleOwner.current
    val previewSizeState = remember { mutableStateOf(IntSize(0, 0)) }

    AndroidView(
        factory = {
            PreviewView(it).apply {
                this.controller = controller
                controller.bindToLifecycle(lifeCycleOwner)
            }
        },
        modifier = modifier.onGloballyPositioned { coordinates ->
            val size = coordinates.size
            previewSizeState.value = size
            onPreviewSizeChanged(size)
        }
    )
}