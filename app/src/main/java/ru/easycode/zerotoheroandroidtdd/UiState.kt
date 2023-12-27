package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {
    fun apply(decrement: Button, increment: Button, textView: TextView)
    data class Min(private val text: String) : UiState {
        override fun apply(decrement: Button, increment: Button, textView: TextView) {
            textView.text = text
            decrement.isEnabled = false
            increment.isEnabled = true
        }
    }

    data class Base(private val text: String) : UiState {
        override fun apply(decrement: Button, increment: Button, textView: TextView) {
            textView.text = text
            increment.isEnabled = true
            decrement.isEnabled = true
        }
    }

    data class Max(private val text: String) : UiState {
        override fun apply(decrement: Button, increment: Button, textView: TextView) {
            textView.text = text
            increment.isEnabled = false
            decrement.isEnabled = true
        }
    }
}
