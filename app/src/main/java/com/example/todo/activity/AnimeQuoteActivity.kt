package com.example.todo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todo.databinding.ActivityAnimeQuoteBinding
import com.example.todo.vm.AnimeQuoteVM
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class AnimeQuoteActivity : AppCompatActivity() {

    private val vm: AnimeQuoteVM by viewModel()
    private lateinit var bind: ActivityAnimeQuoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityAnimeQuoteBinding.inflate(layoutInflater)
        setContentView(bind.root)

        Timber.e(vm.msg)
        vm.quote.observe(this) {
            Timber.tag("quote").e(it.toString())
        }

        bind.btnShuffle.setOnClickListener {
            vm.generateRandomQuote()
        }
    }
}