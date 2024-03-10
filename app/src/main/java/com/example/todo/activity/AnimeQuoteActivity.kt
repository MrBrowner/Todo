package com.example.todo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.todo.databinding.ActivityAnimeQuoteBinding
import com.example.todo.vm.AnimeQuoteVM
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber
import com.techiness.progressdialoglibrary.ProgressDialog;

class AnimeQuoteActivity : AppCompatActivity() {

    private val vm: AnimeQuoteVM by viewModel()
    private lateinit var bind: ActivityAnimeQuoteBinding

    private val progressBar by lazy {
        ProgressDialog(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityAnimeQuoteBinding.inflate(layoutInflater)
        setContentView(bind.root)

        Timber.e(vm.msg)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                vm.q2.collectLatest {
                    progressBar.dismiss()
                    it?.let {
                        bind.tvQuote.text = it.quote
                    }
                    Timber.tag("q2").e(it.toString()) // initial data (null) is also emitted
                }
            }
        }

        bind.btnShuffle.setOnClickListener {
            progressBar.show()
            vm.generateRandomQuote()
        }
    }
}