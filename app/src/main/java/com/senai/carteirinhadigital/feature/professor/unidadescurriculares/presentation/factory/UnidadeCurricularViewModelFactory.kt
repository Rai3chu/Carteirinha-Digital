package com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.presentation.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
// Importações corretas do professor
import com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.domain.repository.UnidadeCurricularRepository
import com.senaisp.carteirinhadigital.feature.professor.unidadescurriculares.presentation.UnidadeCurricularViewModel

class UnidadeCurricularViewModelFactory(
    private val repository: UnidadeCurricularRepository
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UnidadeCurricularViewModel::class.java)) {
            return UnidadeCurricularViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}