package com.pratice.jetpackcompose

import android.content.res.Resources.Theme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pratice.jetpackcompose.ui.theme.JetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           // TextInput()
            //PreviewItem()
            //Recomposable()
            Notification()
            App()
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
/*
Column is use for vertical arrange the view one after another
Row is use for horizontal arrange the view one by one
 */
    /*
     Column(verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
         Text(text = "A", fontWeight = FontWeight.Bold, fontSize = 26.sp)
         Text(text = "B", fontWeight = FontWeight.Bold, fontSize = 26.sp)
     }
    Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically){
        Text(text = "A", fontWeight = FontWeight.Bold, fontSize = 26.sp)
        Text(text = "B", fontWeight = FontWeight.Bold, fontSize = 26.sp)
    }


    Column {
        ListViewtext(R.drawable.ic_launcher_foreground,"Deepak","Android Developer")
        ListViewtext(R.drawable.ic_launcher_foreground,"Deepak1","Android Developer")
        ListViewtext(R.drawable.ic_launcher_foreground,"Deepak2","Android Developer")
        ListViewtext(R.drawable.ic_launcher_foreground,"Deepak3","Android Developer")

    }

     */
    /*
    Box is work as a frame layout of android studio the view framed like a stack ek ke uper ek

    Box(){
        Image(painter = painterResource(id = R.drawable.ic_launcher_background) , contentDescription = "")
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground) , contentDescription = "")
    }

     */
    /*
    Modifiers it is used to decorate and augment composables, allowing you to customize their appearance, behavior, and layout without altering their internal state
     */
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        colorFilter = ColorFilter.tint(Color.Black),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clickable { }
            .size(100.dp)
            .padding(20.dp)
            .background(Color.Blue),
        contentDescription = "Testing image")



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
@Composable
fun ListViewtext(image:Int,name:String,des:String){
    Row {
        Image(painter = painterResource(id = image),
            colorFilter = ColorFilter.tint(Color.Black),contentDescription ="", modifier = Modifier.size(80.dp) )
        Column(Modifier.padding(0.dp,20.dp,0.dp,0.dp)) {
            Text(text = name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = des, fontWeight = FontWeight(200), fontSize = 14.sp)
        }
    }
}

@Composable
fun App(){
    var theme = remember { mutableStateOf(false) }
    JetPackComposeTheme(theme.value) {

        Column(Modifier.background(MaterialTheme.colorScheme.background)) {
            Text(
                text = "Deepak",
                style = MaterialTheme.typography.titleLarge
            )
            Button(onClick = {
                theme.value = !theme.value
            }) {
                Text(text = "Change theme")
            }
        }
    }
}