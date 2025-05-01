package com.pratice.jetpackcompose

import android.util.Log
import android.view.ViewTreeObserver
import android.view.Window
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/*
Disposable effect bhi ek type ka side effect jo use hota hai composable things ko dispose karna jo
bhi chiz background mai run ho rahi hai usko agar dispose karna hai if we change the screen or app close we use
Disposable effect

 */
@Composable
fun DisposableApps() {
    KeyboardComposable()
    TextField(value = "", onValueChange ={} )
}
@Composable
fun KeyboardComposable(){
    val view = LocalView.current

    DisposableEffect(key1 = Unit){
        val listener = ViewTreeObserver.OnGlobalLayoutListener {
            val insert = ViewCompat.getRootWindowInsets(view)
            val isKeyboradVisible = insert?.isVisible(WindowInsetsCompat.Type.ime())
            Log.d("Deepak",isKeyboradVisible.toString())
        }
      view.viewTreeObserver.addOnGlobalLayoutListener(listener)
        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(listener)
        }
    }
}