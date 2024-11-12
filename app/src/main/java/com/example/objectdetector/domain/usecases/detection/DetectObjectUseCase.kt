package com.example.objectdetector.domain.usecases.detection

import android.graphics.Bitmap
import com.example.objectdetector.domain.manager.objectDetection.ObjectDetectionManager
import com.example.objectdetector.domain.model.Detection

class DetectObjectUseCase(
    private val objectDetectionManager: ObjectDetectionManager
) {

    fun execute(
        bitmap: Bitmap,
        rotation: Int,
        confidenceThreshold: Float
    ): List<Detection> {
        return objectDetectionManager.detectObjectsInCurrentFrame(
            bitmap = bitmap,
            rotation,
            confidenceThreshold
        )
    }
}