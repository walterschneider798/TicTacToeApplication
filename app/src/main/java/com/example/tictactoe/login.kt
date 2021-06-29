package com.example.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login1.*

class login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login1)
        spielenbt.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java )
            startActivity(intent)
        }
    }
}