package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var increment: Button
    private lateinit var decrement: Button
    private lateinit var textView: TextView
    private lateinit var linearLayout: LinearLayout
    private lateinit var uiState: UiState
    private var count = Count.Base(2, 4, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        increment = findViewById(R.id.incrementButton)
        decrement = findViewById(R.id.decrementButton)
        textView = findViewById(R.id.countTextView)
        linearLayout = findViewById(R.id.rootLayout)
        increment.setOnClickListener {
            uiState = count.increment(textView.text.toString())
            uiState.apply(increment = increment, decrement = decrement, textView = textView)
        }
        decrement.setOnClickListener {
            uiState = count.decrement(textView.text.toString())
            uiState.apply(increment = increment, decrement = decrement, textView = textView)
        }
        if (savedInstanceState == null) {
            uiState = count.initial(textView.text.toString())
            uiState.apply(decrement, increment, textView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, uiState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable(KEY, UiState::class.java) as UiState
        } else {
            savedInstanceState.getSerializable(KEY) as UiState
        }
    }

    companion object {
        const val KEY = "key"
    }
}
