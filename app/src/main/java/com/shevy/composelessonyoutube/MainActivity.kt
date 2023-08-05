package com.shevy.composelessonyoutube

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                ListItem("Dmitriy Shev", "Engineer")
                ListItem("Dmitriy Shev", "Engineer")
                ListItem("Dmitriy Shev", "Engineer")
                ListItem("Dmitriy Shev", "Engineer")
                ListItem("Dmitriy Shev", "Engineer")
                ListItem("Dmitriy Shev", "Engineer")
                ListItem("Dmitriy Shev", "Engineer")
                ListItem("Dmitriy Shev", "Engineer")
                ListItem("Dmitriy Shev", "Engineer")
                ListItem("Dmitriy Shev", "Engineer")
                ListItem("Dmitriy Shev", "Engineer")
            }
        }
    }

    @Composable
    private fun ListItem(name: String, prof: String) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .pointerInput(Unit){
                    detectDragGesturesAfterLongPress { change, dragAmount ->
                        Log.d("TestLog", "Long press: $dragAmount")
                    }
                }
                .clickable {
                    Log.d("TestLog", "Clicked")
                },
            shape = RoundedCornerShape(15.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.photo),
                            contentDescription = "image",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                //.padding(5.dp)
                                .size(64.dp)
                            //.clip(CircleShape)
                        )
                        Column(
                            modifier = Modifier.padding(start = 16.dp)
                        ) {
                            Text(text = name)
                            Text(text = prof)
                        }
                    }
                }
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Column(
                        modifier = Modifier
                            .background(Color.Blue)
                            .height(64.dp)
                            .width(20.dp),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.End
                    ) { }
                }
            }
        }
    }
}

