package com.pratice.jetpackcompose

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

/*
Side effect kya hota hai jo variable , methods function ke scope bhar hota hai and composable ko pata nahi hota hai kitne time
excute karega within conposable so usko control karne ke liya humlog launchedEffect use karte hai to control the execution of code
for eg :-
 */
@Composable
fun SideEffect(){
    var count =  remember {
        mutableStateOf(0)
    }
    var key = count.value%3 == 0

    LaunchedEffect(key1 = key){
        Log.d("Counter",""+count.value)
    }
    Button(onClick = {
        count.value++
    }) {
        Text(text = "Counter Msg")
    }

}