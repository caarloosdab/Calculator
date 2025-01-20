package com.example.calculator

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.mozilla.javascript.Context
import org.mozilla.javascript.Scriptable

// ViewModel class responsible for managing UI-related data and business logic for the Calculator
class CalculatorViewModel : ViewModel() {

    // MutableLiveData is used to store and update the equation text
    private val _equationText = MutableLiveData("")
    // Public LiveData to expose the equation text, only allowing read access outside of the ViewModel
    val equationText: LiveData<String> = _equationText

    // MutableLiveData for storing and updating the result text of the equation
    private val _resultText = MutableLiveData("0")
    // Public LiveData to expose the result text, only allowing read access outside of the ViewModel
    val resultText: LiveData<String> = _resultText

    // Function that is called when a button is clicked in the UI
    fun onButtonClick(btn: String) {
        // Log the clicked button for debugging purposes
        Log.i("Clicked Button", btn)

        // Check the current value of the equationText and process the button click accordingly
        _equationText.value?.let {
            // Handling special cases for certain buttons
            when (btn) {
                "." -> {
                    // Clear the equation and reset the result when the dot button is clicked
                    _equationText.value = ""
                    _resultText.value = "0"
                }
            }

            // Clear the equation and reset result when the "AC" button is clicked
            if (btn == "AC") {
                _equationText.value = ""
                _resultText.value = "0"
                return
            }

            // If the "C" button is clicked, remove the last character from the equation text
            if (btn == "C") {
                if (it.isNotEmpty()) {
                    _equationText.value = it.substring(0, it.length - 1)
                }
                return
            }

            // If the "=" button is clicked, set the equation text to the result
            if (btn == "=") {
                _equationText.value = _resultText.value
                return
            }

            // If it's any other button, append the button's value to the equation text
            _equationText.value = it + btn

            // Try to calculate the result of the equation and update the result text
            try {
                _resultText.value = calculateResult(_equationText.value.toString())
            } catch (_: Exception) {
                // If there is an error during calculation, just ignore it (prevent crash)
            }

            // Log the current equation for debugging purposes
            Log.i("Equation", _equationText.value.toString())
        }
    }

    // Function to calculate the result of the equation string using JavaScript's evaluation engine
    fun calculateResult(equation: String): String {
        // Enter the JavaScript context using Rhino (a JavaScript runtime)
        val context: Context = Context.enter()
        // Disable optimization to make sure the JavaScript engine works correctly in our context
        context.optimizationLevel = -1
        // Initialize a standard JavaScript environment
        val scriptable: Scriptable = context.initStandardObjects()

        // Evaluate the string equation using the JavaScript engine
        var finalResult = context.evaluateString(scriptable, equation, "JavaScript", 1, null).toString()

        // If the result ends with ".0" (indicating it's a whole number), remove the decimal part
        if (finalResult.endsWith(".0")) {
            finalResult = finalResult.replace(".0", "")
        }

        // Return the result as a string
        return finalResult
    }
}
