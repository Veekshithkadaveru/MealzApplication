package com.example.mealzapp.ui.details

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.mealzapp.model.response.MealResponse

@Composable
fun MealsDetailsScreen(meal: MealResponse?) {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    val imageSizeDp: Dp by animateDpAsState(
        targetValue = if (isExpanded) 200.dp else 100.dp
    )
    val imageBorderColor: Color by animateColorAsState(
        targetValue = if (isExpanded) Color.Green else Color.Red )
    Column {
        Row {
            Card(
                modifier = Modifier.padding(16.dp),
                shape = CircleShape,
                border = BorderStroke(
                    width = if (isExpanded )12.dp else 4.dp,
                    color = imageBorderColor
                )
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        model = ImageRequest
                            .Builder(LocalContext.current)
                            .data(meal?.imageUrl)
                            .transformations(CircleCropTransformation())
                            .build(),
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .size(imageSizeDp)
                        .padding(8.dp)
                )
            }
            Text(
                text = meal?.name ?: "default name",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Button(modifier = Modifier
            .padding(16.dp),
            onClick = {
                isExpanded = !isExpanded
            }) {
            Text(text = "Change state to meal picture")

        }
    }

}

