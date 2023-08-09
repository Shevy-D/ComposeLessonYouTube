package com.shevy.composelessonyoutube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shevy.composelessonyoutube.ui.theme.Green80

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Green80)
            ) {
                itemsIndexed(
                    listOf(
                        ItemRowModel(R.drawable.image_1, "Image 1", "Test sdjbdsakjdsbkjadsbdcbbjcabjcd sdbcjcbbkjdjkcd ckbjcabjkdbjdbjksdbjksd cbsakjbdbjkds" +
                                "cacbdabdsakbjdsjkdkjdscjkdkjdajkdjnkdnjdjadnsjk jdsanckjndackla"),
                        ItemRowModel(R.drawable.image_2, "Image 2", "Test"),
                        ItemRowModel(R.drawable.image_3, "Image 3", "Test"),
                        ItemRowModel(R.drawable.image_4, "Image 4", "Test"),
                        ItemRowModel(R.drawable.image_5, "Image 5", "Test"),
                        ItemRowModel(R.drawable.image_6, "Image 6", "Test")
                    )
                ) { _, item ->
                    MyRow(item = item)
                }
            }
        }
    }
}

