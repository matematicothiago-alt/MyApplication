package com.delivery.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputValor = findViewById<EditText>(R.id.inputValor)
        val inputKm = findViewById<EditText>(R.id.inputKm)
        val inputMin = findViewById<EditText>(R.id.inputMin)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)

        val txtValorMin = findViewById<TextView>(R.id.txtValorMin)
        val txtValorHora = findViewById<TextView>(R.id.txtValorHora)
        val txtValorKm = findViewById<TextView>(R.id.txtValorKm)
        val txtLucro = findViewById<TextView>(R.id.txtLucro)

        btnCalcular.setOnClickListener {
            val valor = inputValor.text.toString().toDoubleOrNull() ?: 0.0
            val km = inputKm.text.toString().toDoubleOrNull() ?: 0.0
            val min = inputMin.text.toString().toDoubleOrNull() ?: 0.0

            val valorMin = if (min > 0) valor / min else 0.0
            val valorHora = valorMin * 60
            val valorKm = if (km > 0) valor / km else 0.0
            val lucro = valor

            txtValorMin.text = String.format("%.2f", valorMin)
            txtValorHora.text = String.format("%.0f", valorHora)
            txtValorKm.text = String.format("%.2f", valorKm)
            txtLucro.text = String.format("%.2f", lucro)
        }
    }
}