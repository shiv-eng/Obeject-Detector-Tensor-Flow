package com.example.objectdetector.domain.model

import android.graphics.RectF


data class Detection(
    val boundingBox: RectF,
    val detectedObjectName: String,
    val confidenceScore: Float,
    val tensorImageHeight: Int,
    val tensorImageWidth: Int,
)