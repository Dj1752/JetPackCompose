package com.pratice.jetpackcompose

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
public fun Recomposable(){
    val state = remember {
        mutableStateOf(0.0)
    }
    Log.d("Tagged","Logged during Initial composable")
    Button(onClick = { 
        state.value =Math.random()
    }) {
        Log.d("Tagged","Logged during both Initial composable & Recomposition")
        Text(text = state.value.toString())
    }
}

/*
🔄 Recomposable in Jetpack Compose:
A recomposable is a Composable function or part of the UI that is re-executed (recomposed) automatically by the Compose runtime when the state(data) it depends on changes, in order to update the UI.

⚙️ When does recomposition happen?
When a State, MutableState, or LiveData/Flow (via collectAsState) changes

When remember or derivedStateOf values are updated

When you explicitly call invalidate() in custom state management

🧠 Why is recomposition important?
Because Jetpack Compose uses declarative UI, you describe the UI, and Compose updates only what changes, efficiently, through recomposition.
 */