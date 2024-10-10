package com.tinellus.wishlistapp

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.DismissDirection
import androidx.compose.material.DismissValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FractionalThreshold
import androidx.compose.material.LocalContentColor
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.tinellus.wishlistapp.data.DummyWish
import com.tinellus.wishlistapp.data.Wish

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(
    navController: NavController,
    viewModel: WishViewModel
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            AppBarView(title = "WishList") {
                Toast.makeText(context, "Button Clicked", Toast.LENGTH_LONG).show()
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(all = 28.dp),
                contentColor = Color.White,
                backgroundColor = Color.Black,
                onClick = {
                    Toast.makeText(context, "FAButton clicked", Toast.LENGTH_LONG).show()
                    navController.navigate(Screen.AddScreen.route + "/0L")
                })
            {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                    tint = LocalContentColor.current
                )
            }
        },
        modifier = Modifier.padding(top = 20.dp)
    ) {
        val wishList = viewModel.getAllWishes.collectAsState(initial = listOf())
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
//            items(DummyWish.wishList){
//                    wish -> WishItem(wish = wish) {
//                }
//            }
            items(wishList.value, key = {wish -> wish.id}){
                    wish ->
                    val dismissState = rememberDismissState(
                        confirmStateChange = {
                            if(it == DismissValue.DismissedToEnd || it == DismissValue.DismissedToStart){
                                viewModel.deleteWish(wish)
                            }
                            true
                        }
                    )

                   SwipeToDismiss(
                       state = dismissState,
                       background = {
                           val color by animateColorAsState(
                               if(dismissState.dismissDirection == DismissDirection.EndToStart) Color.Red else Color.Transparent
                               , label = ""
                           )
                           val alignment = Alignment.CenterEnd
                           Box(
                               Modifier.fillMaxSize().background(color).padding(horizontal = 20.dp)
                           ){
                               Icon(Icons.Default.Delete, contentDescription = "Delete Icon", tint = Color.White)
                           }
                       },
                       directions = setOf(DismissDirection.StartToEnd, DismissDirection.EndToStart),
                       dismissThresholds = { FractionalThreshold(0.25f)},
                       dismissContent = {
                           WishItem(wish = wish) {
                               val id = wish.id
                               navController.navigate(Screen.AddScreen.route+ "/$id")
                           }
                       }
                   )

            }
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

@Composable
fun WishItem(wish: Wish, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, top = 8.dp, end = 8.dp)
            .clickable { onClick() },
        elevation = 10.dp,
        backgroundColor = Color.White
    ) {
       Column(modifier = Modifier.padding(16.dp)) {
          Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
          Text(text = wish.description,)
       }

    }
}