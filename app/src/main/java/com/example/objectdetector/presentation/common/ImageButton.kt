package com.example.objectdetector.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.objectdetector.R
import com.example.objectdetector.presentation.utils.Dimens


@Composable
fun ImageButton(
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = drawableResourceId),
        contentDescription = stringResource(id = contentDescriptionResourceId),
        modifier = modifier
    )
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun ImageButtonPreview() {
    ImageButton(
        drawableResourceId = R.drawable.ic_rotate_camera,
        contentDescriptionResourceId = R.string.rotate_camera_button_description,
        modifier = Modifier
            .padding(Dimens.Padding16dp)
            .size(Dimens.RotateCameraButtonSize)
            .clickable {

            }
    )
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun CaptureImageButtonPreview() {
    ImageButton(
        drawableResourceId = R.drawable.ic_capture,
        contentDescriptionResourceId = R.string.capture_button_description,
        modifier = Modifier
            .size(Dimens.CaptureButtonSize)
            .clip(CircleShape)
            .clickable {

            }
    )
}