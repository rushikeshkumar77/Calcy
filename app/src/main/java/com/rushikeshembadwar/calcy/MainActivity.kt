package com.rushikeshembadwar.calcy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.rushikeshembadwar.calcy.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonClear.setOnClickListener {

            binding.input.text = ""
            binding.output.text = ""

        }

        binding.buttonBracketLeft.setOnClickListener {
            binding.input.text = addInputText("(")
        }

        binding.buttonBracketRight.setOnClickListener {
            binding.input.text = addInputText(")")
        }

        binding.button0.setOnClickListener {
            binding.input.text = addInputText("0")
        }

        binding.button1.setOnClickListener {
            binding.input.text = addInputText("1")
        }

        binding.button2.setOnClickListener {
            binding.input.text = addInputText("2")
        }

        binding.button3.setOnClickListener {
            binding.input.text = addInputText("3")
        }

        binding.button4.setOnClickListener {
            binding.input.text = addInputText("4")
        }

        binding.button5.setOnClickListener {
            binding.input.text = addInputText("5")
        }

        binding.button6.setOnClickListener {
            binding.input.text = addInputText("6")
        }

        binding.button7.setOnClickListener {
            binding.input.text = addInputText("7")
        }

        binding.button8.setOnClickListener {
            binding.input.text = addInputText("8")
        }

        binding.button9.setOnClickListener {
            binding.input.text = addInputText("9")
        }

        binding.buttonDot.setOnClickListener {
            binding.input.text = addInputText(".")
        }

        binding.buttonDivision.setOnClickListener {
            binding.input.text = addInputText("÷")
        }

        binding.buttonSubtraction.setOnClickListener {
            binding.input.text = addInputText("-")
        }

        binding.buttonMultiply.setOnClickListener {
            binding.input.text = addInputText("×")
        }

        binding.buttonAddition.setOnClickListener {
            binding.input.text = addInputText("+")
        }

        binding.buttonEquals.setOnClickListener {
            showResult()
        }
    }

    private fun addInputText(buttonValue: String): String{
        return "${binding.input.text}$buttonValue"
    }

    private fun getInputExpression(): String{

        var expression = binding.input.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression

    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                binding.output.text = "Error"
                binding.output.setTextColor(ContextCompat.getColor(this, R.color.red))
            } else {
                // Show Result
                binding.output.text = DecimalFormat("0.######").format(result).toString()
                binding.output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        } catch (e: Exception) {
            // Show Error Message
            binding.output.text = "Error"
            binding.output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }
}