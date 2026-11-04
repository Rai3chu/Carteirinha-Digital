package com.senai.carteirinhadigital.feature.turmas.data.repository

import com.senai.carteirinhadigital.feature.turmas.data.remote.TurmaApi
import com.senai.carteirinhadigital.feature.turmas.domain.model.Turma
import com.senai.carteirinhadigital.feature.turmas.domain.repository.TurmaRepository
import retrofit2.HttpException
import java.io.IOException
import kotlin.recoverCatching
import kotlin.runCatching

class ApiTurmaRepositoryImpl(
    private val api: TurmaApi
) : TurmaRepository {

    override suspend fun listar(): Result<List<Turma>> {
        return runCatching {
            api.listar().map {
                it.toDomain()
            }
        }.recoverCatching { throwable ->
            throw when (throwable) {
                is HttpException -> {
                    if (throwable.code() == 401) {
                        kotlin.IllegalStateException("Sua sessão expirou. Faça login novamente.")
                    } else {
                        kotlin.IllegalStateException("Erro ao carregar turmas (${throwable.code()}).")
                    }
                }
                is IOException ->
                    kotlin.IllegalStateException("Não foi possível conectar à API.")
                else ->
                    kotlin.IllegalStateException(throwable.message ?: "Erro ao carregar turmas.")
            }
        }
    }
}
