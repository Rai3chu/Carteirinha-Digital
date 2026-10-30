package com.senai.carteirinhadigital.feature.turmas.data.remote

import com.senai.carteirinhadigital.feature.turmas.data.dto.TurmaDto
import retrofit2.http.GET

interface TurmaApi {

    @GET("professores/me/turmas")
    suspend fun listar(): List<TurmaDto>
}