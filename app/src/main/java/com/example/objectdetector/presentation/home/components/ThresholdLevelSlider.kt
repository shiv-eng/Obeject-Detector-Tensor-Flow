package com.example.objectdetector.presentation.home.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.objectdetector.R
import com.example.objectdetector.presentation.utils.Dimens
import com.example.objectdetector.utils.Constants.INITIAL_CONFIDENCE_SCORE

@Composable
fun ThresholdLevelSlider(
    sliderValue: MutableState<Float>,
    thresholdValue: (Float) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = Dimens.Padding40dp,
                end = Dimens.Padding40dp,
                bottom = Dimens.Padding32dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Slider(
                value = sliderValue.value,
                onValueChange = {
                    sliderValue.value = String.format("%.2f", it).toFloat()
                },
                onValueChangeFinished = {
                    thresholdValue(sliderValue.value)
                },
                valueRange = 0f..1f,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
            )
            Text(
                text = "${(sliderValue.value * 100).toInt()}%",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                color = colorResource(id = R.color.gray_50)
            )
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun PreviewConfidenceSlider() {
    val sliderValue = remember { mutableFloatStateOf(INITIAL_CONFIDENCE_SCORE) }
    ThresholdLevelSlider(sliderValue) {}
}