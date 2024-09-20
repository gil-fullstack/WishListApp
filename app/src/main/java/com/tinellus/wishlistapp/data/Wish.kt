package com.tinellus.wishlistapp.data

data class Wish(
    val id:Int = 0,
    val title:String = "",
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