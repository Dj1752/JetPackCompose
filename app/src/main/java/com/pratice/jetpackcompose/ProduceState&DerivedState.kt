package com.pratice.jetpackcompose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

/*
Why we use Produce state
producestate isliye use hota humlog state and launcheffect combine use kar sakte hai
for eg:-

 */
@Composable
fun ProduceStateComposable() {
    /*
    without produce sate here we use both state and launcheffect
    val state = remember {
        mutableStateOf(0)
    }

    LaunchedEffect(key1 = Unit){
        for (i in 1..10){
            state.value++
        }
    }
    Text(text = state.value.toString(), style = MaterialTheme.typography.headlineLarge)


     */
    val state = produceState(initialValue = 0){
        for (i in 1..10){
          delay(1000)
            value++
        }
    }
    Text(text = state.value.toString(), style = MaterialTheme.typography.headlineLarge)
}
/*
why we use Derived state 
jab humai mutli state ko  ek state assign kar ke use karna hota hai tab hum 
derived state ka use karte hai

 */
@Composable
fun DerivedStateComposable() {
    val tableof= remember {
        mutableStateOf(5)
    }
    val index = produceState(initialValue = 1){
       repeat(9){
           delay(1000)
           value = value+1
       }
        
    }
    
    val message = derivedStateOf{ 
        "${tableof.value} * ${index.value} = ${tableof.value * index.value}"
    }
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(1f)){
        Text(text = message.value, style = MaterialTheme.typography.headlineLarge)
    }
    
}