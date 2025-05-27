package ru.normno.mynavigation3

import androidx.lifecycle.ViewModel

class DetailsViewModel : ViewModel() {
    init {
        println("INITIALIZING DETAILS VIEWMODEL...")
    }

    override fun onCleared() {
        super.onCleared()
        println("CLEARING DETAILS VIEWMODEL...")
    }
}