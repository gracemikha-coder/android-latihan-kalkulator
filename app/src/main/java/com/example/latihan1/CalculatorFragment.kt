package com.example.latihan1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class CalculatorFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Menghubungkan fragment dengan layout kalkulator yang sudah ada
        val view = inflater.inflate(R.layout.fragment_calculator, container, false)

        val result: TextView = view.findViewById(R.id.hasil)
        val input1: EditText = view.findViewById(R.id.input1)
        val input2: EditText = view.findViewById(R.id.input2)

        val tambah: Button = view.findViewById(R.id.btntambah)
        val kurang: Button = view.findViewById(R.id.btnkurang)
        val kali: Button = view.findViewById(R.id.btnkali)
        val bagi: Button = view.findViewById(R.id.btnbagi)

        tambah.setOnClickListener {
            val num1 = input1.text.toString().toIntOrNull() ?: 0
            val num2 = input2.text.toString().toIntOrNull() ?: 0
            result.text = (num1 + num2).toString()
        }

        kurang.setOnClickListener {
            val num1 = input1.text.toString().toIntOrNull() ?: 0
            val num2 = input2.text.toString().toIntOrNull() ?: 0
            result.text = (num1 - num2).toString()
        }

        kali.setOnClickListener {
            val num1 = input1.text.toString().toIntOrNull() ?: 0
            val num2 = input2.text.toString().toIntOrNull() ?: 0
            result.text = (num1 * num2).toString()
        }

        bagi.setOnClickListener {
            val num1 = input1.text.toString().toIntOrNull() ?: 0
            val num2 = input2.text.toString().toIntOrNull() ?: 0
            if (num2 != 0) {
                result.text = (num1 / num2).toString()
            } else {
                result.text = "Tidak bisa dibagi 0"
            }
        }

        return view
    }
}