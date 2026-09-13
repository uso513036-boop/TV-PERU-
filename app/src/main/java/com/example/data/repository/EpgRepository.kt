package com.example.data.repository

import com.example.data.model.DayPattern
import com.example.data.model.Program
import com.example.data.model.ProgramGenre
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime

object EpgRepository {

    private val PERU_ZONE = ZoneId.of("America/Lima")

    fun getCurrentPeruTime(): ZonedDateTime {
        return try {
            ZonedDateTime.now(PERU_ZONE)
        } catch (e: Exception) {
            ZonedDateTime.now()
        }
    }

    val programs: List<Program> = listOf(
        // ==========================================
        // AMÉRICA TELEVISIÓN (Canal 4) - Lunes a Viernes
        // ==========================================
        Program("am_01", "america", "La Voz de la Esperanza", "Espacio de reflexión y mensajes matinales para empezar el día.", 5, 0, 5, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),
        Program("am_02", "america", "Primera Edición: Resumen", "El resumen informativo de las noticias de la madrugada en Lima y regiones.", 5, 30, 6, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("am_03", "america", "América Noticias: Primera Edición", "El noticiero matutino líder con las principales noticias políticas, policiales y entrevistas.", 6, 30, 9, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Federico Salazar y Verónica Linares"),
        Program("am_04", "america", "América Hoy", "Magazine matinal con entretenimiento, recetas, salud, consejos y farándula.", 9, 30, 11, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE, presenter = "Ethel Pozo, Janet Barboza y Edson Dávila"),
        Program("am_05", "america", "Más Espectáculos", "Todas las novedades de la farándula peruana, entrevistas exclusivas y detras de cámaras.", 11, 30, 13, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.ENTRETENIMIENTO, presenter = "Jazmín Pinedo"),
        Program("am_06", "america", "América Noticias: Edición Mediodía", "Actualización informativa de las noticias más destacadas de la mañana a nivel nacional.", 13, 0, 14, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("am_07", "america", "Mande Quien Mande", "Programa de variedades, juegos, concursos, moda y diversión en las tardes peruanas.", 14, 0, 15, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.ENTRETENIMIENTO, presenter = "María Pía Copello y Carlos Vílchez"),
        Program("am_08", "america", "La Rosa de Guadalupe", "Historias y relatos de vida con mensajes de fe y superación de problemas cotidianos.", 15, 30, 16, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("am_09", "america", "Como Dice el Dicho", "Dichos populares ilustrados a través de reflexivas historias familiares y sociales.", 16, 30, 17, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("am_10", "america", "Los Milagros de la Rosa", "Episodios especiales y conmovedores dramas que tocan el corazón de los televidentes.", 17, 30, 19, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("am_11", "america", "Esto es Guerra (EEG)", "El reality de competencia física e intelectual más visto de la televisión peruana con 'Guerreros' y 'Combatientes'.", 19, 0, 20, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.ENTRETENIMIENTO, presenter = "Renzo Schuller y Johanna San Miguel"),
        Program("am_12", "america", "América Noticias: Edición Central", "El noticiero estelar del Perú con la información más completa y análisis de la jornada.", 20, 0, 20, 45, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Eduardo Guzmán y Günter Rave"),
        Program("am_13", "america", "Al Fondo Hay Sitio", "La aclamada serie cómica peruana de los Gonzales y los Maldini en Las Nuevas Lomas.", 20, 45, 21, 45, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA, presenter = "Erick Elera, Magdyel Ugaz, Gustavo Bueno"),
        Program("am_14", "america", "Los Otros Concha", "Telenovela nacional familiar llena de humor, contrastes sociales y romances.", 21, 45, 22, 45, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("am_15", "america", "La Banda del Chino", "Crónicas urbanas, reportajes de la calle limeña, ayuda social e historias de vida.", 22, 45, 23, 45, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),
        Program("am_16", "america", "América Deportes", "Lo mejor del fútbol peruano, la Liga 1, Selección Peruana y el deporte internacional.", 23, 45, 0, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.DEPORTES, presenter = "Erick Osores y Richard de la Piedra"),
        Program("am_17", "america", "El Chavo del 8", "El clásico infantil e inmortal del entrañable niño del barril y la vecindad.", 0, 30, 2, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.ENTRETENIMIENTO),
        Program("am_18", "america", "Destilando Amor", "Telenovela internacional estelar de pasión y venganza.", 2, 0, 5, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),

        // América TV - Sábado
        Program("am_s1", "america", "América Noticias: Edición Sabatina", "Noticias del fin de semana con reportajes especiales y clima en vivo.", 6, 0, 9, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("am_s2", "america", "¡Estás en Todas!", "Programa magazine sabatino de la farándula nacional con entrevistas a personajes célebres.", 9, 0, 11, 0, DayPattern.SATURDAY, ProgramGenre.ENTRETENIMIENTO, presenter = "Jaime 'Choca' Mandros y Natalie Vértiz"),
        Program("am_s3", "america", "El Chavo del 8", "Doble dosis de comedia clásica de Roberto Gómez Bolaños 'Chespirito'.", 11, 0, 13, 0, DayPattern.SATURDAY, ProgramGenre.INFANTIL),
        Program("am_s4", "america", "Cinescape", "El programa de cine más longevo del Perú con lanzamientos de Hollywood, avances y alfombras rojas.", 13, 0, 14, 30, DayPattern.SATURDAY, ProgramGenre.CINE, presenter = "Bruno Pinasco"),
        Program("am_s5", "america", "Función Estelar Cine América", "Grandes películas taquilleras de acción y comedia para disfrutar en familia.", 14, 30, 18, 0, DayPattern.SATURDAY, ProgramGenre.CINE),
        Program("am_s6", "america", "La Rosa de Guadalupe Especial", "Capítulos de alto impacto social y superación personal.", 18, 0, 20, 0, DayPattern.SATURDAY, ProgramGenre.NOVELA),
        Program("am_s7", "america", "El Reventonazo de la Chola", "Música popular, cumbia, sketches cómicos de humor peruano y artistas invitados.", 20, 0, 22, 30, DayPattern.SATURDAY, ProgramGenre.ENTRETENIMIENTO, presenter = "Ernesto Pimentel"),
        Program("am_s8", "america", "Cine de Medianoche", "Cine de suspenso y aventuras nocturnas.", 22, 30, 6, 0, DayPattern.SATURDAY, ProgramGenre.CINE),

        // América TV - Domingo
        Program("am_d1", "america", "La Santa Misa", "Transmisión litúrgica dominical desde la Basílica Catedral de Lima.", 6, 0, 7, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("am_d2", "america", "Domingo al Día", "Reportajes en profundidad, crónicas policiales, historias conmovedoras y actualidad.", 7, 0, 9, 30, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),
        Program("am_d3", "america", "América Noticias: Dominical", "Resumen informativo y los titulares que marcan la pauta del domingo.", 9, 30, 11, 0, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),
        Program("am_d4", "america", "El Chavo del 8", "El clásico dominical para compartir en el desayuno familiar.", 11, 0, 13, 0, DayPattern.SUNDAY, ProgramGenre.INFANTIL),
        Program("am_d5", "america", "TEC", "Lo último en tecnología, smartphones, videojuegos e innovaciones mundiales.", 13, 0, 14, 30, DayPattern.SUNDAY, ProgramGenre.CULTURA, presenter = "Chiara Pinasco"),
        Program("am_d6", "america", "Cine Dominical de Estreno", "Estrenos de películas taquilleras para la tarde dominical.", 14, 30, 18, 0, DayPattern.SUNDAY, ProgramGenre.CINE),
        Program("am_d7", "america", "En Esta Cocina Mando Yo", "Competencia culinaria de parejas y celebridades peruanas.", 18, 0, 20, 0, DayPattern.SUNDAY, ProgramGenre.ENTRETENIMIENTO, presenter = "Ethel Pozo y Yaco Eskenazi"),
        Program("am_d8", "america", "Cuarto Poder", "El programa periodístico dominical más influyente del Perú con investigaciones y destapes políticos.", 20, 0, 22, 30, DayPattern.SUNDAY, ProgramGenre.OPINION, presenter = "Sol Carreño"),
        Program("am_d9", "america", "Fútbol en América", "El debate futbolístico más polémico de la fecha de la Liga 1 y polémicas del balón.", 22, 30, 0, 0, DayPattern.SUNDAY, ProgramGenre.DEPORTES, presenter = "Erick Osores y Richard de la Piedra"),
        Program("am_d10", "america", "Madrugada Dominical", "Cine y series de trasnoche.", 0, 0, 6, 0, DayPattern.SUNDAY, ProgramGenre.CINE),

        // ==========================================
        // LATINA TELEVISIÓN (Canal 2) - Lunes a Viernes
        // ==========================================
        Program("lat_01", "latina", "Latina Noticias: Al Despertar", "Primeras noticias de la jornada limeña y reporte del tráfico en vivo.", 5, 0, 6, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("lat_02", "latina", "Latina Noticias: Matinal", "Noticiero ágil y cercano con enlaces desde todos los conos de Lima y regiones.", 6, 0, 9, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Pedro Tenorio y Lorena Álvarez"),
        Program("lat_03", "latina", "Arriba Mi Gente", "La mejor energía de la mañana con recetas prácticas, salud, música y debate de actualidad.", 9, 0, 11, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE, presenter = "Maju Mantilla, Santi Lesmes y Fernando Díaz"),
        Program("lat_04", "latina", "Latina Noticias: Mediodía", "Actualización informativa con las últimas noticias ocurridas en el país.", 11, 30, 13, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("lat_05", "latina", "El Gran Chef Famosos: El Menú", "Los mejores platos y momentos del exitoso reality culinario.", 13, 0, 14, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.ENTRETENIMIENTO),
        Program("lat_06", "latina", "Telenovela: Traicionada", "Intensa historia dramática sobre deslealtad y justicia.", 14, 30, 16, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("lat_07", "latina", "Papá en Apuros", "Telenovela nacional: Las peripecias de un capitán de la Marina criando a sus hijos.", 16, 0, 17, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("lat_08", "latina", "Pituca Sin Lucas", "Comedia romántica nacional: Una familia adinerada que debe empezar de cero en un barrio popular.", 17, 30, 19, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("lat_09", "latina", "Latina Noticias: Central", "El noticiero insignia de Latina Televisión con la seriedad y credibilidad que caracterizan a su conducción.", 19, 0, 20, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Mónica Delta"),
        Program("lat_10", "latina", "El Gran Chef Famosos", "El fenómeno televisivo donde famosos aprenden a cocinar contrarreloj bajo el estricto jurado.", 20, 30, 22, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.ENTRETENIMIENTO, presenter = "José Peláez, Giacomo Bocchio, Nelly Rossinelli y Javier Masías"),
        Program("lat_11", "latina", "Sobrevivientes / Series Estelares", "Ficción y adrenalina en la noche de Latina.", 22, 30, 23, 45, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("lat_12", "latina", "Latina Noticias: Noche", "Cierre informativo de la jornada con el resumen completo.", 23, 45, 1, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("lat_13", "latina", "Alerta Latina", "Documentales policiales, emergencias médicas e investigaciones.", 1, 0, 5, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),

        // Latina - Sábado
        Program("lat_s1", "latina", "Latina Noticias: Sábado", "Toda la información del fin de semana.", 6, 0, 9, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("lat_s2", "latina", "Reporte Semanal: Matinal", "Anticipos de investigación periodística.", 9, 0, 11, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("lat_s3", "latina", "El Gran Chef Famosos: Revancha", "Momentos cumbres y recetas maestras.", 11, 0, 13, 0, DayPattern.SATURDAY, ProgramGenre.ENTRETENIMIENTO),
        Program("lat_s4", "latina", "Cine Familiar", "Cine infantil y juvenil para compartir.", 13, 0, 16, 0, DayPattern.SATURDAY, ProgramGenre.CINE),
        Program("lat_s5", "latina", "Sábados en Familia", "Concursos familiares y destreza en pantalla.", 16, 0, 18, 30, DayPattern.SATURDAY, ProgramGenre.ENTRETENIMIENTO),
        Program("lat_s6", "latina", "Latina Noticias: Fin de Semana", "Noticias del día.", 18, 30, 20, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("lat_s7", "latina", "El Gran Chef Famosos: Noche de Eliminación", "Capítulo decisivo de expulsión donde un participante deja la cocina.", 20, 0, 22, 30, DayPattern.SATURDAY, ProgramGenre.ENTRETENIMIENTO, presenter = "José Peláez"),
        Program("lat_s8", "latina", "Función Estelar de Cine", "Cine de acción de primer nivel.", 22, 30, 6, 0, DayPattern.SATURDAY, ProgramGenre.CINE),

        // Latina - Domingo
        Program("lat_d1", "latina", "Latina Noticias: Amanecer Dominical", "Resumen de lo ocurrido el fin de semana.", 5, 0, 8, 30, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),
        Program("lat_d2", "latina", "Reporte Semanal", "Periodismo de profundidad, historias humanas peruanas y crónicas de actualidad.", 8, 30, 11, 0, DayPattern.SUNDAY, ProgramGenre.NOTICIAS, presenter = "Maritere Braschi"),
        Program("lat_d3", "latina", "Cine Familiar", "Películas clásicas familiares.", 11, 0, 13, 0, DayPattern.SUNDAY, ProgramGenre.CINE),
        Program("lat_d4", "latina", "Latina Noticias: Mediodía Dominical", "El acontecer del mediodía en Lima y provincias.", 13, 0, 14, 0, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),
        Program("lat_d5", "latina", "Somos Vóley / Deportes Perú", "Transmisiones de la liga peruana de vóley femenino y grandes competencias.", 14, 0, 16, 30, DayPattern.SUNDAY, ProgramGenre.DEPORTES),
        Program("lat_d6", "latina", "Función Estelar", "Película de estreno para la tarde.", 16, 30, 19, 0, DayPattern.SUNDAY, ProgramGenre.CINE),
        Program("lat_d7", "latina", "El Gran Chef: La Previa", "Entrevistas detrás del set del reality.", 19, 0, 20, 0, DayPattern.SUNDAY, ProgramGenre.ENTRETENIMIENTO),
        Program("lat_d8", "latina", "Punto Final", "Investigaciones periodísticas exclusivas, denuncias de corrupción y entrevistas políticas de fondo.", 20, 0, 22, 30, DayPattern.SUNDAY, ProgramGenre.OPINION, presenter = "Mónica Delta"),
        Program("lat_d9", "latina", "Sin Medias Tintas", "Entrevistas sin filtros a las personalidades políticas del momento.", 22, 30, 23, 45, DayPattern.SUNDAY, ProgramGenre.OPINION, presenter = "Christian Hudtwalcker"),
        Program("lat_d10", "latina", "La Gran Sangre / Madrugada", "La mítica serie peruana de acción urbana y justicieros.", 23, 45, 5, 0, DayPattern.SUNDAY, ProgramGenre.NOVELA),

        // ==========================================
        // TV PERÚ (Canal 7 - IRTP) - Lunes a Viernes
        // ==========================================
        Program("tvp_01", "tvperu", "Jiwasanaka", "El primer noticiero televisivo en lengua aimara en el Perú.", 5, 0, 5, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("tvp_02", "tvperu", "Ñuqanchik", "El primer noticiero matutino en lengua quechua del Perú con cobertura de todo el sur andino.", 5, 30, 6, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("tvp_03", "tvperu", "TV Perú Noticias: Matinal", "Noticias nacionales desde una perspectiva plural, descentralizada y al servicio de los ciudadanos.", 6, 0, 8, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Jennifer Cerecida y Julio Navarro"),
        Program("tvp_04", "tvperu", "Qué Está Pasando", "Noticiero descentralizado con despachos y denuncias vecinales en vivo desde los 24 departamentos.", 8, 30, 9, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("tvp_05", "tvperu", "Con Sabor a Perú", "Recetas tradicionales de la gastronomía de las tres regiones naturales peruanas.", 9, 30, 10, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.CULTURA, presenter = "Israel Laura"),
        Program("tvp_06", "tvperu", "Más Conectados", "Magazine enfocado en salud, bienestar, economía familiar y orientación comunitaria.", 10, 30, 12, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),
        Program("tvp_07", "tvperu", "Cuerpo Médico", "Especialistas en vivo resuelven consultas médicas telefónicas de la población.", 12, 0, 13, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),
        Program("tvp_08", "tvperu", "TV Perú Noticias: Edición Mediodía", "Balance de las noticias nacionales y reportes oficiales del Estado.", 13, 0, 14, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("tvp_09", "tvperu", "Costumbres", "Recorrido por las festividades patronales, danzas y tradiciones vivas de los pueblos del Perú.", 14, 0, 15, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.CULTURA, presenter = "Sonaly Tuesta"),
        Program("tvp_10", "tvperu", "Reportaje al Perú", "Aventuras y rutas turísticas por los rincones más impresionantes de la geografía peruana.", 15, 0, 16, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.CULTURA, presenter = "Manolo del Castillo"),
        Program("tvp_11", "tvperu", "Chicos IPe en TV Perú", "Series animadas e historias entretenidas para fomentar la creatividad y valores en los niños.", 16, 0, 17, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.INFANTIL),
        Program("tvp_12", "tvperu", "Te Veo a las 5", "Espacio cultural y de entretenimiento para toda la familia peruana.", 17, 0, 18, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),
        Program("tvp_13", "tvperu", "GeoMundo", "Análisis riguroso de la geopolítica, relaciones internacionales y acontecimientos mundiales.", 18, 0, 19, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION, presenter = "Farid Kahhat"),
        Program("tvp_14", "tvperu", "TV Perú Noticias: Edición Central", "El resumen de los sucesos más trascendentes del Perú con entrevistas clave.", 19, 0, 20, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Fátima Saldonid"),
        Program("tvp_15", "tvperu", "Sucedió en el Perú", "Documentales sobre los hitos, personajes y batallas históricas de la peruanidad.", 20, 0, 21, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.CULTURA, presenter = "Paul Vega"),
        Program("tvp_16", "tvperu", "En Pared", "Mesa de análisis político y debate con panelistas especializados de diversa postura.", 21, 0, 22, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION),
        Program("tvp_17", "tvperu", "El Placer de los Ojos", "El programa de análisis cinematográfico más prestigioso de la televisión peruana.", 22, 0, 23, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.CINE, presenter = "Ricardo Bedoya"),
        Program("tvp_18", "tvperu", "Presencia Cultural / Repetición Especial", "Literatura, arte plástico, teatro y memoria cultural del Perú.", 23, 0, 5, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.CULTURA),

        // TV Perú - Fines de Semana
        Program("tvp_fd1", "tvperu", "La Santa Misa", "Transmisión eucarística dominical.", 6, 0, 7, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("tvp_fd2", "tvperu", "Primera Hora Noticias", "Primeras noticias de fin de semana.", 7, 0, 9, 0, DayPattern.DAILY, ProgramGenre.NOTICIAS),
        Program("tvp_fd3", "tvperu", "A Cuatro Tiempos", "Música académica y sinfónica peruana.", 9, 0, 10, 30, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("tvp_fd4", "tvperu", "Museos Puertas Abiertas", "Exploración de los principales tesoros arqueológicos y museos peruanos.", 10, 30, 12, 0, DayPattern.SATURDAY, ProgramGenre.CULTURA),
        Program("tvp_fd5", "tvperu", "Mediodía Criollo", "Homenaje a la música criolla con las mejores voces de la jarana limeña.", 12, 0, 13, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("tvp_fd6", "tvperu", "Domingos de Fiesta", "El programa musical que recorre los barrios y provincias llevando salsa, cumbia y folclore en vivo.", 14, 0, 16, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA, presenter = "María Jesús Rodríguez 'La Miski'"),
        Program("tvp_fd7", "tvperu", "Reportaje al Perú: Especial Regiones", "Capítulos de colección viajando a la Amazonía, los Andes y la costa.", 17, 0, 18, 30, DayPattern.SUNDAY, ProgramGenre.CULTURA, presenter = "Manolo del Castillo"),
        Program("tvp_fd8", "tvperu", "Goles en Acción", "Resumen deportivo, goles de la fecha futbolística y polémicas del balón.", 20, 0, 22, 0, DayPattern.SUNDAY, ProgramGenre.DEPORTES, presenter = "Alberto Beingolea"),
        Program("tvp_fd9", "tvperu", "Danzas y Música del Perú", "El acervo musical de todas nuestras regiones.", 22, 0, 6, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),

        // ==========================================
        // ATV (Canal 9) - Lunes a Viernes
        // ==========================================
        Program("atv_01", "atv", "ATV Noticias: Amanecer", "Primer contacto noticioso del día con móviles en las calles.", 5, 30, 6, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("atv_02", "atv", "ATV Noticias: Edición Matinal", "Noticiero matutino con despachos ciudadanos en vivo, clima y servicio.", 6, 0, 9, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Fernando Díaz y Alicia Retto"),
        Program("atv_03", "atv", "Así de Simple", "Espacio dinámico con actualidad, consejos prácticos y debate matinal.", 9, 0, 10, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),
        Program("atv_04", "atv", "Telenovela: Amor Eterno", "Gran producción de drama y romance turco.", 10, 30, 12, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("atv_05", "atv", "ATV Noticias: Al Día", "Resumen de las noticias más destacadas de la mañana en vivo.", 12, 0, 13, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("atv_06", "atv", "Telenovela: Ana Cristina", "Producción nacional de pasión y secretos familiares.", 13, 0, 14, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("atv_07", "atv", "Andrea", "Talk show social donde se confrontan y resuelven conflictos familiares y pruebas de ADN con mediación legal.", 14, 30, 16, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.ENTRETENIMIENTO, presenter = "Andrea Llosa"),
        Program("atv_08", "atv", "Lo que Callamos las Mujeres", "Historias de lucha femenina y justicia ante situaciones adversas.", 16, 0, 17, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("atv_09", "atv", "La Mujer en el Espejo", "Telenovela clásica de romance e intrigas.", 17, 30, 19, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("atv_10", "atv", "ATV Noticias: Edición Central", "El noticiero principal de la noche en ATV con entrevistas de coyuntura.", 19, 0, 20, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Drusila Zileri"),
        Program("atv_11", "atv", "Magaly TV: La Firme", "El programa de espectáculos más polémico y comentado del Perú con los 'ampays' más sonados de la farándula nacional.", 20, 30, 21, 45, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.ENTRETENIMIENTO, presenter = "Magaly Medina"),
        Program("atv_12", "atv", "ATV Deportes / Especial", "Las mejores jugadas y actualidad del deporte.", 21, 45, 23, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.DEPORTES),
        Program("atv_13", "atv", "El Deportivo en Otra Cancha", "Entrevistas relajadas, anécdotas del fútbol, farándula deportiva y humor nocturno.", 23, 0, 0, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.DEPORTES, presenter = "Paco Bazán"),
        Program("atv_14", "atv", "Series de Madrugada (The Walking Dead)", "Series internacionales de acción y suspenso.", 0, 0, 5, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.CINE),

        // ATV - Fines de Semana
        Program("atv_fd1", "atv", "Canto Andino", "La fiesta de la música andina peruana con artistas de todo el territorio nacional.", 6, 30, 8, 0, DayPattern.DAILY, ProgramGenre.CULTURA, presenter = "Isaac Sarmiento"),
        Program("atv_fd2", "atv", "Las Aventuras de Tom y Jerry & Looney Tunes", "Dibujos animados clásicos para despertar con alegría.", 8, 0, 11, 30, DayPattern.SATURDAY, ProgramGenre.INFANTIL),
        Program("atv_fd3", "atv", "Los Picapiedra", "Comedia animada de la prehistoria.", 11, 30, 13, 0, DayPattern.SATURDAY, ProgramGenre.INFANTIL),
        Program("atv_fd4", "atv", "Lucha Libre TNA / WWE", "Emocionantes combates en el cuadrilátero.", 13, 0, 15, 0, DayPattern.SUNDAY, ProgramGenre.DEPORTES),
        Program("atv_fd5", "atv", "Cine ATV Premier", "Cine de aventuras y películas de Hollywood.", 15, 0, 20, 0, DayPattern.SUNDAY, ProgramGenre.CINE),
        Program("atv_fd6", "atv", "Día D", "Reportajes en profundidad, crónicas policiales de impacto e investigaciones exclusivas del domingo.", 20, 0, 22, 0, DayPattern.SUNDAY, ProgramGenre.OPINION, presenter = "Pamela Vértiz"),
        Program("atv_fd7", "atv", "Nunca Más", "Investigación sobre casos de injusticia y violencia familiar para buscar soluciones reales.", 22, 0, 23, 0, DayPattern.SUNDAY, ProgramGenre.OPINION, presenter = "Andrea Llosa"),
        Program("atv_fd8", "atv", "El Deportivo Dominical", "Resumen del fútbol peruano e internacional.", 23, 0, 0, 30, DayPattern.SUNDAY, ProgramGenre.DEPORTES),

        // ==========================================
        // PANAMERICANA TELEVISIÓN (Canal 5)
        // ==========================================
        Program("pan_01", "panamericana", "Buenos Días Perú: Regional", "Despachos descentralizados desde el interior del país.", 5, 30, 6, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("pan_02", "panamericana", "Buenos Días Perú", "El informativo matinal decano de la televisión con primicias policiales y entrevistas políticas.", 6, 0, 9, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Pamela Acosta y Claudia Chiroque"),
        Program("pan_03", "panamericana", "Vida Sana y Telebrands", "Espacio de salud natural y bienestar para el hogar.", 9, 30, 10, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),
        Program("pan_04", "panamericana", "Préndete", "Magazine de mediodía con farándula, entretenimiento, baile y cocina.", 10, 30, 12, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE, presenter = "Karla Tarazona y Christian Domínguez"),
        Program("pan_05", "panamericana", "24 Horas: Edición Mediodía", "El reporte informativo al detalle con enlaces en directo.", 12, 0, 13, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("pan_06", "panamericana", "La Calle No Calla", "Periodismo ciudadano atendiendo denuncias comunitarias de Lima.", 13, 30, 15, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("pan_07", "panamericana", "La Hija del Mariachi", "La entrañable historia de amor y rancheras que conquistó Latinoamérica.", 15, 0, 16, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("pan_08", "panamericana", "Ana de Nadie", "Dramática novela sobre segundas oportunidades y valor personal.", 16, 30, 18, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("pan_09", "panamericana", "La Familia Ingalls", "El gran clásico de la pradera con Charles, Caroline y la pequeña Laura Ingalls.", 18, 0, 19, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("pan_10", "panamericana", "24 Horas: Edición Central", "El noticiero insignia e histórico de Panamericana TV con la voz de la experiencia.", 19, 30, 20, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Marisol García"),
        Program("pan_11", "panamericana", "Miniserie Estelar / El Señor de los Cielos", "Superproducción dramática nocturna.", 20, 30, 21, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("pan_12", "panamericana", "Esta Noche con Panamericana", "Entrevistas exclusivas a figuras políticas, artistas y personajes influyentes.", 21, 30, 22, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION),
        Program("pan_13", "panamericana", "Policías de Chicago (Chicago P.D.)", "Acción policial en la unidad de inteligencia contra el crimen.", 22, 30, 23, 45, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.CINE),
        Program("pan_14", "panamericana", "24 Horas: Edición Noche", "Último repaso a las noticias del día.", 23, 45, 0, 45, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("pan_15", "panamericana", "Los Portales / GeoHerbal", "Espacio nocturno.", 0, 45, 5, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),

        // Panamericana - Domingo
        Program("pan_d1", "panamericana", "Encantos del Perú", "Folclore y danzas tradicionales de nuestro amado Perú.", 5, 30, 8, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("pan_d2", "panamericana", "En Forma y Vida Sana", "Ejercicios y hábitos saludables para el domingo.", 8, 0, 10, 0, DayPattern.SUNDAY, ProgramGenre.MAGAZINE),
        Program("pan_d3", "panamericana", "La Cajita Musical", "Música infantil y talentos jóvenes.", 10, 0, 11, 0, DayPattern.SUNDAY, ProgramGenre.INFANTIL),
        Program("pan_d4", "panamericana", "Patrimonio Mundial y Visión Futuro", "Documentales sobre las maravillas peruanas y tecnología.", 11, 0, 12, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("pan_d5", "panamericana", "¡Escápate!", "Viajes y turismo gastronómico por los valles de Lima y el Perú.", 12, 0, 14, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("pan_d6", "panamericana", "Cine de Acción Dominical", "Películas de aventura y suspenso.", 14, 0, 19, 30, DayPattern.SUNDAY, ProgramGenre.CINE),
        Program("pan_d7", "panamericana", "24 Horas: Edición Dominical", "Noticias del día.", 19, 30, 20, 0, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),
        Program("pan_d8", "panamericana", "Panorama", "El programa dominical pionero de la investigación periodística, denuncias de corrupción y destapes políticos.", 20, 0, 22, 30, DayPattern.SUNDAY, ProgramGenre.OPINION, presenter = "Carla Muschi"),
        Program("pan_d9", "panamericana", "El Dominical de Panamericana", "Crónicas urbanas y perfiles insólitos del Perú.", 22, 30, 23, 45, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),

        // ==========================================
        // WILLAX TELEVISIÓN (Canal 31)
        // ==========================================
        Program("wlx_01", "willax", "Al Día con Willax Nacional", "Primeras informaciones políticas de la mañana.", 6, 0, 7, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("wlx_02", "willax", "Al Día con Willax", "Entrevistas en vivo y actualidad nacional.", 7, 0, 9, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("wlx_03", "willax", "Entrometidos", "Comentarios de farándula con estilo directo.", 9, 0, 11, 25, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.ENTRETENIMIENTO, presenter = "Carlos Cacho"),
        Program("wlx_04", "willax", "Willax Noticias: Mediodía", "Actualización informativa de la mañana.", 11, 25, 12, 50, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("wlx_05", "willax", "Telenovela: Amor Prohibido", "Dramática teleserie de romances encontrados.", 12, 50, 14, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("wlx_06", "willax", "Amor y Fuego", "El show de entretenimiento de las tardes con destapes de la farándula y primicias.", 14, 30, 17, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.ENTRETENIMIENTO, presenter = "Rodrigo González 'Peluchín' y Gigi Mitre"),
        Program("wlx_07", "willax", "Un Día en el Mall", "Moda, compras y tendencias limeñas.", 17, 0, 18, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),
        Program("wlx_08", "willax", "Caso Cerrado", "Casos legales insólitos mediados en corte.", 18, 0, 19, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.ENTRETENIMIENTO, presenter = "Dra. Ana María Polo"),
        Program("wlx_09", "willax", "Willax Noticias: Central", "El bloque estelar de informaciones.", 19, 0, 19, 55, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("wlx_10", "willax", "Contra Corriente", "Investigaciones periodísticas exclusivas y destapes políticos de alto impacto.", 19, 55, 20, 55, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION, presenter = "Augusto Thorndike"),
        Program("wlx_11", "willax", "Beto A Saber", "Periodismo de opinión crítico y sin concesiones.", 20, 55, 22, 15, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION, presenter = "Beto Ortiz"),
        Program("wlx_12", "willax", "Ahora y En la Hora", "Entrevistas punzantes y análisis político de la coyuntura del país.", 22, 15, 23, 15, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION, presenter = "Milagros Leiva"),
        Program("wlx_13", "willax", "Crónicas de Impacto", "Reportajes insólitos del Perú nocturno.", 23, 15, 0, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),

        // Willax - Domingo
        Program("wlx_d1", "willax", "Hechos en Willax", "Reportajes especiales de investigación.", 6, 0, 9, 0, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),
        Program("wlx_d2", "willax", "Once Machos", "Entretenimiento y tertulia entre amigos.", 9, 0, 11, 0, DayPattern.SUNDAY, ProgramGenre.ENTRETENIMIENTO),
        Program("wlx_d3", "willax", "Cine Willax", "Películas de acción y comedia para el fin de semana.", 11, 0, 16, 0, DayPattern.SUNDAY, ProgramGenre.CINE),
        Program("wlx_d4", "willax", "Caso Cerrado: Especial", "Los casos más recordados de la Dra. Polo.", 16, 0, 18, 0, DayPattern.SUNDAY, ProgramGenre.ENTRETENIMIENTO),
        Program("wlx_d5", "willax", "Cine de Estreno", "Películas destacadas de la cartelera.", 18, 0, 21, 30, DayPattern.SUNDAY, ProgramGenre.CINE),
        Program("wlx_d6", "willax", "Willax Deportes", "Análisis futbolístico con comentarios contundentes de la fecha deportiva.", 21, 30, 22, 30, DayPattern.SUNDAY, ProgramGenre.DEPORTES, presenter = "Eddie Fleischman"),
        Program("wlx_d7", "willax", "Noche de Luna", "Entrevistas íntimas con grandes personajes de la cultura y política.", 22, 30, 23, 30, DayPattern.SUNDAY, ProgramGenre.OPINION),

        // ==========================================
        // EXITOSA TV & RPP TV
        // ==========================================
        Program("exi_01", "exitosa", "Exitosa Perú", "La voz de los pueblos en vivo, reclamos vecinales y debate político sin filtros.", 6, 0, 10, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION, presenter = "Nicolás Lúcar"),
        Program("exi_02", "exitosa", "En Defensa de la Verdad", "Análisis implacable de la coyuntura del país.", 10, 0, 12, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION, presenter = "Manuel Rosas"),
        Program("exi_03", "exitosa", "Informamos y Opinamos", "La actualidad del mediodía con denuncias de los ciudadanos.", 12, 0, 15, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Karina Novoa"),
        Program("exi_04", "exitosa", "Exitosa Deportes", "Debate futbolero caliente sobre la Selección y la Liga 1 peruana.", 15, 0, 17, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.DEPORTES, presenter = "Gonzalo Núñez y equipo"),
        Program("exi_05", "exitosa", "Exitosa Te Escucha", "Llamadas del público desde todo el Perú atendiendo problemáticas sociales.", 17, 0, 20, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION, presenter = "Katyusca Torres Aybar"),
        Program("exi_06", "exitosa", "La Voz de los Pueblos", "Resumen de las luchas sociales en provincias y debate en vivo.", 20, 0, 23, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION),
        Program("exi_07", "exitosa", "Madrugada de Exitosa", "Noticias y música para los trabajadores nocturnos.", 23, 0, 6, 0, DayPattern.DAILY, ProgramGenre.NOTICIAS),

        Program("rpp_01", "rpptv", "La Rotativa del Aire: Matinal", "La mayor cadena informativa del Perú transmitiendo en simultáneo.", 6, 0, 10, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("rpp_02", "rpptv", "Encendidos", "Espacio dedicado a la salud, familia y consejos para la vida cotidiana.", 10, 0, 12, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),
        Program("rpp_03", "rpptv", "Siempre en Casa", "Orientación al consumidor y nutrición.", 12, 0, 13, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),
        Program("rpp_04", "rpptv", "La Rotativa del Aire: Mediodía", "El balance nacional de la noticia al momento.", 13, 0, 14, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("rpp_05", "rpptv", "Conexión", "El pulso del país con entrevistas a autoridades.", 14, 30, 17, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Jorge Rodríguez"),
        Program("rpp_06", "rpptv", "Las Claves del Día", "Resumen analítico de los temas prioritarios de la tarde.", 17, 0, 19, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("rpp_07", "rpptv", "Las Cosas Como Son", "Editorial y análisis político con perspectiva histórica.", 19, 0, 20, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION, presenter = "Fernando Carvallo"),
        Program("rpp_08", "rpptv", "Nada Está Dicho", "Entrevistas centrales a los protagonistas de la noticia del día.", 20, 0, 21, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION, presenter = "Jaime Chincha"),
        Program("rpp_09", "rpptv", "Fútbol como Cancha", "Toda la actualidad del fútbol nacional y las copas internacionales.", 21, 0, 22, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.DEPORTES),
        Program("rpp_10", "rpptv", "Resumen RPP Noticias", "Las principales noticias para cerrar el día.", 22, 30, 6, 0, DayPattern.DAILY, ProgramGenre.NOTICIAS),

        // ==========================================
        // CANAL IPE (Canal 7.4) & TV PERÚ NOTICIAS (7.3) & CONGRESO TV & VIVA TV
        // ==========================================
        Program("ipe_01", "canalipe", "Bailemos con Martina & Ciudad Jardín", "Música, motricidad y cuidado del medio ambiente para los más chicos.", 6, 0, 8, 0, DayPattern.DAILY, ProgramGenre.INFANTIL),
        Program("ipe_02", "canalipe", "Chicos IPe: Cuentos de Chaski", "Narraciones orales y mitos peruanos adaptados en animación.", 8, 0, 10, 0, DayPattern.DAILY, ProgramGenre.INFANTIL),
        Program("ipe_03", "canalipe", "Viajeros del Tiempo & Viajes de Papel", "Fomentando el amor por la lectura y la historia en niñas y niños.", 10, 0, 12, 0, DayPattern.DAILY, ProgramGenre.INFANTIL),
        Program("ipe_04", "canalipe", "Laberinto de Aventuras", "Juegos de ingenio, acertijos y destrezas para escolares.", 12, 0, 14, 0, DayPattern.DAILY, ProgramGenre.INFANTIL),
        Program("ipe_05", "canalipe", "Ciencia en Casa & Mi Robot Favorito", "Experimentos sencillos y tecnología explicada paso a paso.", 14, 0, 16, 0, DayPattern.DAILY, ProgramGenre.CULTURA),
        Program("ipe_06", "canalipe", "Zona de Reto & Chicos IPe", "Desafíos creativos, dibujo y stop-motion.", 16, 0, 18, 0, DayPattern.DAILY, ProgramGenre.INFANTIL),
        Program("ipe_07", "canalipe", "Música y Arte: Creadores Peruanos", "Jóvenes artistas peruanos compartiendo su pasión y talento.", 18, 0, 20, 0, DayPattern.DAILY, ProgramGenre.CULTURA),
        Program("ipe_08", "canalipe", "Documentales de Flora y Fauna del Perú", "Biodiversidad de la Amazonía y los Andes peruanos.", 20, 0, 22, 0, DayPattern.DAILY, ProgramGenre.CULTURA),
        Program("ipe_09", "canalipe", "Noche Cultural IPe", "Animaciones de autor y cortos peruanos.", 22, 0, 6, 0, DayPattern.DAILY, ProgramGenre.CULTURA),

        Program("tpn_01", "tvperunoticias", "TV Perú Noticias: Amanecer", "Primer informe del acontecer nacional con enlaces en directo.", 6, 0, 9, 0, DayPattern.DAILY, ProgramGenre.NOTICIAS),
        Program("tpn_02", "tvperunoticias", "Enlace Nacional y Despachos Regionales", "La voz de las regiones con móviles desde Arequipa, Cusco, Piura, Iquitos y Trujillo.", 9, 0, 12, 0, DayPattern.DAILY, ProgramGenre.NOTICIAS),
        Program("tpn_03", "tvperunoticias", "Edición Mediodía Perú", "Cobertura de las conferencias gubernamentales y noticias de coyuntura.", 12, 0, 14, 0, DayPattern.DAILY, ProgramGenre.NOTICIAS),
        Program("tpn_04", "tvperunoticias", "Panorama Regional en Directo", "Las problemáticas locales y avances en el interior del territorio nacional.", 14, 0, 17, 0, DayPattern.DAILY, ProgramGenre.NOTICIAS),
        Program("tpn_05", "tvperunoticias", "Minuto a Minuto: Edición Tarde", "La noticia al instante con análisis de especialistas.", 17, 0, 19, 0, DayPattern.DAILY, ProgramGenre.NOTICIAS),
        Program("tpn_06", "tvperunoticias", "TV Perú Noticias: Edición Central", "El noticiero central con todas las voces.", 19, 0, 21, 0, DayPattern.DAILY, ProgramGenre.NOTICIAS, presenter = "Fátima Saldonid"),
        Program("tpn_07", "tvperunoticias", "Debate y Análisis en Vivo", "Mesa política sobre las leyes y reformas en discusión en el Congreso.", 21, 0, 23, 0, DayPattern.DAILY, ProgramGenre.OPINION),
        Program("tpn_08", "tvperunoticias", "Guardia Informativa Nocturna", "Actualizaciones de última hora y cables internacionales.", 23, 0, 6, 0, DayPattern.DAILY, ProgramGenre.NOTICIAS),

        Program("con_01", "congresotv", "Comisiones Ordinarias del Congreso", "Debate de proyectos de ley en vivo en las comisiones dictaminadoras.", 8, 0, 13, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION),
        Program("con_02", "congresotv", "Resumen Parlamentario Mediodía", "Reporte de las votaciones y proyectos aprobados.", 13, 0, 15, 0, DayPattern.DAILY, ProgramGenre.NOTICIAS),
        Program("con_03", "congresotv", "Sesión del Pleno del Congreso de la República", "Debate y votación en directo de las leyes del Parlamento Nacional.", 15, 0, 20, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION),
        Program("con_04", "congresotv", "Mesa de Diálogo Parlamentario", "Entrevistas a los portavoces de las diversas bancadas.", 20, 0, 22, 0, DayPattern.DAILY, ProgramGenre.OPINION),
        Program("con_05", "congresotv", "Archivo Parlamentario", "Repetición de las sesiones históricas del Congreso.", 22, 0, 8, 0, DayPattern.DAILY, ProgramGenre.CULTURA),

        Program("viv_01", "vivatv", "Amanecer Criollo", "Música de la guardia vieja limeña y valses criollos.", 6, 0, 9, 0, DayPattern.DAILY, ProgramGenre.CULTURA),
        Program("viv_02", "vivatv", "Sabor Peruano: Gastronomía y Folclore", "Costumbres y comida popular limeña.", 9, 0, 12, 0, DayPattern.DAILY, ProgramGenre.CULTURA),
        Program("viv_03", "vivatv", "Viva Cumbia: Grandes Éxitos", "Los mejores videos y orquestas de cumbia peruana.", 12, 0, 15, 0, DayPattern.DAILY, ProgramGenre.ENTRETENIMIENTO),
        Program("viv_04", "vivatv", "La Caravana del Folclore", "Huaynos, sayas y morenadas de los artistas del momento.", 15, 0, 18, 0, DayPattern.DAILY, ProgramGenre.CULTURA),
        Program("viv_05", "vivatv", "Variedades Viva TV", "Entrevistas musicales y lanzamientos artísticos.", 18, 0, 21, 0, DayPattern.DAILY, ProgramGenre.ENTRETENIMIENTO),
        Program("viv_06", "vivatv", "Conciertos del Perú", "Presentaciones en vivo de bandas peruanas.", 21, 0, 0, 0, DayPattern.DAILY, ProgramGenre.ENTRETENIMIENTO),
        Program("viv_07", "vivatv", "Música Continua de Noche", "Baladas y música del recuerdo.", 0, 0, 6, 0, DayPattern.DAILY, ProgramGenre.ENTRETENIMIENTO)
    )

    fun getCurrentProgram(channelId: String, peruTime: ZonedDateTime = getCurrentPeruTime()): Program? {
        val hour = peruTime.hour
        val minute = peruTime.minute
        val dayOfWeek = peruTime.dayOfWeek
        val channelPrograms = programs.filter { it.channelId == channelId }
        
        return channelPrograms.firstOrNull { it.isCurrentlyPlaying(hour, minute, dayOfWeek) }
            ?: channelPrograms.firstOrNull()
    }

    fun getNextProgram(channelId: String, currentProgram: Program?, peruTime: ZonedDateTime = getCurrentPeruTime()): Program? {
        val dayOfWeek = peruTime.dayOfWeek
        val matchingDayPrograms = programs
            .filter { it.channelId == channelId && it.dayPattern.matches(dayOfWeek) }
            .sortedWith(compareBy({ it.startHour }, { it.startMinute }))

        if (currentProgram == null || matchingDayPrograms.isEmpty()) return null

        val currentIndex = matchingDayPrograms.indexOfFirst { it.id == currentProgram.id }
        return if (currentIndex in 0 until matchingDayPrograms.size - 1) {
            matchingDayPrograms[currentIndex + 1]
        } else {
            matchingDayPrograms.firstOrNull()
        }
    }

    fun getScheduleForChannel(channelId: String, dayOfWeek: DayOfWeek): List<Program> {
        return programs
            .filter { it.channelId == channelId && it.dayPattern.matches(dayOfWeek) }
            .sortedWith(compareBy({ it.startHour }, { it.startMinute }))
    }

    fun searchPrograms(query: String): List<Program> {
        if (query.isBlank()) return emptyList()
        val q = query.trim().lowercase()
        return programs.filter { 
            it.title.lowercase().contains(q) ||
            it.description.lowercase().contains(q) ||
            it.presenter.lowercase().contains(q) ||
            it.genre.displayName.lowercase().contains(q)
        }
    }
}
