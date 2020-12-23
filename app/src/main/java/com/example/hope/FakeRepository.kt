package com.example.hope

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
//import kotlin.random.Random
import java.util.Random

object FakeRepository {
    private val fruitNames :List<String> = listOf(
        "Apple", "Banana", "Orange", "Kiwi","Grapes",
        "Pear","Strawberry","Gooseberry","Raspberry","Mango"
    )
    private val _currentRandomFruitName =  MutableLiveData<String>()
    val currentRandomFruitName :LiveData<String>
      get() = _currentRandomFruitName
    init {
        _currentRandomFruitName.value = fruitNames.first()

    }
    fun getRandomFruitName(): String{
        val random = Random()
        return fruitNames[random.nextInt(fruitNames.size)]
    }

    fun changeCurrentRandomFruitName(){
        _currentRandomFruitName.value = getRandomFruitName()
    }
}