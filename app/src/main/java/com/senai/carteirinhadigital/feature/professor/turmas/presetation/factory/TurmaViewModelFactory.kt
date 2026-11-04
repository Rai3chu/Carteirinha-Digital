package com.senai.carteirinhadigital.feature.turmas.presetation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.senai.carteirinhadigital.feature.turmas.domain.repository.TurmaRepository
import com.senai.carteirinhadigital.feature.turmas.presetation.TurmaViewModel
import kotlin.jvm.java

class TurmaViewModelFactory(
    private val repository: TurmaRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TurmaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TurmaViewModel(repository = repository) as T
        }
        throw kotlin.IllegalArgumentException("ViewModel desconhecido: ${modelClass.name}")
    }
}
