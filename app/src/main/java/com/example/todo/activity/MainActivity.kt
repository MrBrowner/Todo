package com.example.todo.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.todo.R
import com.example.todo.vm.MainVM
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val vm: MainVM by viewModels<MainVM>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.e("onCreate: " + vm.t1)
    }
}