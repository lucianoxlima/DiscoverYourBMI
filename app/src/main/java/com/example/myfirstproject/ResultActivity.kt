package com.example.myfirstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)


        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        /* MENOR QUE 18,5	MAGREZA	0
        ENTRE 18,5 E 24,9	NORMAL	0
        ENTRE 25,0 E 29,9	SOBREPESO	I
        ENTRE 30,0 E 39,9	OBESIDADE	II
        MAIOR QUE 40,0	OBESIDADE GRAVE	III */



        val classificacao = if (result < 17f){
            "Severely Underweight"
        }else if (result in 17f..18.4f){
            "Underweight"
        }else if (result in 18.5f..24.9f){
            "Normal"
        }else if (result in 25f..29.9f){
            "Overweight"
        }else if (result in 30f..34.9f){
            "Obese Class I"
        }else if (result in 35f..39.9f){
            "Obese Class II"
        }else{
            "Obese Class III"
        }

        tvClassificacao.text = getString (R.string.message_classificacao, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}