package com.curso.android.app.practica.comparar.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.curso.android.app.practica.comparar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.comparar.observe(this) {
            binding.result.text = "${it.result}"
        }

        binding.compararButton.setOnClickListener {
            val texto1: String = binding.text1.text.toString()
            val texto2: String = binding.text2.text.toString()
            mainViewModel.compararTexts(texto1,texto2)
        }

    }
}
