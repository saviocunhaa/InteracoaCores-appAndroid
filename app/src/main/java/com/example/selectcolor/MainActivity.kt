package com.example.selectcolor

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.InputBinding
import com.example.selectcolor.databinding.ActivityMainBinding
import java.lang.IllegalArgumentException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var cor = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.red.setOnClickListener{
            cor = "#FF0000"
            binding.inputHexColor.setText(cor)
        }
        binding.blue.setOnClickListener{
            cor = "#3F51B5"
            binding.inputHexColor.setText(cor)
        }
        binding.yellow.setOnClickListener {
            cor = "#fff344"
            binding.inputHexColor.setText(cor)
        }
        binding.pink.setOnClickListener {
            cor = "#FF3278"
            binding.inputHexColor.setText(cor)
        }
        binding.green.setOnClickListener {
            cor = "#4CAF50"
            binding.inputHexColor.setText(cor)
        }



        binding.inputHexColor.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val text = s.toString()
                if (text.matches("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$".toRegex())) {
                    try {
                        val color = Color.parseColor(text)
                        binding.someView.setBackgroundColor(color)
                        binding.textViewStatus.setText("")
                    } catch (_: IllegalArgumentException){
                        binding.textViewStatus.setText("COR INVALIDA")
                    }
                } else if (text.isNotEmpty()) {
                    binding.textViewStatus.setText("COR INVÁLIDA")
                } else {
                    binding.textViewStatus.setText("") // Limpar mensagem de erro se o campo estiver vazio
                }
            }
        })

    }
}