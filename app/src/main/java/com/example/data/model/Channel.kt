package com.example.data.model

enum class ChannelCategory(val displayName: String) {
    TODOS("Todos"),
    NACIONAL("Nacional"),
    NOTICIAS("Noticias"),
    ENTRETENIMIENTO("Entretenimiento"),
    CULTURAL("Cultural y Educativo"),
    INFANTIL("Infantil y Familiar"),
    INSTITUCIONAL("Institucional")
}

data class Channel(
    val id: String,
    val name: String,
    val channelNumber: String,
    val dial: String,
    val category: ChannelCategory,
    val streamUrl: String,
    val backupStreamUrl: String = "",
    val webEmbedUrl: String = "",
    val logoText: String,
    val brandColor: Long,
    val description: String,
    val isHd: Boolean = true,
    val isVerified: Boolean = true
)
