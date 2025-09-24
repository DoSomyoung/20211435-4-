package com.example.selfproject4_4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var switchStart: Switch
    private lateinit var textView2: TextView
    private lateinit var rGroup1: RadioGroup
    private lateinit var imgPet: ImageView
    private lateinit var buttonEnd: Button
    private lateinit var buttonReset: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchStart = findViewById(R.id.switch_start)
        textView2 = findViewById(R.id.textView2)
        rGroup1 = findViewById(R.id.rGroup1)
        imgPet = findViewById(R.id.imgPet)
        buttonEnd = findViewById(R.id.button_end)
        buttonReset = findViewById(R.id.button_reset)

        resetUI()

        switchStart.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                textView2.visibility = View.VISIBLE
                rGroup1.visibility = View.VISIBLE
            } else {
                resetUI()
            }
        }

        rGroup1.setOnCheckedChangeListener { _, checkedId ->
            imgPet.visibility = View.VISIBLE
            buttonEnd.visibility = View.VISIBLE
            buttonReset.visibility = View.VISIBLE

            when (checkedId) {
                R.id.rdoDog -> {
                    imgPet.setImageResource(R.drawable.oreo)
                }
                R.id.rdoCat -> {
                    imgPet.setImageResource(R.drawable.pie)
                }
                R.id.rdoRabbit -> {
                    imgPet.setImageResource(R.drawable.q10)
                }
            }
        }

        buttonEnd.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("앱 종료")
                .setMessage("정말로 앱을 종료하시겠습니까?")
                .setPositiveButton("예") { _, _ -> finish() }
                .setNegativeButton("아니오", null)
                .show()
        }

        buttonReset.setOnClickListener {
            switchStart.isChecked = false
            resetUI()
        }
    }

    private fun resetUI() {
        textView2.visibility = View.INVISIBLE
        rGroup1.visibility = View.INVISIBLE
        imgPet.visibility = View.INVISIBLE
        buttonEnd.visibility = View.INVISIBLE
        buttonReset.visibility = View.INVISIBLE
        rGroup1.clearCheck()
    }
}