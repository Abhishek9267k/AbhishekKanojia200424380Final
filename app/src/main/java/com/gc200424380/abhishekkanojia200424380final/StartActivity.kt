package com.gc200424380.abhishekkanojia200424380final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gc200424380.abhishekkanojia200424380final.databinding.ActivityMainBinding
import com.gc200424380.abhishekkanojia200424380final.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddBucketListItem.setOnClickListener {
            var addBucketActivity = Intent(this, AddActivity::class.java)
            startActivity(addBucketActivity)
        }

        binding.btnBucketList.setOnClickListener {
            var viewBucketActivity = Intent(this, ViewActivity::class.java)
            startActivity(viewBucketActivity)
        }
    }
}