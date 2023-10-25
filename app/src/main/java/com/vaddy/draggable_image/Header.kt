package com.vaddy.draggable_image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween

    ){

        Column {

            Text(text = "La Pino'z Pizza", fontSize = 32.sp, fontWeight = FontWeight.ExtraBold)

            Text(text = "Margarita", fontSize = 20.sp, fontWeight = FontWeight.Normal, color = Color.Gray)

        }

        Image(
            painter = painterResource(id = R.drawable.pizza_logo),
            contentDescription = "logo",
            modifier = Modifier
                .size(60.dp)
                .padding(top=5.dp),
        )

    }
}


//@Preview
//@Composable
//fun prev(){
//    Header()
//}