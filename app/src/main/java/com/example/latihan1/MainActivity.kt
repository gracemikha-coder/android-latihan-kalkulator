package com.example.latihan1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.latihan1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Data dummy untuk latihan
    private val DUMMY_USERNAME = "siswa"
    private val DUMMY_PASSWORD = "rpl2026"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            when {
                username.isEmpty() || password.isEmpty() -> {
                    Toast.makeText(this, "Username dan password wajib diisi!", Toast.LENGTH_SHORT).show()
                }
                username == DUMMY_USERNAME && password == DUMMY_PASSWORD -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else -> {
                    Toast.makeText(this, "Username atau Password Salah!!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}