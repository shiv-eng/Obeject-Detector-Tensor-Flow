package com.example.objectdetector.domain.manager.objectDetection

import android.graphics.Bitmap
import com.example.objectdetector.domain.model.Detection


interface ObjectDetectionManager {
    fun detectObjectsInCurrentFrame(
        bitmap: Bitmap,
        rotation: Int,
        confidenceThreshold: Float
    ): List<Detection>
}