package com.gc200424380.abhishekkanojia200424380final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.gc200424380.abhishekkanojia200424380final.databinding.ActivityAddBinding
import com.gc200424380.abhishekkanojia200424380final.databinding.ActivityRegisterBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAddDest.setOnClickListener {
            if(binding.txtDestName.text.toString().isNotEmpty() &&
                binding.txtDestDesc.text.toString().isNotEmpty() &&
                binding.spRanking.selectedItemPosition > 0){

                val destination = Destination()
                destination.Name = binding.txtDestName.text.toString()
                destination.Desc = binding.txtDestDesc.text.toString()
                destination.Rank = binding.spRanking.selectedItem.toString().toInt()

                val db = FirebaseFirestore.getInstance().collection("Destinations")
                destination.id = db.document().id

                db.document(destination.id!!).set(destination)

            }else {
                Toast.makeText(this, "Destination name, description and ranking required", Toast.LENGTH_LONG).show()
            }
        }
    }
}