package com.example.androidfirst

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private val calculatorModel = CalculatorModel()

    private val _result = MutableLiveData<String>()
    val result: LiveData<String> get() = _result

    fun setNum1(value: Int) {
        calculatorModel.num1 = value
    }

    fun setNum2(value: Int) {
        calculatorModel.num2 = value
    }

    fun calculateSum() {
        val sum = calculatorModel.num1 + calculatorModel.num2
        _result.value = "Sum: $sum"
    }
}