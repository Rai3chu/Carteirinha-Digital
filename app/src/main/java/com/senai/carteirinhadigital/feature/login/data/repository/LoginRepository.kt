package com.senaisp.carteirinhadigital.feature.login.data.repository

import com.senai.carteirinhadigital.feature.login.domain.model.UsuarioLogado

interface LoginRepository {
    suspend fun login( usuario:String, senha:String): Result<UsuarioLogado>
}