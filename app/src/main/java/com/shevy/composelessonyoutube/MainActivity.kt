package com.shevy.composelessonyoutube

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.unit.dp
import com.shevy.composelessonyoutube.ui.theme.ComposeLessonYouTubeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLessonYouTubeTheme {
                MainScreen(applicationContext)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(context: Context) {
    val coroutineScope = rememberCoroutineScope()
    val scaffoldState = remember { SnackbarHostState() }

    Scaffold(
        snackbarHost = {
            SnackbarHost(scaffoldState) { data ->
                Snackbar(
                    actionColor = Green,
                    snackbarData = data,
                    shape = RoundedCornerShape(20.dp),
                    contentColor = Green,
                    modifier = Modifier.padding(bottom = 100.dp)
                )
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Menu")
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Yellow),
                navigationIcon = {
                    IconButton(
                        onClick = {
                            Toast.makeText(context, "Menu", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            coroutineScope.launch {
                                val result = scaffoldState.showSnackbar(
                                    message = "Item deleted!",
                                    actionLabel = "Undone"
                                )
                                if (result == SnackbarResult.ActionPerformed) {
                                    Toast.makeText(context, "Item recovered", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            }
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Delete,
                            contentDescription = "Delete"
                        )
                    }
                    IconButton(
                        onClick = {
                            Toast.makeText(context, "Share", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Share,
                            contentDescription = "Share"
                        )
                    }
                }
            )
        }
    ) {

    }
}