package com.pratice.jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text

@Preview
@Composable
fun Notification(){
    var count = rememberSaveable{mutableStateOf(0)}//rememberSaveable use kiya jab hum ek state se dusre state mai jate to data clear nahi hona chahiye iske use karte hai for eg jab mai portrait mode mai changes kar to hu and usko mai landscape mai convert karta hu to jo bhi changes kiya the vo as it is hona chahiye
    Column(verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)) {
        NotificationCounter(count.value,{count.value++}) // hosting means agar mujhe same data do jagha bhej na hai to use parent composable mai initialize karuga like count
        MessageBar(count.value)
    }
}

@Composable
fun MessageBar(count:Int){
    Card(colors = CardDefaults.cardColors(Color.White)) {
        Row(Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Image(imageVector = Icons.Outlined.Favorite,
                contentDescription="",
                Modifier.padding(4.dp)
            )
            Text(text = "Message sent so far $count")
        }
    }
}
@Composable
fun NotificationCounter(count:Int,increment:()-> Unit){

    Column(verticalArrangement = Arrangement.Center) {
     //   Text(text="You have sent $count notification")
        Text(text ="You have sent $count notification")
        Button(onClick = { increment() }) {
           Text(text="Send Notification")
       }

    }
}