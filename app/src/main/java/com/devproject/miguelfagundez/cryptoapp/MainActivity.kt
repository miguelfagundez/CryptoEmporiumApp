package com.devproject.miguelfagundez.cryptoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Connecting with Firebase (Authentication module)
    private val authentication : FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewListeners()

    }

    private fun setupViewListeners() {

        // Button: Start
        btnStart.setOnClickListener {view ->

            val userName = etUsername.text.toString()
            // Checking userName has some values
            if (userName.isNullOrEmpty()||userName.isNullOrBlank()){
                ShowMessage(view, "Username cannot be empty or null")
            }else {
                authentication.signInAnonymously()
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            startHomeActivity(userName)
                        } else {
                            ShowMessage(view, "Error connecting with server")
                        }
                    }
            }
        }
    }

    // Connecting with homeActivity
    private fun startHomeActivity(userName: String) {
        Toast("Successfully connected!")
        val intent = Intent(this@MainActivity, HomeActivity::class.java)
        intent.putExtra(Constants.USERNAME_KEY, userName)

        startActivity(intent)
        finish()
    }


}
