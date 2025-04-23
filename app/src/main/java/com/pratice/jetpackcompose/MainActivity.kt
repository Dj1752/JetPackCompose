package com.pratice.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pratice.jetpackcompose.ui.theme.JetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextInput()
        }
    }
}

@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
fun previewFunction(){
//   Text(text = "Hello Deepak",
//       fontSize = 36.sp,
//       color = Color.Red,
//       fontStyle = FontStyle.Italic,
//       fontWeight = FontWeight.W500, textAlign = TextAlign.Center,
//
//   )
//    Image(
//        painter = painterResource(id = R.drawable.ic_launcher_foreground),
//        colorFilter = ColorFilter.tint(Color.Black),
//        contentScale = ContentScale.Crop,
//        contentDescription = "Testing image")


//    Button(onClick = {}
//        , colors = ButtonDefaults.buttonColors(
//        contentColor = Color.White,
//        containerColor = Color.Black
//    )) {
//        Text(text = "Hello")
//    }


}
/*
Remeber keyword ko use humlog previous data kya tha vo store and remember karne ke use karte hai
mutablestateof use karte hai kuch bhi data update karte hai to ui ko update dena padta hai jetpack compose data ke uper ui  changes karta hai that we need to maintain the state of data
 */
@Composable
fun TextInput(){
   val state = remember {
       mutableStateOf("")
   }
    TextField(value = state.value,
        onValueChange ={
            state.value = it
        },
        label = { Text(text = "Enter Message")}
    )
}
