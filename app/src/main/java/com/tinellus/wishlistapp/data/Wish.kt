package com.tinellus.wishlistapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wish-table")
data class Wish(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    @ColumnInfo(name = "wish-title")
    val title:String = "",
    @ColumnInfo(name = "wish-desc")
    val description:String =""
)

object DummyWish{
    val wishList = listOf(
        Wish(title = "Oculus Quest2", description = "Test1"),
        Wish(title = "My test 2", description = "Test2 ===="),
        Wish(title = "A Sci-fi Book", description = "Test3 ------"),
        Wish(title = "Bean Bag", description = "Test 55555555"),
    )
}