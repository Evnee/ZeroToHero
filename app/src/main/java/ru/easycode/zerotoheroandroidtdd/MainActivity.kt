package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var textView: TextView
    private lateinit var progressBar: ProgressBar
    private val viewModel =
        MainViewModel(repository = Repository.Base(), liveDataWrapper = LiveDataWrapper.Base())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = findViewById(R.id.progressBar)
        button = findViewById(R.id.actionButton)
        textView = findViewById(R.id.titleTextView)
        button.setOnClickListener {
            viewModel.load()
        }
        viewModel.liveData().observe(this) {
            it.apply(textView, button, progressBar)
        }
    }
}
