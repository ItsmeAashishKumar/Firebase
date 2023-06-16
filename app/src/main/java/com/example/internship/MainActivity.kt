package com.example.internship

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name=findViewById<TextInputEditText>(R.id.editName)
        val email=findViewById<TextInputEditText>(R.id.editEmail)
        val password=findViewById<TextInputEditText>(R.id.editPassword)
        val id=findViewById<TextInputEditText>(R.id.editId)


        val btn=findViewById<Button>(R.id.signUp)

        btn.setOnClickListener{

            val eName=name.text.toString()
            val eEmail=email.text.toString()
            val ePassword=password.text.toString()
            val eId=id.text.toString()

            val user=User(eName,eEmail,ePassword,eId)
            database=FirebaseDatabase.getInstance().getReference("Users")
            database.child(eId).setValue(user).addOnSuccessListener {
                Toast.makeText(this,"User Registered",Toast.LENGTH_LONG).show()
            }

        }
    }
}