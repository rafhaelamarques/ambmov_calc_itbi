package com.cotemig.calculadoraitba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CalculadoraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)

        var btnCalc = findViewById<Button>(R.id.btnCalc)
        var codCidade = findViewById<EditText>(R.id.codigoInput)
        var valor = findViewById<EditText>(R.id.valorInput)

        btnCalc.setOnClickListener() {
            calculaItbi(codCidade.text.toString().toInt(), valor.text.toString().toDouble())
        }


    }

    fun calculaItbi(codigo: Int, valor: Double) {
        var resultado = 0.0;
        var exception = ""

        if (codigo == null || valor == null) {
            resultado = 0.0
        } else {
            //Belo Horizonte
            if (codigo == 1) {
                resultado = (valor * 0.03)
            }
            //Contagem
            else if (codigo == 2) {
                resultado = (valor * 0.0275)
            }
            //Nova Lima
            else if (codigo == 3) {
                resultado = (valor * 0.02)
            }
            //Exception
            else {
                resultado = 0.0
                exception = "Não foi possível calcular o ITBI para o código de cidade informado."
            }
        }

        var intent = Intent(this, ResultadoActivity::class.java)
        intent.putExtra("itbi", resultado)
        intent.putExtra("exception", exception)
        startActivity(intent)
    }
}