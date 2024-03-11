package com.example.heroesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.heroesapp.Mockdata.Mockdata
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var loginBtn:Button
    private lateinit var emailTxt:EditText
    private lateinit var  passwordTxt:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences = getSharedPreferences("myprefs", MODE_PRIVATE)
        val isLogged = sharedPreferences.getBoolean("isLogged", false)
        if(isLogged){
            val intent = Intent(this@MainActivity,HomePage::class.java)
            startActivity(intent)
            finish()
        }
        loginBtn = findViewById(R.id.enterBtn)
        emailTxt = findViewById(R.id.emailInp)
        passwordTxt = findViewById(R.id.passwordInp)

        loginBtn.setOnClickListener{
            val email = emailTxt.text.toString()
            val password = passwordTxt.text.toString()

            if(email.isEmpty() || password.isEmpty()){
                Log.i("INVALID", "invalid credentials")
                Snackbar.make(it, "El correo o contraseña están vacios", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val isValidUser = Mockdata.users.any {u -> u.email == email && u.password == password}

            if(!isValidUser){
                Snackbar.make(it, "El correo o la contraseña no son validos", Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLogged", true)
            editor.apply()
            val intent = Intent(this@MainActivity,HomePage::class.java)
            startActivity(intent)
            finish()
        }
    }
}