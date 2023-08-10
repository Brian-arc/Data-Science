package com.uc.languagetranslator

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.uc.languagetranslator.MainActivity
import com.uc.languagetranslator.R

class LoginActivity : AppCompatActivity() {

    private var BASE_URL = ""
    var sharedpreferences: SharedPreferences? = null
    var userId: String? = null
    var userName: String? = null


    fun setPref(con: Context, Key :String, Value :String ){
        sharedpreferences = con.getSharedPreferences("Voting", MODE_PRIVATE)
        var edit = sharedpreferences?.edit()
        edit?.putString(Key, Value)
        edit?.commit()
    }

    fun getPref(con: Context, Key: String?): String? {
        sharedpreferences = con.getSharedPreferences("Voting", MODE_PRIVATE)
        var Value = ""
        if (sharedpreferences?.contains(Key) == true) {
            Value = sharedpreferences!!.getString(Key, "").toString()
        }
        return Value
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userId = getPref(this@LoginActivity, "Pref_User_ID")
        userName = getPref(this@LoginActivity, "Pref_Username")

        if(!userId.isNullOrEmpty()){
            val intent = Intent(applicationContext,MainActivity::class.java).apply {
            }
            startActivity(intent)
        }
        val  btnLogin: Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val intent = Intent(applicationContext,MainActivity::class.java).apply {
                putExtra("USER","")
            }
            startActivity(intent)
        }

        val  btnRegister: TextView = findViewById(R.id.btnNewVoter)
        btnRegister.setOnClickListener {
            val intent = Intent(applicationContext,RegisterActivity::class.java).apply {
            }
            startActivity(intent)
        }


    }
}