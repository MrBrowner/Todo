package com.example.todo.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.todo.databinding.ActivityMainBinding
import com.example.todo.domain.model.AnimeQuote
import com.example.todo.vm.MainVM
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val vm: MainVM by viewModels<MainVM>()
    private lateinit var bind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        Timber.e("onCreate: " + vm.t1)

        val one = AnimeQuote(0L, "life", "mE", "XyX")
        Timber.tag("a1").e(Json.encodeToString(one))

        val two = """{"anime":"life","character":"mE","quote":"XyX"}"""
        Timber.tag("a2").e(Json.decodeFromString<AnimeQuote>(two).toString())

        bind.btn1Quote.setOnClickListener {
            startActivity(Intent(this, AnimeQuoteActivity::class.java))
        }
    }
}