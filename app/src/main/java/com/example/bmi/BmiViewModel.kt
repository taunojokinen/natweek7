package com.example.bmi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BmiViewModel: ViewModel() {
    var weightInput by mutableStateOf("")

    var heightInput by mutableStateOf("")

    var bmi: Float = 0.0f
        get() {
            return calculate(weight,height)
        }

    private var height: Float = 0.0f
        get() {
            return heightInput.toFloatOrNull() ?: 0.0f
        }
    private var weight = 0
        get() {
            return weightInput.toIntOrNull() ?: 0
        }


    fun changeHeightInput(value: String) {
        heightInput = value
    }
    fun changeWeightInput(value: String) {
        weightInput = value
    }

    private fun calculate(weight:Int, height:Float): Float {
        return if (weight > 0 && height > 0.0f) weight / (height * height) else 0.0f
    }
}