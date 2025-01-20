package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.calculator.ui.theme.CalculatorTheme

// Main Activity class where the calculator app is initialized and UI is set up
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewModelProvider is used to retrieve the CalculatorViewModel instance
        // This ViewModel is responsible for managing UI-related data in a lifecycle-conscious way
        val calculatorViewModel = ViewModelProvider(this)[CalculatorViewModel::class.java]

        // Enable edge-to-edge layout for better screen utilization
        enableEdgeToEdge()

        // Set the content view for the activity using Jetpack Compose
        setContent {
            CalculatorTheme {  // Apply the custom theme for the app
                Scaffold(
                    modifier = Modifier.fillMaxSize()  // Fill the entire screen size
                ) { innerPadding ->
                    // Passing the inner padding to the Calculator composable to ensure
                    // proper padding is applied around the calculator UI
                    Calculator(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = calculatorViewModel  // Pass the ViewModel to the Calculator composable
                    )
                }
            }
        }
    }
}