package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var textView: TextView
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.actionButton)
        textView = findViewById(R.id.titleTextView)
        progressBar = findViewById(R.id.progressBar)
        button.setOnClickListener {
            button.isEnabled = false
            progressBar.visibility = View.VISIBLE
            button.postDelayed({
                textView.visibility = View.VISIBLE
                progressBar.visibility = View.GONE
                button.isEnabled = true
            }, 1234)
        }
    }
}
