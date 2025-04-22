package com.pratice.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pratice.jetpackcompose.ui.theme.JetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Text(text = "I am Deepak")
        }
    }
}
@Composable
fun compose(name:String){
    Text(text = "Compose $name")
}

@Preview(showBackground = true, name ="Hello Messgae ", widthDp = 200, heightDp = 200)
@Composable
fun previewFunction(){
    compose(name = "Deepak")
}
