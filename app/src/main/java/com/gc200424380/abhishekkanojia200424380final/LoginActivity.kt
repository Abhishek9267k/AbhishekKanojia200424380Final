package com.gc200424380.abhishekkanojia200424380final

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.gc200424380.abhishekkanojia200424380final.databinding.ActivityLoginBinding
import com.gc200424380.abhishekkanojia200424380final.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        auth = FirebaseAuth.getInstance()
        setContentView(binding.root)

        binding.eLoginButton.setOnClickListener {
            if(binding.loginEmailField.text.toString().isNotEmpty() &&
                binding.loginPasswordField.text.toString().isNotEmpty()){
                val email = binding.loginEmailField.text.toString()
                val password = binding.loginPasswordField.text.toString()

                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success")
                            val user = auth.currentUser?.email.toString()
                            val intent = Intent(this,StartActivity::class.java)

                            startActivity(intent)
                             }
                        else {
                            // If sign in fails, display a message to the user.
                            // Since we are already in the Login activity I didn't redirect it here.
                            Log.w(TAG, "signInWithEmail:failure", task.exception)
                            Toast.makeText(baseContext, "Authentication failed. Your email or password is incorrect.",
                                Toast.LENGTH_SHORT).show()
                        }
                    }
            }
        }

        binding.registerButton.setOnClickListener {

        }
    }
}