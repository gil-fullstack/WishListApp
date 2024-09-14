package com.tinellus.wishlistapp

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.LocalContentColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView() {
   val context = LocalContext.current
   Scaffold(
      topBar = { AppBarView(title = "WishList") {
         Toast.makeText(context, "Button Clicked", Toast.LENGTH_LONG).show()
      }
      },
      floatingActionButton = {
         FloatingActionButton(
            modifier = Modifier.padding(all = 28.dp),
            contentColor = Color.White,
            backgroundColor = Color.Black,
            onClick = { /*TODO*/ }) 
         {
            Icon(imageVector = Icons.Default.Add, contentDescription = null, tint = LocalContentColor.current)
         }
      },
      modifier = Modifier.padding(top = 20.dp)
   ) {
      LazyColumn(modifier = Modifier
         .fillMaxSize()
         .padding(it)) {

      }
   }

//   Scaffold(
//     topBar = {
//
//         TopAppBar(
//             title = {
//                 Text(
//                     text = "Testo teste",
//                     color = MaterialTheme.colorScheme.onPrimary
//                 )
//             },
//             colors = TopAppBarDefaults.topAppBarColors(
//                 containerColor = MaterialTheme.colorScheme.primary
//             )
//         )
//     }
//   ) {
//
//   }
}