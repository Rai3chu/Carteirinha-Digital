package com.senai.carteirinhadigital.feature.login.domain.model

import kotlin.text.trim
import kotlin.text.uppercase

enum class PerfilAcesso {
    ALUNO,
    PROFESSOR;

    companion object {

        fun fromApi(
            value: String
        ): PerfilAcesso {

            return when (
                value.trim().uppercase()
            ) {

                "ALUNO" ->
                    ALUNO

                "PROFESSOR" ->
                    PROFESSOR

                else ->
                    throw kotlin.IllegalArgumentException(
                        "Perfil de acesso inválido: $value"
                    )
            }
        }
    }
}