package com.pratice.jetpackcompose

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

/*
Why we use rememberUpdateState
1)jab hum kuch code background mai run kar raha hai and it is taking time so mera update data should be pass
in that so we use rememberupdatestate 
 */
@Composable
fun RememberUpdateState(){
    var counter = remember {
        mutableStateOf(0)
    }
    LaunchedEffect(key1 = Unit){
        delay(2000)
        counter.value =10
    }
    Counter(counter.value)

}

@Composable
fun Counter(value: Int) {
    var state = rememberUpdatedState(newValue = value)
     LaunchedEffect(key1 = Unit ){
         /*this launcheffect taking time for excution of code and the data is not updating and ye 0 he
          print kar raha hai because launcheffect recomposable nahi hai initial componsable
          to remember the data update we use RememberUpdateState

          delay(5000)
          Log.d("Counter","Counter - ${value.toString()}")
          */
         delay(5000)
         Log.d("Counter","Counter - ${state.value.toString()}")

     }
    Text(text = value.toString())
}
