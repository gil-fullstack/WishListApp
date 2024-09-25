package com.tinellus.wishlistapp

import android.content.Context
import androidx.room.Room
import com.tinellus.wishlistapp.data.WishDatabase
import com.tinellus.wishlistapp.data.WishRepository

object Graph {

    lateinit var daatabase: WishDatabase

    val wishRepository by lazy {
        WishRepository(wishDao = daatabase.wishDao())
    }

    fun provide(context: Context){
        daatabase = Room.databaseBuilder(context, WishDatabase::class.java, "wishlist.db").build()
    }
}