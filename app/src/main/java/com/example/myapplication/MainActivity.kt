package com.example.myapplication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val helloWorldViewModel = ViewModelProviders.of(this).get(HelloWorldViewModel::class.java)

        helloWorldViewModel.name.observe(this, Observer {
            findViewById<TextView>(R.id.textView).text = it
        })

        findViewById<EditText>(R.id.editText).addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                helloWorldViewModel.onTextChange(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}
