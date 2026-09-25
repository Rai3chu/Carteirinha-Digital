package com.senaisp.carteirinhadigital.feature.unidadecurriculares.domain.repository

import com.senai.carteirinhadigital.feature.unidadescurriculares.domain.model.UnidadeCurricular

interface UnidadeCurricularRepository {
    suspend fun listarUnidadesCurriculares(): Result<List<UnidadeCurricular>>
}