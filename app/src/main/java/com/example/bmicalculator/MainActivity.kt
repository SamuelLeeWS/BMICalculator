package com.example.bmicalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.doneButton).setOnClickListener {
            calculate(it)
            doneButton.setBackgroundColor(Color.rgb(173,216,230))
        }
        findViewById<Button>(R.id.resetButton).setOnClickListener {
            reset(it)
            resetButton.setBackgroundColor(Color.rgb(173,216,230))
        }
    }

        private fun calculate(view: View) {
            try {
                val weightString = weightInput.text.toString()
                val heightString = heightInput.text.toString()

                val weight: Double = weightString.toDouble()
                val height: Double = heightString.toDouble()

                val heightInMeter = height / 100
                val BMI = weight / (heightInMeter * heightInMeter)

                if (BMI <= 18.5) {
                    picture.setImageResource(R.drawable.under)
                    display.text = "Underweight " + String.format("%.2f", BMI)
                    display.setTextColor(Color.RED)
                } else if (BMI > 18.5 && BMI <= 24.9) {
                    picture.setImageResource(R.drawable.normal)
                    display.text = "Normal " + String.format("%.2f", BMI)
                    display.setTextColor(Color.GREEN)
                } else if (BMI >= 25) {
                    picture.setImageResource(R.drawable.over)
                    display.text = "Overweight " + String.format("%.2f", BMI)
                    display.setTextColor(Color.RED)
                }
            }catch (ex:Exception)
            {
                val toast:Toast = Toast.makeText(this, "Invalid Input", Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
            }

        }

    private fun reset(view: View) {
        weightInput.setText("")
        heightInput.setText("")
        display.setText("")
        picture.setImageResource(R.drawable.empty)
    }
}