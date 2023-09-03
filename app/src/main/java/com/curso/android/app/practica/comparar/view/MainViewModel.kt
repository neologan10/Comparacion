package com.curso.android.app.practica.comparar.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.android.app.practica.comparar.model.Comparar
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    val comparar: LiveData<Comparar> get() = _comparar
    private var _comparar = MutableLiveData<Comparar>(Comparar("Esperando..."))

    fun compararTexts(tex1: String, tex2: String) {
        if (tex1.equals(tex2)){
            updateResult("Las frases son iguales")
        }else{
            updateResult("Las frases son distintas")
        }
    }

    private fun updateResult(resultado: String) {
        viewModelScope.launch {
            _comparar.value = Comparar(resultado)
        }
    }
}
