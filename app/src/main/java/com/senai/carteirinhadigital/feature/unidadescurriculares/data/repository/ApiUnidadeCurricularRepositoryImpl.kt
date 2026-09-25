package com.senaisp.carteirinhadigital.feature.unidadecurriculares.data.repository

import com.senai.carteirinhadigital.feature.unidadescurriculares.domain.model.UnidadeCurricular
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.data.remote.service.UnidadeCurricularApi
import com.senaisp.carteirinhadigital.feature.unidadecurriculares.domain.repository.UnidadeCurricularRepository
import java.io.IOException
import retrofit2.HttpException

class ApiUnidadeCurricularRepositoryImpl(
    private val api: UnidadeCurricularApi
): UnidadeCurricularRepository {
    override suspend fun listarUnidadesCurriculares(): Result<List<UnidadeCurricular>> {
        return runCatching {
            api.listarUnidadesCurriculares().map {
                it.toDomain()
            }
        }.recoverCatching { throwable ->
            throw when(throwable){
                is HttpException ->{
                    if (throwable.code()==401){
                        IllegalStateException("Sua sessão expirou. Faça login novamente.")
                    }else{
                        IllegalStateException("Erro ao carregar unidades curriculares (${throwable.code()})")
                    }
                }
                is IOException ->
                    IllegalStateException("Não foi possível conectar à API.")
                else ->
                    IllegalStateException(throwable.message ?: "Erro ao carregar unidades curriculares")
            }

        }

    }

}
