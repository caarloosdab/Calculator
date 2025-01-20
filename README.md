# Overview

The goal of this project is to build a simple Calculator app using kotlin. this calculator should accept user input and perform basic arithmetic operations

This app will display a basic calculator application with support for arithmetic operations and user-friendly input handling.


The purpose of this software is to learn the basics of Kotlin language using Variables (mutable and immutable), Expressions, Conditionals,
Loops, Functions, clases and the when keyword 


[Software Demo Video](https://ooo.mmhmm.app/watch/y_5ejnwdnAKpG7iCtLbvnc)

# Development Environment

This app was written using Android studio

I used Kotlin language which is a a modern, statically-typed language that runs on the Java Virtual Machine (JVM), and it's the official language for Android app development  
and these are the libraries I used:

AndroidX Libraries:
androidx.activity.ComponentActivity: Used for the base activity class for your app. It's part of Android's Activity framework.
androidx.activity.compose.setContent: A function that allows you to set a composable as the content view for your activity, enabling Jetpack Compose.
androidx.lifecycle.LiveData: Part of Android's Lifecycle library, used for holding and observing data that should be managed based on the app’s lifecycle.
androidx.lifecycle.MutableLiveData: A subclass of LiveData that allows modification of the data held.
androidx.lifecycle.ViewModel: The base class for managing UI-related data in a lifecycle-conscious way.
androidx.compose.foundation.layout.*: Contains layout-related functions for arranging UI elements. For example:
Box: A simple container composable.
Column: A vertical arrangement of items.
Spacer: Adds space between items.
fillMaxSize: Modifier to make an element fill the maximum size.
padding: Adds padding around an element.
androidx.compose.foundation.lazy.grid.*: Used to create a grid layout, in this case for the calculator buttons:
GridCells: Defines how many columns the grid should have.
LazyVerticalGrid: Used to create a vertically scrolling grid.
items: Displays items in the grid.
androidx.compose.material3.*: Material Design components for building the UI:
Button: A basic clickable button.
FloatingActionButton: A floating button used for the calculator's number and operator buttons.
Text: A composable used for displaying text.
Scaffold: A layout structure for setting up basic UI elements like app bars and body content.


# Useful Websites


- [Kotlin – Calculator Program](https://kotlinandroid.org/kotlin/kotlin-calculator-program/)
- [Build a Simple Calculator App](https://www.soubhagyajit.com/blogs/Build-a-Simple-Calculator-App-with-Simple-UI-in-Android-Studio-Using-Kotlin)
- [Calculator App Android Studio Kotlin Tutorial](https://www.youtube.com/watch?v=2hSHgungOKI&t=5s)

  
# Future Work

{Make a list of things that you need to fix, improve, and add in the future.}

- Add validation for button input to prevent invalid calculations, such as multiple consecutive operators or an equation that starts with an operator.
- Implement a more optimized way to handle LiveData updates, possibly using MediatorLiveData to merge different states if needed.
- Animate the buttons, for example, when pressed, with a ripple effect, or animate the result text changing.
- Instead of a silent catch, log the error or display an error message on the UI.
