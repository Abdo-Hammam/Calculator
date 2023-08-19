package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var buttonPlus :Button
    lateinit var buttonMinus :Button
    lateinit var buttonMulti :Button
    lateinit var buttonDiv :Button
    lateinit var buttonopp :Button
    lateinit var buttonresult :Button
    lateinit var textNumber :TextView
    lateinit var clearButton :Button
    lateinit var currentOperation :Operation

    var lastNumber:Double =  0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        initView()
        addCallBacks()
    }

    private fun addCallBacks() {
        clearButton.setOnClickListener { clearInput() }

        buttonPlus.setOnClickListener {
            prepareOperation(Operation.Plus)
        }
        buttonMinus.setOnClickListener {
            prepareOperation(Operation.Minus)
        }
        buttonMulti.setOnClickListener {
            prepareOperation(Operation.Multiplcate)
        }
        buttonDiv.setOnClickListener {
            prepareOperation(Operation.Div)
        }
        buttonopp.setOnClickListener {
            prepareOperation(Operation.Oop)
        }
        buttonresult.setOnClickListener {
            val finalResult = doCurrentOperation()
            textNumber.text = finalResult.toString()
        }
    }

    private fun doCurrentOperation():Double {
        val secondNumber = textNumber.text.toString().toDouble()
        return when(currentOperation){
            Operation.Plus -> lastNumber + secondNumber
            Operation.Minus -> lastNumber - secondNumber
            Operation.Multiplcate -> lastNumber * secondNumber
            Operation.Div -> lastNumber / secondNumber
            Operation.Oop -> lastNumber % secondNumber
        }
    }

    private fun prepareOperation(operation :Operation) {
        lastNumber = textNumber.text.toString().toDouble()
        clearInput()
        currentOperation = operation
    }

    private fun clearInput() {
        textNumber.text = ""
    }

    private fun initView() {
        buttonPlus = findViewById(R.id.button_plus)
        buttonMinus = findViewById(R.id.button_minus)
        buttonMulti = findViewById(R.id.button_multiplication)
        buttonDiv = findViewById(R.id.button_div)
        buttonresult = findViewById(R.id.button_result)
        textNumber = findViewById(R.id.text_view)
        clearButton = findViewById(R.id.button_C)
        buttonopp = findViewById(R.id.appCompatButton12)
    }

    fun onClickNumber (v :View) {
        val newDigit = (v as Button).text.toString()
        val oldDigits = textNumber.text.toString()
        val newTextNumber = oldDigits + newDigit
        textNumber.text = newTextNumber
    }

}