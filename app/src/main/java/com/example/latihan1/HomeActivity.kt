package com.example.latihan1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // Set tampilan pertama kali masuk beranda adalah HomeFragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
            bottomNav.selectedItemId = R.id.nav_home // biar tab "Beranda" ikut nyala
        }

        // Mengatur aksi ketika menu bawah diklik
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
                    true
                }
                R.id.nav_calculator -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, CalculatorFragment()).commit()
                    true
                }
                R.id.nav_profile -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ProfileFragment()).commit()
                    true
                }
                R.id.nav_web -> {
                    // Buka link web pakai browser HP, bukan ganti fragment
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/yg_treasure_official/"))
                    startActivity(intent)
                    false // biar tab yang nyala tetap tab sebelumnya
                }
                else -> false
            }
        }
    }
}