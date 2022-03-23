package com.cotemig.calculadoraitba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.NumberFormat
import java.util.*

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        var itbi = intent.getDoubleExtra("itbi", 0.0)
        var exception = intent.getStringExtra("exception")

        var itbiValue = findViewById<TextView>(R.id.resultadoOutput)
        var exceptionValue = findViewById<TextView>(R.id.exceptionOutput)

        var ft = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-br"))

        itbiValue.text = ft.format(itbi);
        exceptionValue.text = exception;
    }
}