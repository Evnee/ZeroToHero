package ru.easycode.zerotoheroandroidtdd

interface Count {

    class Base(private val step: Int) : Count {
        init {
            if (step < 1) throw IllegalStateException("step should be positive, but was $step")
        }

        override fun increment(number: String): String {
            val result = step + number.toInt()
            return result.toString()
        }
    }

    fun increment(number: String): String
}
