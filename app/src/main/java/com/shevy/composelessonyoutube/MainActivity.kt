package com.shevy.composelessonyoutube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.shevy.composelessonyoutube.bottom_navigation.MainScreen
import com.shevy.composelessonyoutube.ui.theme.ComposeLessonYouTubeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLessonYouTubeTheme {
                MainScreen()
            }
        }
    }
}