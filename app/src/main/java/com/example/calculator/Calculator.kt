package com.example.calculator

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// List of buttons that will be displayed on the calculator
val buttonList = listOf(
    "C", "(", ")", "/",
    "7", "8", "9", "*",
    "4", "5", "6", "+",
    "1", "2", "3", "-",
    "AC", "0", ".", "="
)

@Composable
fun Calculator(modifier: Modifier = Modifier, viewModel: CalculatorViewModel) {

    // Observing LiveData from the ViewModel to get the current equation and result
    val equationText = viewModel.equationText.observeAsState()
    val resultText = viewModel.resultText.observeAsState()

    Box(modifier = modifier) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.End  // Align text to the right
        ) {
            // Display the equation text (current input or history)
            Text(
                text = equationText.value ?: "",  // If equationText is null, display an empty string
                style = TextStyle(
                    fontSize = 30.sp,
                    textAlign = TextAlign.End
                ),
                maxLines = 5,  // Allow up to 5 lines for the equation
                overflow = TextOverflow.Ellipsis  // Show ellipsis if the text overflows
            )

            Spacer(modifier = Modifier.weight(1f))  // Add flexible space between equation and result

            // Display the result of the equation
            Text(
                text = resultText.value ?: "",  // If resultText is null, display an empty string
                style = TextStyle(
                    fontSize = 60.sp,
                    textAlign = TextAlign.End
                ),
                maxLines = 2,  // Allow up to 2 lines for the result
            )

            Spacer(modifier = Modifier.height(10.dp))  // Add some space between the result and the buttons

            // Using LazyVerticalGrid to display the buttons dynamically
            LazyVerticalGrid(
                columns = GridCells.Fixed(count = 4),  // Display 4 columns of buttons
            ) {
                // Loop through the button list and display each button
                items(buttonList.size) { index ->
                    val button = buttonList[index]
                    CalculatorButton(btn = button, onClick = {
                        viewModel.onButtonClick(button)  // Handle button click
                    })
                }
            }
        }
    }
}

@Composable
fun CalculatorButton(btn: String, onClick: () -> Unit) {
    // Create a floating action button for each calculator button
    Box(modifier = Modifier.padding(10.dp)) {
        FloatingActionButton(
            onClick = onClick,
            modifier = Modifier.size(80.dp),  // Set the size of the button
            shape = CircleShape,  // Make the button circular
            contentColor = Color.White,  // Set the text color to white
            containerColor = getColor(btn)  // Set the button's background color based on the button label
        ) {
            // Display the button text in the center of the button
            Text(text = btn, fontSize = 23.sp, fontWeight = FontWeight.Bold)
        }
    }
}

// Function to determine the button color based on its label
fun getColor(btn: String): Color {
    return when (btn) {
        "C", "AC" -> Color(0xFFF44336)  // Red color for "C" and "AC"
        "(", ")" -> Color.Gray           // Gray color for parentheses
        "/", "*", "+", "-", "=" -> Color(0xFFFF9800)  // Orange color for operators
        else -> Color(0xFF00C8C9)        // Teal color for other buttons (numbers and decimal point)
    }
}