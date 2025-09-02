package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var usernameInput: EditText
    lateinit var passwordInput: EditText
    lateinit var login_btn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("LoginAppDebug", "onCreate called")

        // It's good practice to call enableEdgeToEdge earlier in onCreate
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        usernameInput = findViewById(R.id.username_input)
        passwordInput = findViewById(R.id.password_input)
        login_btn = findViewById(R.id.login_btn)

        if (::usernameInput.isInitialized) {
            Log.d("LoginAppDebug", "usernameInput initialized")
        } else {
            Log.e("LoginAppDebug", "usernameInput IS NULL")
        }

        if (::passwordInput.isInitialized) {
            Log.d("LoginAppDebug", "passwordInput initialized")
        } else {
            Log.e("LoginAppDebug", "passwordInput IS NULL")
        }

        if (::login_btn.isInitialized) {
            Log.d("LoginAppDebug", "login_btn initialized")
            login_btn.setOnClickListener {
                Log.d("LoginAppDebug", "Login button clicked!")
                val username = usernameInput.text.toString()
                val password = passwordInput.text.toString()
                Log.i("Login", "Username: $username, Password: $password")

                // **TODO: Add your actual login logic here**
                // For now, let's assume login is always successful
                if (username.isNotEmpty() && password.isNotEmpty()) { // Basic validation
                    Log.d("LoginAppDebug", "Login successful, navigating to DashboardActivity")

                    // Create an Intent to start DashboardActivity
                    val intent = Intent(this, DashboardActivity::class.java)
                    // You can also pass data to DashboardActivity if needed
                    // intent.putExtra("USERNAME_KEY", username)
                    startActivity(intent)

                    // Optional: Finish MainActivity so the user can't go back to it with the back button
                    // finish()
                } else {
                    Log.w("LoginAppDebug", "Login failed: Username or password empty")
                    // TODO: Show an error message to the user
                }
            }
        } else {
            Log.e("LoginAppDebug", "login_btn IS NULL - THIS IS LIKELY THE PROBLEM")
        }
    }
}
