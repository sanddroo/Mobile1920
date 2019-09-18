package com.github.findingyou

import android.app.Activity
import android.graphics.Color
import android.graphics.drawable.Icon
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.github.findingyou.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val OnID =android.R.drawable.btn_star_big_on
    private val OffID=android.R.drawable.btn_star_big_off
    private lateinit var ViewSelect: View
    private var IDSelect = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val box: List<Int> = listOf(
            binding.textBox1.id, binding.textBox2.id, binding.textBox3.id,
            binding.textBox4.id, binding.textBox5.id, binding.textBox6.id,
            binding.textBox7.id, binding.textBox8.id, binding.textBox9.id
        )
        IDSelect = box[Random.nextInt(0,9)]
        setListeners()
    }
    private fun Logic(view: View){
        if(view.id == IDSelect){
            setBackground(view,OnID)
            ViewSelect = view
            Toast.makeText(this, "You Win!!!!!! Press the Star to Restart", Toast.LENGTH_LONG).show()
            ViewSelect.setOnClickListener {
                reset()
            }
        }else setBackground(view,OffID)
    }

    private fun setBackground(view: View, buttonIcon: Int){
        view.setBackgroundResource(buttonIcon)
    }

    private fun reset(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val box: List<Int> = listOf(
            binding.textBox1.id, binding.textBox2.id, binding.textBox3.id,
            binding.textBox4.id, binding.textBox5.id, binding.textBox6.id,
            binding.textBox7.id, binding.textBox8.id, binding.textBox9.id
        )
        IDSelect = box[Random.nextInt(0,9)]
        val textBox1 = findViewById<TextView>(R.id.text_box1)
        val textBox2 = findViewById<TextView>(R.id.text_box2)
        val textBox3 = findViewById<TextView>(R.id.text_box3)
        val textBox4 = findViewById<TextView>(R.id.text_box4)
        val textBox5 = findViewById<TextView>(R.id.text_box5)
        val textBox6 = findViewById<TextView>(R.id.text_box6)
        val textBox7 = findViewById<TextView>(R.id.text_box7)
        val textBox8 = findViewById<TextView>(R.id.text_box8)
        val textBox9 = findViewById<TextView>(R.id.text_box9)

        val clickableViews: List<View> =
            listOf(textBox1, textBox2, textBox3, textBox4,
                textBox5, textBox6, textBox7, textBox8, textBox9)

        for (item in clickableViews){
            item.setOnClickListener {
                Logic(it)
            }
            item.setBackgroundColor(Color.WHITE)
        }
    }

    private fun setListeners(){
        val textBox1 = findViewById<TextView>(R.id.text_box1)
        val textBox2 = findViewById<TextView>(R.id.text_box2)
        val textBox3 = findViewById<TextView>(R.id.text_box3)
        val textBox4 = findViewById<TextView>(R.id.text_box4)
        val textBox5 = findViewById<TextView>(R.id.text_box5)
        val textBox6 = findViewById<TextView>(R.id.text_box6)
        val textBox7 = findViewById<TextView>(R.id.text_box7)
        val textBox8 = findViewById<TextView>(R.id.text_box8)
        val textBox9 = findViewById<TextView>(R.id.text_box9)

        val clickableViews: List<View> =
            listOf(textBox1, textBox2, textBox3, textBox4,
                textBox5, textBox6, textBox7, textBox8, textBox9)

        for (item in clickableViews) {
            item.setOnClickListener {
                Logic(it)
            }
        }
    }
}
