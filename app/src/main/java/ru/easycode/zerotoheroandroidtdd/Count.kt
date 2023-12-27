package ru.easycode.zerotoheroandroidtdd

interface Count {

    data class Base(private val step: Int, private val max: Int, private val min: Int) : Count {
        init {
            if (max < 1) throw IllegalStateException("max should be positive, but was $max")
            if (step < 1) throw IllegalStateException("step should be positive, but was $step")
            if (max < min) throw IllegalStateException("max should be more than min")
            if (step > max) throw IllegalStateException("max should be more than step")
        }

        override fun initial(number: String): UiState {
            return when (number.toInt()) {
                max -> UiState.Max(number)
                min -> UiState.Min(number)
                else -> UiState.Base(number)
            }
        }

        override fun increment(number: String): UiState {
            val digits = number.toInt()
            val result = digits + step
            return initial(result.toString())
        }

        override fun decrement(number: String): UiState {
            val digits = number.toInt()
            val result = digits - step
            return initial(result.toString())
        }
    }

    fun initial(number: String): UiState
    fun increment(number: String): UiState
    fun decrement(number: String): UiState
}
