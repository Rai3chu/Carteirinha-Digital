package com.senai.carteirinhadigital.core.desingsystem.theme

import androidx.compose.ui.graphics.Color

// Cores base (sem o amarelo)
val pretoPuro = Color(0xFF000000)
val branco = Color(0xFFFFFFFF)
val cinzaEscuroFundo = Color(0xFF121212)
val cinzaEscuroSuperficie = Color(0xFF1E1E1E)
val cinzaClaro = Color(0xFFF0F0F0)

// ==========================================
// PALETA MODO CLARO (LIGHT SCHEME)
// Fundo Branco, Botões Pretos, Textos Pretos
// ==========================================
val primaryLight = pretoPuro                  // Botões preenchidos a Preto
val onPrimaryLight = branco                   // Texto dentro dos botões a Branco
val primaryContainerLight = cinzaClaro
val onPrimaryContainerLight = pretoPuro
val secondaryLight = pretoPuro
val onSecondaryLight = branco
val secondaryContainerLight = cinzaClaro
val onSecondaryContainerLight = pretoPuro
val tertiaryLight = pretoPuro
val onTertiaryLight = branco
val tertiaryContainerLight = cinzaClaro
val onTertiaryContainerLight = pretoPuro
val errorLight = Color(0xFFBA1A1A)
val onErrorLight = Color(0xFFFFFFFF)
val errorContainerLight = Color(0xFFFFDAD6)
val onErrorContainerLight = Color(0xFF93000A)

val backgroundLight = branco                  // Fundo do ecrã a Branco
val surfaceLight = branco                     // Fundo dos cartões a Branco
val onBackgroundLight = pretoPuro             // Textos gerais a Preto
val onSurfaceLight = pretoPuro                // Textos dos cartões a Preto
val surfaceVariantLight = cinzaClaro
val onSurfaceVariantLight = pretoPuro
val outlineLight = Color(0xFF757575)
val outlineVariantLight = Color(0xFFBDBDBD)

val scrimLight = pretoPuro
val inverseSurfaceLight = pretoPuro
val inverseOnSurfaceLight = branco
val inversePrimaryLight = branco
val surfaceDimLight = branco
val surfaceBrightLight = branco
val surfaceContainerLowestLight = branco
val surfaceContainerLowLight = branco
val surfaceContainerLight = branco
val surfaceContainerHighLight = branco
val surfaceContainerHighestLight = branco

// ==========================================
// PALETA MODO ESCURO (DARK SCHEME)
// Fundo Escuro, Botões Brancos, Textos Brancos
// ==========================================
val primaryDark = branco                      // Botões preenchidos a Branco
val onPrimaryDark = pretoPuro                 // Texto dentro dos botões a Preto
val primaryContainerDark = cinzaEscuroSuperficie
val onPrimaryContainerDark = branco
val secondaryDark = branco
val onSecondaryDark = pretoPuro
val secondaryContainerDark = cinzaEscuroSuperficie
val onSecondaryContainerDark = branco
val tertiaryDark = branco
val onTertiaryDark = pretoPuro
val tertiaryContainerDark = cinzaEscuroSuperficie
val onTertiaryContainerDark = branco
val errorDark = Color(0xFFFFB4AB)
val onErrorDark = Color(0xFF690005)
val errorContainerDark = Color(0xFF93000A)
val onErrorContainerDark = Color(0xFFFFDAD6)

val backgroundDark = cinzaEscuroFundo         // Fundo do ecrã Escuro
val onBackgroundDark = branco                 // Textos gerais a Branco
val surfaceDark = cinzaEscuroSuperficie       // Fundo dos cartões Escuro
val onSurfaceDark = branco                    // Textos dos cartões a Branco
val surfaceVariantDark = Color(0xFF2C2C2C)
val onSurfaceVariantDark = branco
val outlineDark = Color(0xFFA0A0A0)
val outlineVariantDark = Color(0xFF424242)

val scrimDark = pretoPuro
val inverseSurfaceDark = branco
val inverseOnSurfaceDark = pretoPuro
val inversePrimaryDark = pretoPuro
val surfaceDimDark = cinzaEscuroFundo
val surfaceBrightDark = cinzaEscuroFundo
val surfaceContainerLowestDark = cinzaEscuroFundo
val surfaceContainerLowDark = cinzaEscuroFundo
val surfaceContainerDark = cinzaEscuroFundo
val surfaceContainerHighDark = cinzaEscuroFundo
val surfaceContainerHighestDark = cinzaEscuroFundo