package com.gc200424380.abhishekkanojia200424380final

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.gc200424380.abhishekkanojia200424380final.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = FirebaseAuth.getInstance()

        binding.registerButton.setOnClickListener {
            if(binding.registerEmailField.text.toString().isNotEmpty() &&
                binding.registerPasswordField.text.toString().isNotEmpty() &&
                binding.registerCPasswordField.text.toString().isNotEmpty()){
                val email = binding.registerEmailField.text.toString()
                val pass = binding.registerPasswordField.text.toString()
                val cpass = binding.registerCPasswordField.text.toString()

                // Store data to firebase
                if(pass.equals(cpass) == true){
                    auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success")
                            val user = auth.currentUser
                            val intent = Intent(this,StartActivity::class.java)

                            startActivity(intent)
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.exception)
                            Toast.makeText(baseContext, "Authentication failed.",
                                Toast.LENGTH_SHORT).show()
                            val intent = Intent(this,RegisterActivity::class.java)

                            startActivity(intent)                        }
                    }
                }else {
                    Toast.makeText(this, "The Password you re-entered doesn't match with the password you entered.", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "Email and Password required", Toast.LENGTH_LONG).show()
            }
        }
    }
}