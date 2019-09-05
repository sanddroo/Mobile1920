package com.github.sanddroo.randomgenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var resultText: TextView
    lateinit var rollButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultText = findViewById(R.id.result_text)
        rollButton = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
        rollDice()
        Toast.makeText(this,"Flipped", Toast.LENGTH_SHORT).show()}
    }

    private fun rollDice() {
        val randomInt = Random().nextInt(2)+1
        if(randomInt==1)
        {
            resultText.text="Head"
        }
        else {
            resultText.text="Tail"
        }
    }
}
