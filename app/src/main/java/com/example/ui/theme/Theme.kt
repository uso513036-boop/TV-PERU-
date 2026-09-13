package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme =
  darkColorScheme(
    primary = PeruRedPrimary,
    onPrimary = androidx.compose.ui.graphics.Color.White,
    secondary = PeruGold,
    onSecondary = androidx.compose.ui.graphics.Color.Black,
    tertiary = LiveGreen,
    background = TvDarkBackground,
    onBackground = TvTextPrimary,
    surface = TvDarkSurface,
    onSurface = TvTextPrimary,
    surfaceVariant = TvDarkSurfaceVariant,
    onSurfaceVariant = TvTextSecondary,
    outline = TvDarkOutline
  )

private val LightColorScheme =
  lightColorScheme(
    primary = PeruRedPrimary,
    onPrimary = androidx.compose.ui.graphics.Color.White,
    secondary = PeruGold,
    onSecondary = androidx.compose.ui.graphics.Color.Black,
    tertiary = LiveGreen,
    background = androidx.compose.ui.graphics.Color(0xFFF8F9FA),
    onBackground = androidx.compose.ui.graphics.Color(0xFF1A1A1E),
    surface = androidx.compose.ui.graphics.Color.White,
    onSurface = androidx.compose.ui.graphics.Color(0xFF1A1A1E),
    surfaceVariant = androidx.compose.ui.graphics.Color(0xFFEDEFEF),
    onSurfaceVariant = androidx.compose.ui.graphics.Color(0xFF424242),
    outline = androidx.compose.ui.graphics.Color(0xFFD1D5DB)
  )

@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = true,
  dynamicColor: Boolean = false,
  content: @Composable () -> Unit,
) {
  val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

  MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}
