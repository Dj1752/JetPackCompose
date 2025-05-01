package com.pratice.jetpackcompose

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*
Disadvantage of LaunchedEffect
1) launched effect is a composable to ye event mai use nahi ho sakta means mai kisi view mai call nahi kar sakta hu isko
2) launched effect is has own composable so humlog usko control nahi kar sakte hai kab start hoga kab end hoga
3) launched effect is initialcomposable or statecomposable means jab function initialized hota hai tab coroutine call hoga and jab mai kuch state change karunga tab hota
 to tackle this humlo remembercoroutine ka use karte hai
 */

@Composable
fun RememberCoroutine(){
    var counter = remember {
        mutableStateOf(0)
    }
    var scope = rememberCoroutineScope()
    var text = "Counter is running - ${counter.value}"
    if (counter.value == 10){
        text = "Conter Stopped"
    }
    Column {
        Button(onClick = {/// here we can use coroutine in button view and we have control when we start our coroutine
            scope.launch {
                Log.d("LaunchEffect","Started.....")
                try {
                    for (i in 1..10) {
                        counter.value++
                        delay(1000)
                    }
                }catch (e:Exception){
                    Log.d("LaunchedEffectComposable","Exception - ${e.message.toString()}")
                }
            }
        }) {
            Text(text = "Clicked")
        }
        Text(text = text)
    }




}

@Composable
fun LaunchedEffectComposble(){///with out RememberCoroutine
    var counter = remember {
        mutableStateOf(0)
    }

    LaunchedEffect(key1 = Unit){
        Log.d("LaunchEffect","Started.....")
        try {
            for (i in 1..10) {
             counter.value++
             delay(1000)
            }
        }catch (e:Exception){
            Log.d("LaunchedEffectComposable","Exception - ${e.message.toString()}")
        }
    }
    /*
    Button(onClick = { LaunchedEffect(key1 = , block = ) }) {

    }
    this error is showing when we put launcheffect in button
    Composable invocations can only happen from the context of a @Composable function
     */
    var text = "Counter is running - ${counter.value}"
    if (counter.value == 10){
        text = "Conter Stopped"
    }
    Text(text = text)
}