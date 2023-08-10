package com.uc.languagetranslator

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.uc.languagetranslator.R

import org.json.JSONException
import org.json.JSONObject

class RegisterActivity : AppCompatActivity() {

    private var BASE_URL = ""

    var sharedpreferences: SharedPreferences? = null

    private fun setPref(con: Context, Key :String, Value :String ){
        sharedpreferences = con.getSharedPreferences("Voting", MODE_PRIVATE)
        var edit = sharedpreferences?.edit()
        edit?.putString(Key, Value)
        edit?.commit()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val  btnRegister: Button = findViewById(R.id.btnRegister)
        btnRegister.setOnClickListener {
            val intent = Intent(applicationContext,LoginActivity::class.java).apply {
            }
            startActivity(intent)
        }

        val  btnLogin: TextView = findViewById(R.id.btnLoginVoter)
        btnLogin.setOnClickListener {
            val intent = Intent(applicationContext,LoginActivity::class.java).apply {
            }
            startActivity(intent)
        }

    }
}