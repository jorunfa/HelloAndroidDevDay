package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class HelloWorldViewModel(application: Application) : AndroidViewModel(application) {
    private val world = application.getString(R.string.world)
    private val helloWorld = application.getString(R.string.hello_something, world)

    val name = MutableLiveData<String>().apply {
        value = helloWorld
    }

    fun onTextChange(s : String) {
        name.value = if (s.isNotBlank()) getApplication<Application>().getString(R.string.hello_something, s) else helloWorld
    }
}
