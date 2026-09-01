package com.example.latihan1

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.latihan1.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val SPLASH_DELAY: Long = 2000 // 2 detik

    override fun onCreate(savedInstanceState: Bundle?) { // dibetulkan: savedInstanceState
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Berpindah ke MainActivity (Login) setelah 2 detik
        Handler(Looper.getMainLooper()).postDelayed({ // dibetulkan: Looper (huruf L besar)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Agar user tidak bisa back ke Splash
        }, SPLASH_DELAY)
    }
}