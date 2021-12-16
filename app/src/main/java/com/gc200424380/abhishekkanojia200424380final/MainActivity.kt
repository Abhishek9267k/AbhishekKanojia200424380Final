package com.gc200424380.abhishekkanojia200424380final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gc200424380.abhishekkanojia200424380final.databinding.ActivityMainBinding
import com.gc200424380.abhishekkanojia200424380final.databinding.ActivityMainBinding.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            var loginActivity = Intent(this, LoginActivity::class.java)
            startActivity(loginActivity)
        }

        binding.gLoginButton.setOnClickListener {

        }
    }
}