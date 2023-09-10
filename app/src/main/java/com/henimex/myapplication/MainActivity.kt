package com.henimex.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import com.henimex.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnPlus.setOnClickListener {
            binding.txtResult.text = typeResult(makeCalculation(1))
        }

        binding.btnMinus.setOnClickListener {
            binding.txtResult.text = typeResult(makeCalculation(2))
        }

        binding.btnMultiple.setOnClickListener {
            binding.txtResult.text = typeResult(makeCalculation(3))
        }

        binding.btnDevide.setOnClickListener {
            binding.txtResult.text = typeResult(makeCalculation(4))
        }
    }

    private fun typeResult(result: Double): String {
        hideKeyboard();
        return "Result : $result"
    }

    private fun makeCalculation(operation: Int): Double {
        val numOne = binding.txtNumberOne.text.toString().toDouble();
        val numTwo = binding.txtNumberTwo.text.toString().toDouble();

        return when (operation) {
            1 -> numOne + numTwo
            2 -> numOne - numTwo
            3 -> numOne * numTwo
            4 -> numOne / numTwo
            else -> {
                0.0
            }
        }
    }

    private fun hideKeyboard(){
        binding.txtNumberOne.onEditorAction(EditorInfo.IME_ACTION_DONE)
        binding.txtNumberTwo.onEditorAction(EditorInfo.IME_ACTION_DONE)
    }

}