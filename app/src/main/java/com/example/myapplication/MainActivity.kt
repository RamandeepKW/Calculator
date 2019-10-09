package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnNumberClick(view: View) {
        if (isNewOperator)
            inputData.setText("")
        isNewOperator = false
        val btnSelected = view as Button
        var number: String = inputData.text.toString()

        when (btnSelected.id) {
            one.id -> number += "1"
            two.id -> number += "2"
            three.id -> number += "3"
            four.id -> number += "4"
            five.id -> number += "5"
            six.id -> number += "6"
            seven.id -> number += "7"
            eight.id -> number += "8"
            nine.id -> number += "9"
            zero.id -> number += "0"
            point.id -> {
                //todo prevent adding more than one dot
                if (!number.contains("."))
                    number += "."
            }
            positiveNegative.id -> {
                number = "- $number"
            }
        }
        inputData.setText(number)
    }

    fun btnPositiveNegative(view: View) {
        val btnSelected = view as Button
    }

    var op = "*"
    var oldNumber = ""
    var isNewOperator = true

    fun btnOperationClick(view: View) {
        val btnSelected = view as Button
        when (btnSelected.id) {
            multiply.id -> op = "*"
            divide.id -> op = "/"
            add.id -> op = "+"
            subtract.id -> op = "-"
        }
        oldNumber = inputData.text.toString()
        isNewOperator = true
    }

    fun btnEqualClick(view: View) {
        val btnSelected = view as Button
        val newNumber = inputData.text.toString()
        var finalNumber: Double? = null
        when (op) {
            "*" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }

        }
        inputData.setText(finalNumber.toString())
        isNewOperator = true
    }

    fun btnPercent(view: View) {
        val number: Double = inputData.text.toString().toDouble()/100
        inputData.setText(number.toString())
        isNewOperator = true
    }

    fun btnCleanClick(view: View) {
        inputData.setText("0")
        isNewOperator = true
    }

}
