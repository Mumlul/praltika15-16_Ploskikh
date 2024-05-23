package com.example.praktikatest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class enter : AppCompatActivity() {
    private lateinit var Enter: Button
    lateinit var email: EditText
    lateinit var pas: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter)
        Enter=findViewById(R.id.enter)
        email=findViewById(R.id.email)
        pas=findViewById(R.id.pas)
    }

    fun en(view: View) {
        if(email.text.toString()=="Саша"&&pas.text.toString()=="12345"){
            val intent= Intent(this,test::class.java)
            startActivity(intent)
        }
        else{
            val toast = Toast.makeText(this, "no", Toast.LENGTH_SHORT )
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            toast.show()
        }
    }
}