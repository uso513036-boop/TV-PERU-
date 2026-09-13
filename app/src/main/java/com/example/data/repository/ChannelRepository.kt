package com.example.data.repository

import com.example.data.model.Channel
import com.example.data.model.ChannelCategory

object ChannelRepository {

    val channels = listOf(
        Channel(
            id = "tvperu",
            name = "TV Perú",
            channelNumber = "07.1",
            dial = "VHF Canal 7 / TDT 7.1 HD",
            category = ChannelCategory.NACIONAL,
            streamUrl = "http://190.93.224.42/TV-PERU/index.m3u8",
            backupStreamUrl = "http://bantel-cdn1.iptvperu.tv:1935/btnscrtn/tvperu.stream/playlist.m3u8",
            logoText = "TVP",
            brandColor = 0xFFD32F2F,
            description = "Canal del Estado Peruano (IRTP). Emisora oficial con cobertura nacional, identidad, cultura e información para todo el país.",
            isHd = true
        ),
        Channel(
            id = "america",
            name = "América TV",
            channelNumber = "04.1",
            dial = "VHF Canal 4 / TDT 4.1 HD",
            category = ChannelCategory.ENTRETENIMIENTO,
            streamUrl = "http://bantel-cdn1.iptvperu.tv:1935/btnscrtn/america.stream/playlist.m3u8",
            backupStreamUrl = "http://190.93.224.42/AMERICA-TV/index.m3u8",
            logoText = "AMÉ",
            brandColor = 0xFFE65100,
            description = "Líder de la televisión peruana con las mejores telenovelas, ficción nacional como Al Fondo Hay Sitio y noticieros líderes.",
            isHd = true
        ),
        Channel(
            id = "latina",
            name = "Latina Televisión",
            channelNumber = "02.1",
            dial = "VHF Canal 2 / TDT 2.1 HD",
            category = ChannelCategory.ENTRETENIMIENTO,
            streamUrl = "http://190.93.224.42/LATINA/index.m3u8",
            backupStreamUrl = "https://redirector.rudo.video/hls-video/567ffde3fa319fadf3419efda25619456231dfea/latina/latina.smil/playlist.m3u8",
            logoText = "LAT",
            brandColor = 0xFF0288D1,
            description = "Canal de entretenimiento, gastronomía con El Gran Chef Famosos, series familiares, Latina Noticias y grandes eventos.",
            isHd = true
        ),
        Channel(
            id = "panamericana",
            name = "Panamericana TV",
            channelNumber = "05.1",
            dial = "VHF Canal 5 / TDT 5.1 HD",
            category = ChannelCategory.NACIONAL,
            streamUrl = "http://190.93.224.42/PANAMERICANA/index.m3u8",
            backupStreamUrl = "http://bantel-cdn1.iptvperu.tv:1935/btnscrtn/panamericana.stream/playlist.m3u8",
            logoText = "PAN",
            brandColor = 0xFF1976D2,
            description = "La televisión histórica del Perú con el noticiero 24 Horas, Buenos Días Perú, periodismo y programas de variedades.",
            isHd = true
        ),
        Channel(
            id = "atv",
            name = "ATV",
            channelNumber = "09.1",
            dial = "VHF Canal 9 / TDT 9.1 HD",
            category = ChannelCategory.ENTRETENIMIENTO,
            streamUrl = "http://190.93.224.42/ATV/index.m3u8",
            backupStreamUrl = "https://d19e55ehz2il4i.cloudfront.net/ts:abr.m3u8",
            logoText = "ATV",
            brandColor = 0xFF7B1FA2,
            description = "Andina de Televisión, hogar de Magaly TV La Firme, Andrea, ATV Noticias y transmisiones de alta sintonía.",
            isHd = true
        ),
        Channel(
            id = "willax",
            name = "Willax TV",
            channelNumber = "31.1",
            dial = "UHF Canal 31 / TDT 1.1 HD",
            category = ChannelCategory.NOTICIAS,
            streamUrl = "http://bantel-cdn1.iptvperu.tv:1935/btnscrtn/willax.stream/playlist.m3u8",
            backupStreamUrl = "http://190.93.224.42/WILLAX/index.m3u8",
            logoText = "WLX",
            brandColor = 0xFFC2185B,
            description = "Canal de noticias, investigación y debate político con programas de actualidad, análisis, Amor y Fuego y Beto A Saber.",
            isHd = true
        ),
        Channel(
            id = "tvperunoticias",
            name = "TV Perú Noticias",
            channelNumber = "07.3",
            dial = "TDT 7.3 HD",
            category = ChannelCategory.NOTICIAS,
            streamUrl = "http://190.93.224.42/TV-PERU-NOTICIAS/index.m3u8",
            backupStreamUrl = "http://bantel-cdn1.iptvperu.tv:1935/btnscrtn/tvperunoticias.stream/playlist.m3u8",
            logoText = "7.3",
            brandColor = 0xFFB71C1C,
            description = "Canal informativo 24/7 con transmisiones oficiales del Estado, enlaces en vivo desde todas las regiones del Perú y el mundo.",
            isHd = true
        ),
        Channel(
            id = "canalipe",
            name = "Canal IPe",
            channelNumber = "07.4",
            dial = "TDT 7.4 HD",
            category = ChannelCategory.INFANTIL,
            streamUrl = "http://190.93.224.42/IPE/index.m3u8",
            backupStreamUrl = "http://bantel-cdn1.iptvperu.tv:1935/btnscrtn/ipemovil/playlist.m3u8",
            logoText = "IPE",
            brandColor = 0xFF00897B,
            description = "Franja cultural, educativa e infantil del IRTP. Producción peruana para niñas, niños y jóvenes creadores.",
            isHd = true
        ),
        Channel(
            id = "exitosa",
            name = "Exitosa TV",
            channelNumber = "06.1",
            dial = "TDT 6.1 HD / Radio TV",
            category = ChannelCategory.NOTICIAS,
            streamUrl = "http://190.93.224.42/EXITOSA/index.m3u8",
            backupStreamUrl = "https://luna-4-video.mediaserver.digital/exitosatv_233b-4b49-a726-5a451262/index.m3u8",
            logoText = "EXI",
            brandColor = 0xFFE53935,
            description = "La voz de los que no tienen voz. Transmisión simultánea multiplataforma con debate popular, deportes y cobertura nacional.",
            isHd = true
        ),
        Channel(
            id = "rpptv",
            name = "RPP TV",
            channelNumber = "10.1",
            dial = "Movistar 10 / Claro 10 HD",
            category = ChannelCategory.NOTICIAS,
            streamUrl = "http://bantel-cdn1.iptvperu.tv:1935/btnscrtn/RPP/playlist.m3u8",
            backupStreamUrl = "http://190.93.224.42/RPP/index.m3u8",
            logoText = "RPP",
            brandColor = 0xFFF57F17,
            description = "Radio Programas del Perú en televisión: El noticiero radial más sintonizado llevado a la pantalla con análisis e inmediatez.",
            isHd = true
        ),
        Channel(
            id = "congresotv",
            name = "Congreso TV",
            channelNumber = "07.2",
            dial = "TDT 7.2 HD",
            category = ChannelCategory.CULTURAL,
            streamUrl = "http://bantel-cdn1.iptvperu.tv:1935/btnscrtn/canalelcongreso.stream/playlist.m3u8",
            backupStreamUrl = "http://190.93.224.42/TV-PERU/index.m3u8",
            logoText = "CON",
            brandColor = 0xFF37474F,
            description = "Transmisión institucional del Pleno del Congreso de la República, comisiones parlamentarias y debate legislativo.",
            isHd = true
        ),
        Channel(
            id = "vivatv",
            name = "Viva TV",
            channelNumber = "11.1",
            dial = "VHF Canal 11 / TDT 11.1 HD",
            category = ChannelCategory.ENTRETENIMIENTO,
            streamUrl = "http://bantel-cdn1.iptvperu.tv:1935/btnscrtn/vivatv.stream/playlist.m3u8",
            backupStreamUrl = "https://live.obslivestream.com/vivatv/index.m3u8",
            logoText = "VIV",
            brandColor = 0xFF6A1B9A,
            description = "Canal 11 de Lima: espacios musicales peruanos, cumbia, folclore, gastronomía y entretenimiento para la familia.",
            isHd = true
        )
    )

    fun getChannelById(id: String): Channel? {
        return channels.firstOrNull { it.id == id }
    }
}
