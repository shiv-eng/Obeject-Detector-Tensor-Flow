package com.example.objectdetector.data.manager.objectDetection

import android.content.Context
import android.graphics.Bitmap
import android.view.Surface
import com.example.objectdetector.domain.manager.objectDetection.ObjectDetectionManager
import com.example.objectdetector.domain.model.Detection
import com.example.objectdetector.utils.Constants
import org.tensorflow.lite.gpu.CompatibilityList
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.task.core.BaseOptions
import org.tensorflow.lite.task.core.vision.ImageProcessingOptions
import org.tensorflow.lite.task.vision.detector.ObjectDetector
import javax.inject.Inject


class ObjectDetectionManagerImpl @Inject constructor(
    private val context: Context
): ObjectDetectionManager {
    // Holds the instance of the TensorFlow Lite object detector.
    private var detector: ObjectDetector? = null

    override fun detectObjectsInCurrentFrame(
        bitmap: Bitmap,
        rotation: Int,
        confidenceThreshold: Float
    ): List<Detection> {
        if (detector == null) {
            initializeDetector(confidenceThreshold)
        }

        val imageProcessor =
            ImageProcessor.Builder()
                //.add(Rot90Op(-rotation / 90))     // Nullifying by adding rotation in CameraFrameAnalyzer class
                .build()

        val tensorImage: TensorImage = imageProcessor.process(
            TensorImage.fromBitmap(bitmap)
        )

        val detectionResults = detector?.detect(
            tensorImage
        )

        return detectionResults?.mapNotNull { detectedObject ->
            if ((detectedObject.categories.firstOrNull()?.score ?: 0f) >= confidenceThreshold) {
                Detection(
                    boundingBox = detectedObject.boundingBox,
                    detectedObjectName = detectedObject.categories.firstOrNull()?.label ?: "",
                    confidenceScore = detectedObject.categories.firstOrNull()?.score ?: 0f,
                    tensorImage.height,
                    tensorImage.width
                )
            } else null
        }?.take(Constants.MODEL_MAX_RESULTS_COUNT) ?: emptyList()
    }


    private fun initializeDetector(confidenceThreshold: Float) {
        try {
            val baseOptions = BaseOptions.builder()
                .setNumThreads(2)

            if (CompatibilityList().isDelegateSupportedOnThisDevice) {
                baseOptions.useGpu()
            }

            val options = ObjectDetector.ObjectDetectorOptions.builder()
                .setBaseOptions(baseOptions.build())
                .setMaxResults(Constants.MODEL_MAX_RESULTS_COUNT)
                .setScoreThreshold(confidenceThreshold)
                .build()

            detector = ObjectDetector.createFromFileAndOptions(
                context,
                Constants.MODEL_PATH,
                options
            )
        } catch (exception: IllegalStateException) {
            exception.printStackTrace()
        }
    }

}