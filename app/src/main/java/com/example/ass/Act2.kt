package com.example.ass

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Act2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act2)
    }

    fun backButton(view : View) {
        setResult(Activity.RESULT_CANCELED)
        finish()
    }
}