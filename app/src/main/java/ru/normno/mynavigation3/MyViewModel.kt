package ru.normno.mynavigation3

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    val backStack = mutableStateListOf<Screen>(Screen.Home)
}