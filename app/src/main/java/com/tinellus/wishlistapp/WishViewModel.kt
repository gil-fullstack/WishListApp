package com.tinellus.wishlistapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.tinellus.wishlistapp.data.Wish
import com.tinellus.wishlistapp.data.WishRepository
import kotlinx.coroutines.flow.Flow

class WishViewModel(
    private val wishRepository: WishRepository
):ViewModel() {

    var wishTitleState by mutableStateOf("")
    var wishDescription by mutableStateOf("")

    fun onWishTitleChanged(newString:String){
        wishTitleState = newString
    }

    fun onDescriptionState(newString:String){
        wishDescription = newString
    }

    lateinit var getAllWishes: Flow<List<Wish>>
}