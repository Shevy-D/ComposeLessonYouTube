package com.shevy.composelessonyoutube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shevy.composelessonyoutube.ui.theme.ComposeLessonYouTubeTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val searchText = remember { mutableStateOf("") }
            ComposeLessonYouTubeTheme {
                SearchBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    query = searchText.value,
                    onQueryChange = { text ->
                        searchText.value = text
                    },
                    onSearch = { },
                    placeholder = { Text(text = "Search...") },
                    active = false,
                    onActiveChange = { }
                ) { }
            }
        }
    }
}