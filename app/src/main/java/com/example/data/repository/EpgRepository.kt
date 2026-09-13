package com.example.data.repository

import com.example.data.model.DayPattern
import com.example.data.model.Program
import com.example.data.model.ProgramGenre
import java.time.DayOfWeek
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
        // 1. AMÉRICA TELEVISIÓN (Canal 4)
        // ==========================================
        // Lunes a Viernes
        Program("am_01", "america", "La Voz de la Esperanza", "Espacio de reflexión y mensajes matinales para empezar el día.", 5, 0, 5, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),
        Program("am_02", "america", "Primera Edición: Resumen", "El resumen informativo de las noticias de la madrugada.", 5, 30, 6, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("am_03", "america", "América Noticias: Primera Edición", "El noticiero matutino líder con enlaces en directo y entrevistas.", 6, 30, 9, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Federico Salazar y Verónica Linares"),
        Program("am_04", "america", "América Hoy", "Magazine matinal con entretenimiento, cocina, salud y farándula.", 9, 30, 11, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE, presenter = "Ethel Pozo, Janet Barboza y Edson Dávila"),
        Program("am_05", "america", "Más Espectáculos", "Todas las novedades de la farándula nacional y detrás de cámaras.", 11, 30, 13, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.ENTRETENIMIENTO, presenter = "Jazmín Pinedo"),
        Program("am_06", "america", "América Noticias: Edición Mediodía", "Actualización informativa de las noticias más destacadas del mediodía.", 13, 0, 14, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("am_07", "america", "Mande Quien Mande", "Programa de variedades, humor, concursos y moda en las tardes peruanas.", 14, 0, 15, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.ENTRETENIMIENTO, presenter = "María Pía Copello y La Carlota"),
        Program("am_08", "america", "La Rosa de Guadalupe", "Historias y relatos de vida con mensajes de fe y superación.", 15, 30, 16, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("am_09", "america", "Como Dice el Dicho", "Dichos populares ilustrados con historias de reflexión familiar.", 16, 30, 17, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("am_10", "america", "Los Milagros de la Rosa", "Episodios especiales y conmovedores dramas que tocan el corazón.", 17, 30, 19, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("am_11", "america", "Esto es Guerra (EEG)", "El reality de competencia física más sintonizado del Perú con Guerreros y Combatientes.", 19, 0, 20, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.ENTRETENIMIENTO, presenter = "Renzo Schuller y Johanna San Miguel"),
        Program("am_12", "america", "América Noticias: Edición Central", "El noticiero estelar del Perú con el reporte completo y análisis de la coyuntura.", 20, 0, 20, 45, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Eduardo Guzmán y Günter Rave"),
        Program("am_13", "america", "Al Fondo Hay Sitio", "La aclamada serie cómica peruana sobre las vivencias en Las Nuevas Lomas.", 20, 45, 21, 45, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA, presenter = "Erick Elera, Magdyel Ugaz, Gustavo Bueno"),
        Program("am_14", "america", "Los Otros Concha", "Telenovela nacional familiar llena de romance, enredos y superación.", 21, 45, 22, 45, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("am_15", "america", "La Banda del Chino", "Crónicas urbanas, reportajes de medianoche y notas del Perú profundo.", 22, 45, 23, 45, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),
        Program("am_16", "america", "América Deportes", "Resumen de la jornada futbolística de la Liga 1 y la Selección.", 23, 45, 0, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.DEPORTES, presenter = "Erick Osores"),
        Program("am_17", "america", "El Chavo del 8", "El clásico de la vecindad más querida de Latinoamérica.", 0, 30, 2, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.ENTRETENIMIENTO),
        Program("am_18", "america", "Madrugada de Telenovelas", "Repetición estelar de grandes producciones dramáticas.", 2, 0, 5, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),

        // América TV - Sábado
        Program("am_s0", "america", "Trasnoche de Cine América", "Cine de aventuras y suspenso en la madrugada sabatina.", 0, 0, 6, 0, DayPattern.SATURDAY, ProgramGenre.CINE),
        Program("am_s1", "america", "América Noticias: Edición Sabatina", "Información del fin de semana con reportajes especiales.", 6, 0, 9, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("am_s2", "america", "¡Estás en Todas!", "Magazine sabatino de espectáculos con entrevistas exclusivas.", 9, 0, 11, 0, DayPattern.SATURDAY, ProgramGenre.ENTRETENIMIENTO, presenter = "Jaime Choca Mandros"),
        Program("am_s3", "america", "El Chavo del 8 Sabatino", "Doble capítulo de humor clásico para toda la familia.", 11, 0, 13, 0, DayPattern.SATURDAY, ProgramGenre.INFANTIL),
        Program("am_s4", "america", "Cinescape", "El programa de cine y estrenos de cartelera más visto del país.", 13, 0, 14, 30, DayPattern.SATURDAY, ProgramGenre.CINE, presenter = "Bruno Pinasco"),
        Program("am_s5", "america", "Cine Familiar: Función Estelar", "Películas taquilleras de comedia y acción.", 14, 30, 18, 30, DayPattern.SATURDAY, ProgramGenre.CINE),
        Program("am_s6", "america", "La Rosa de Guadalupe: Especial Sabatino", "Historias de superación personal y milagros.", 18, 30, 20, 0, DayPattern.SATURDAY, ProgramGenre.NOVELA),
        Program("am_s7", "america", "El Reventonazo de la Chola", "Música popular, cumbia, humor y sketches con artistas peruanos.", 20, 0, 22, 30, DayPattern.SATURDAY, ProgramGenre.ENTRETENIMIENTO, presenter = "Ernesto Pimentel"),
        Program("am_s8", "america", "Cine Estelar Sabatino", "Películas destacadas para cerrar el sábado por la noche.", 22, 30, 0, 0, DayPattern.SATURDAY, ProgramGenre.CINE),

        // América TV - Domingo
        Program("am_d0", "america", "Cine y Series de Madrugada", "Producciones cinematográficas para el amanecer dominical.", 0, 0, 6, 0, DayPattern.SUNDAY, ProgramGenre.CINE),
        Program("am_d1", "america", "La Santa Misa", "Transmisión litúrgica dominical desde la Basílica Catedral de Lima.", 6, 0, 7, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("am_d2", "america", "Domingo al Día", "Reportajes en profundidad, historias humanas y balance de actualidad.", 7, 0, 9, 30, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),
        Program("am_d3", "america", "América Noticias: Dominical", "Resumen informativo y los titulares que marcan la agenda del domingo.", 9, 30, 11, 0, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),
        Program("am_d4", "america", "El Chavo del 8 Dominical", "Clásicos del humor blanco para la sobremesa dominical.", 11, 0, 13, 0, DayPattern.SUNDAY, ProgramGenre.INFANTIL),
        Program("am_d5", "america", "TEC", "Lo último en innovación, tecnología, gaming y teléfonos inteligentes.", 13, 0, 14, 30, DayPattern.SUNDAY, ProgramGenre.CULTURA, presenter = "Chiara Pinasco"),
        Program("am_d6", "america", "Cine Dominical de Estreno", "Películas destacadas para la tarde en familia.", 14, 30, 18, 30, DayPattern.SUNDAY, ProgramGenre.CINE),
        Program("am_d7", "america", "En Esta Cocina Mando Yo", "Competencia gastronómica y desafíos divertidos en pareja.", 18, 30, 20, 0, DayPattern.SUNDAY, ProgramGenre.ENTRETENIMIENTO, presenter = "Ethel Pozo"),
        Program("am_d8", "america", "Cuarto Poder", "El programa periodístico dominical más influyente del Perú con destapes políticos.", 20, 0, 22, 30, DayPattern.SUNDAY, ProgramGenre.OPINION, presenter = "Sol Carreño"),
        Program("am_d9", "america", "Fútbol en América", "Debate deportivo ardiente, goles de la fecha y polémicas del arbitraje.", 22, 30, 0, 0, DayPattern.SUNDAY, ProgramGenre.DEPORTES, presenter = "Erick Osores y Richard de la Piedra"),

        // ==========================================
        // 2. LATINA TELEVISIÓN (Canal 2)
        // ==========================================
        // Lunes a Viernes
        Program("lat_00", "latina", "Alerta Latina: Madrugada", "Investigaciones policiales y documentales de acción urbana.", 0, 0, 5, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("lat_01", "latina", "Latina Noticias: Al Despertar", "Primeras noticias de la jornada limeña y reporte vial.", 5, 0, 6, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("lat_02", "latina", "Latina Noticias: Matinal", "Noticiero matutino cercano con móviles en vivo en la capital.", 6, 0, 9, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Pedro Tenorio y Lorena Álvarez"),
        Program("lat_03", "latina", "Arriba Mi Gente", "Magazine con recetas, bienestar familiar y actualidad nacional.", 9, 0, 11, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE, presenter = "Maju Mantilla y Santi Lesmes"),
        Program("lat_04", "latina", "Latina Noticias: Mediodía", "Actualización informativa con las últimas noticias del día.", 11, 30, 13, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("lat_05", "latina", "El Gran Chef Famosos: El Menú", "Los mejores platos y momentos del exitoso reality de cocina.", 13, 0, 14, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.ENTRETENIMIENTO),
        Program("lat_06", "latina", "Telenovela: Traicionada", "Intensa historia dramática sobre deslealtad y justicia.", 14, 30, 16, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("lat_07", "latina", "Papá en Apuros", "Las divertidas peripecias de un capitán criando a sus hijos.", 16, 0, 17, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("lat_08", "latina", "Pituca Sin Lucas", "Comedia romántica nacional sobre una familia que empieza de cero.", 17, 30, 19, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("lat_09", "latina", "Latina Noticias: Central", "El noticiero principal de Latina con la información más rigurosa.", 19, 0, 20, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Mónica Delta"),
        Program("lat_10", "latina", "El Gran Chef Famosos", "Famosos en divertidos desafíos gastronómicos contrarreloj ante el jurado.", 20, 30, 22, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.ENTRETENIMIENTO, presenter = "José Peláez"),
        Program("lat_11", "latina", "Sobrevivientes / Series Estelares", "Ficción y adrenalina en la noche de Latina.", 22, 30, 23, 45, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("lat_12", "latina", "Latina Noticias: Noche", "Cierre de la jornada con el resumen informativo completo.", 23, 45, 0, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),

        // Latina - Sábado
        Program("lat_s0", "latina", "Cine Nocturno de Latina", "Películas de acción y suspenso.", 0, 0, 6, 0, DayPattern.SATURDAY, ProgramGenre.CINE),
        Program("lat_s1", "latina", "Latina Noticias: Sábado", "Toda la información del fin de semana.", 6, 0, 9, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("lat_s2", "latina", "Reporte Semanal: Matinal", "Anticipos de investigación periodística.", 9, 0, 11, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("lat_s3", "latina", "El Gran Chef Famosos: Revancha", "Momentos cumbres y recetas maestras.", 11, 0, 13, 0, DayPattern.SATURDAY, ProgramGenre.ENTRETENIMIENTO),
        Program("lat_s4", "latina", "Cine Familiar", "Cine infantil y juvenil para compartir en casa.", 13, 0, 16, 0, DayPattern.SATURDAY, ProgramGenre.CINE),
        Program("lat_s5", "latina", "Sábados en Familia", "Concursos familiares y juegos en pantalla.", 16, 0, 18, 30, DayPattern.SATURDAY, ProgramGenre.ENTRETENIMIENTO),
        Program("lat_s6", "latina", "Latina Noticias: Fin de Semana", "Noticias del día.", 18, 30, 20, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("lat_s7", "latina", "El Gran Chef Famosos: Noche de Eliminación", "Capítulo decisivo donde un participante deja la cocina.", 20, 0, 22, 30, DayPattern.SATURDAY, ProgramGenre.ENTRETENIMIENTO, presenter = "José Peláez"),
        Program("lat_s8", "latina", "Función Estelar de Cine", "Cine de acción de primer nivel.", 22, 30, 0, 0, DayPattern.SATURDAY, ProgramGenre.CINE),

        // Latina - Domingo
        Program("lat_d0", "latina", "La Gran Sangre / Madrugada", "Mítica serie de acción y aventuras urbanas.", 0, 0, 5, 0, DayPattern.SUNDAY, ProgramGenre.NOVELA),
        Program("lat_d1", "latina", "Latina Noticias: Amanecer Dominical", "Resumen de lo ocurrido el fin de semana.", 5, 0, 8, 30, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),
        Program("lat_d2", "latina", "Reporte Semanal", "Periodismo de profundidad, historias humanas y crónicas de actualidad.", 8, 30, 11, 0, DayPattern.SUNDAY, ProgramGenre.NOTICIAS, presenter = "Maritere Braschi"),
        Program("lat_d3", "latina", "Cine Familiar Dominical", "Películas clásicas para compartir.", 11, 0, 13, 0, DayPattern.SUNDAY, ProgramGenre.CINE),
        Program("lat_d4", "latina", "Latina Noticias: Mediodía Dominical", "El acontecer del mediodía en Lima y provincias.", 13, 0, 14, 0, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),
        Program("lat_d5", "latina", "Somos Vóley / Deportes Perú", "Transmisiones de la liga peruana de vóley femenino.", 14, 0, 16, 30, DayPattern.SUNDAY, ProgramGenre.DEPORTES),
        Program("lat_d6", "latina", "Función Estelar", "Película de estreno para la tarde.", 16, 30, 19, 0, DayPattern.SUNDAY, ProgramGenre.CINE),
        Program("lat_d7", "latina", "El Gran Chef: La Previa", "Entrevistas detrás del set del reality.", 19, 0, 20, 0, DayPattern.SUNDAY, ProgramGenre.ENTRETENIMIENTO),
        Program("lat_d8", "latina", "Punto Final", "Investigaciones periodísticas exclusivas y entrevistas políticas de fondo.", 20, 0, 22, 30, DayPattern.SUNDAY, ProgramGenre.OPINION, presenter = "Mónica Delta"),
        Program("lat_d9", "latina", "Sin Medias Tintas", "Entrevistas sin filtros a personalidades políticas.", 22, 30, 23, 45, DayPattern.SUNDAY, ProgramGenre.OPINION, presenter = "Christian Hudtwalcker"),
        Program("lat_d10", "latina", "Latina Noticias: Cierre", "Cierre informativo del domingo.", 23, 45, 0, 0, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),

        // ==========================================
        // 3. PANAMERICANA TELEVISIÓN (Canal 5)
        // ==========================================
        // Lunes a Viernes
        Program("pan_00", "panamericana", "Madrugada de Panamericana", "Los mejores recuerdos y series clásicas.", 0, 0, 5, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),
        Program("pan_01", "panamericana", "Buenos Días Perú: Regional", "Despachos descentralizados desde el interior del país.", 5, 30, 6, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("pan_02", "panamericana", "Buenos Días Perú", "El informativo matinal decano con primicias policiales y entrevistas.", 6, 0, 9, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Pamela Acosta y Claudia Chiroque"),
        Program("pan_03", "panamericana", "Vida Sana y Telebrands", "Espacio de salud natural y bienestar.", 9, 30, 10, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),
        Program("pan_04", "panamericana", "Préndete", "Magazine de mediodía con farándula, entretenimiento y cocina.", 10, 30, 12, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE, presenter = "Karla Tarazona y Christian Domínguez"),
        Program("pan_05", "panamericana", "24 Horas: Edición Mediodía", "El reporte informativo al detalle con enlaces en directo.", 12, 0, 13, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("pan_06", "panamericana", "La Calle No Calla", "Periodismo ciudadano atendiendo denuncias comunitarias.", 13, 30, 15, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("pan_07", "panamericana", "La Hija del Mariachi", "La entrañable historia de amor que cautivó Latinoamérica.", 15, 0, 16, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("pan_08", "panamericana", "Ana de Nadie", "Dramática telenovela sobre segundas oportunidades.", 16, 30, 18, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("pan_09", "panamericana", "La Familia Ingalls", "El gran clásico de la pradera con Charles y Laura Ingalls.", 18, 0, 19, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("pan_10", "panamericana", "24 Horas: Edición Central", "El noticiero insignia e histórico de Panamericana TV.", 19, 30, 20, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Marisol García"),
        Program("pan_11", "panamericana", "El Señor de los Cielos", "Superproducción dramática nocturna.", 20, 30, 21, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("pan_12", "panamericana", "Esta Noche con Panamericana", "Entrevistas exclusivas a figuras políticas y artistas.", 21, 30, 22, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION),
        Program("pan_13", "panamericana", "Policías de Chicago (Chicago P.D.)", "Acción policial en la unidad de inteligencia contra el crimen.", 22, 30, 23, 45, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.CINE),
        Program("pan_14", "panamericana", "24 Horas: Edición Noche", "Último repaso a las noticias de la jornada.", 23, 45, 0, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),

        // Panamericana - Sábado
        Program("pan_s0", "panamericana", "Cine de Madrugada Panamericana", "Películas clásicas de acción.", 0, 0, 6, 0, DayPattern.SATURDAY, ProgramGenre.CINE),
        Program("pan_s1", "panamericana", "Buenos Días Perú: Sábado", "Noticias de fin de semana.", 6, 0, 9, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("pan_s2", "panamericana", "Telebrands y Salud", "Espacio de salud y hogar.", 9, 0, 10, 30, DayPattern.SATURDAY, ProgramGenre.MAGAZINE),
        Program("pan_s3", "panamericana", "La Panadería / Entretenimiento", "Humor y variedades de la televisión.", 10, 30, 12, 0, DayPattern.SATURDAY, ProgramGenre.ENTRETENIMIENTO),
        Program("pan_s4", "panamericana", "24 Horas: Sabatino", "Información del mediodía.", 12, 0, 13, 30, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("pan_s5", "panamericana", "Cine en Familia", "Cine de aventuras para toda la familia.", 13, 30, 16, 30, DayPattern.SATURDAY, ProgramGenre.CINE),
        Program("pan_s6", "panamericana", "Especial de Series Clásicas", "Recuerdos de la época dorada televisiva.", 16, 30, 19, 30, DayPattern.SATURDAY, ProgramGenre.NOVELA),
        Program("pan_s7", "panamericana", "24 Horas: Sábado Noche", "Resumen informativo sabatino.", 19, 30, 21, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("pan_s8", "panamericana", "Noche de Acción Panamericana", "Películas de artes marciales y policiales.", 21, 0, 23, 0, DayPattern.SATURDAY, ProgramGenre.CINE),
        Program("pan_s9", "panamericana", "Al Sexto Día", "Crónicas urbanas, reportajes de la calle limeña y perfiles humanos.", 23, 0, 0, 0, DayPattern.SATURDAY, ProgramGenre.MAGAZINE, presenter = "Laura Spoya"),

        // Panamericana - Domingo
        Program("pan_d0", "panamericana", "Madrugada de Panamericana", "Música del recuerdo y series retro.", 0, 0, 5, 30, DayPattern.SUNDAY, ProgramGenre.MAGAZINE),
        Program("pan_d1", "panamericana", "Encantos del Perú", "Folclore y danzas tradicionales de nuestro país.", 5, 30, 8, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("pan_d2", "panamericana", "En Forma y Vida Sana", "Ejercicios y hábitos saludables para el domingo.", 8, 0, 10, 0, DayPattern.SUNDAY, ProgramGenre.MAGAZINE),
        Program("pan_d3", "panamericana", "La Cajita Musical", "Música infantil y talentos jóvenes.", 10, 0, 11, 0, DayPattern.SUNDAY, ProgramGenre.INFANTIL),
        Program("pan_d4", "panamericana", "Patrimonio Mundial y Visión Futuro", "Documentales sobre maravillas peruanas.", 11, 0, 12, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("pan_d5", "panamericana", "¡Escápate! Turismo y Gastronomía", "Viajes por los valles del Perú.", 12, 0, 14, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("pan_d6", "panamericana", "Cine de Acción Dominical", "Películas de aventura y suspenso.", 14, 0, 19, 30, DayPattern.SUNDAY, ProgramGenre.CINE),
        Program("pan_d7", "panamericana", "24 Horas: Edición Dominical", "Noticias del día.", 19, 30, 20, 0, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),
        Program("pan_d8", "panamericana", "Panorama", "El programa pionero en destapes políticos y denuncias de corrupción.", 20, 0, 22, 30, DayPattern.SUNDAY, ProgramGenre.OPINION, presenter = "Carla Muschi"),
        Program("pan_d9", "panamericana", "El Dominical de Panamericana", "Crónicas urbanas y perfiles insólitos del Perú.", 22, 30, 23, 45, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),
        Program("pan_d10", "panamericana", "Cierre Dominical", "Resumen de medianoche.", 23, 45, 0, 0, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),

        // ==========================================
        // 4. ATV (Canal 9)
        // ==========================================
        // Lunes a Viernes
        Program("atv_00", "atv", "Series de Madrugada (The Walking Dead)", "Series de suspenso y terror internacional.", 0, 0, 5, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.CINE),
        Program("atv_01", "atv", "ATV Noticias: Amanecer", "Primer contacto noticioso del día con móviles en las calles.", 5, 30, 6, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("atv_02", "atv", "ATV Noticias: Edición Matinal", "Noticiero matutino con despachos ciudadanos en vivo.", 6, 0, 9, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Fernando Díaz y Alicia Retto"),
        Program("atv_03", "atv", "Así de Simple", "Espacio dinámico de actualidad, consejos prácticos y debate matinal.", 9, 0, 10, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),
        Program("atv_04", "atv", "Telenovela: Amor Eterno", "Gran producción de drama y romance.", 10, 30, 12, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("atv_05", "atv", "ATV Noticias: Al Día", "Resumen de las noticias más destacadas de la mañana.", 12, 0, 13, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("atv_06", "atv", "Telenovela: Ana Cristina", "Producción nacional de pasión y secretos familiares.", 13, 0, 14, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("atv_07", "atv", "Andrea", "Talk show social donde se confrontan conflictos familiares y pruebas de ADN.", 14, 30, 16, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.ENTRETENIMIENTO, presenter = "Andrea Llosa"),
        Program("atv_08", "atv", "Lo que Callamos las Mujeres", "Historias de lucha femenina y justicia ante adversidades.", 16, 0, 17, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("atv_09", "atv", "La Mujer en el Espejo", "Telenovela clásica de romance e intrigas.", 17, 30, 19, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("atv_10", "atv", "ATV Noticias: Edición Central", "El noticiero principal de la noche en ATV.", 19, 0, 20, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Drusila Zileri"),
        Program("atv_11", "atv", "Magaly TV: La Firme", "El programa de espectáculos más visto con los ampays más comentados.", 20, 30, 21, 45, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.ENTRETENIMIENTO, presenter = "Magaly Medina"),
        Program("atv_12", "atv", "ATV Deportes", "Las mejores jugadas y la actualidad de la selección.", 21, 45, 23, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.DEPORTES),
        Program("atv_13", "atv", "El Deportivo en Otra Cancha", "Entrevistas relajadas, anécdotas y fútbol nocturno.", 23, 0, 0, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.DEPORTES, presenter = "Paco Bazán"),

        // ATV - Sábado
        Program("atv_s0", "atv", "Cine Nocturno ATV", "Películas de suspenso en la madrugada.", 0, 0, 6, 30, DayPattern.SATURDAY, ProgramGenre.CINE),
        Program("atv_s1", "atv", "Canto Andino", "La fiesta de la música andina peruana con artistas de todo el país.", 6, 30, 8, 0, DayPattern.SATURDAY, ProgramGenre.CULTURA, presenter = "Isaac Sarmiento"),
        Program("atv_s2", "atv", "Tom y Jerry & Looney Tunes", "Dibujos animados clásicos para despertar con alegría.", 8, 0, 11, 30, DayPattern.SATURDAY, ProgramGenre.INFANTIL),
        Program("atv_s3", "atv", "Los Picapiedra", "Comedia animada de la prehistoria.", 11, 30, 13, 0, DayPattern.SATURDAY, ProgramGenre.INFANTIL),
        Program("atv_s4", "atv", "Cine ATV Sábado Familiar", "Películas cómicas para toda la familia.", 13, 0, 16, 0, DayPattern.SATURDAY, ProgramGenre.CINE),
        Program("atv_s5", "atv", "Función Estelar de Aventuras", "Películas de acción de primer nivel.", 16, 0, 19, 0, DayPattern.SATURDAY, ProgramGenre.CINE),
        Program("atv_s6", "atv", "ATV Noticias: Fin de Semana", "Noticias del día.", 19, 0, 20, 30, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("atv_s7", "atv", "JB en ATV", "El programa cómico más divertido del Perú con sketches y parodias políticas.", 20, 30, 22, 30, DayPattern.SATURDAY, ProgramGenre.ENTRETENIMIENTO, presenter = "Jorge Benavides"),
        Program("atv_s8", "atv", "Cine ATV Impacto", "Cine de medianoche.", 22, 30, 0, 0, DayPattern.SATURDAY, ProgramGenre.CINE),

        // ATV - Domingo
        Program("atv_d0", "atv", "Madrugada de Películas", "Cine de trasnoche dominical.", 0, 0, 6, 30, DayPattern.SUNDAY, ProgramGenre.CINE),
        Program("atv_d1", "atv", "Canto Andino Dominical", "Danzas tradicionales peruanas.", 6, 30, 8, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("atv_d2", "atv", "Clásicos Animados", "Dibujos animados infantiles.", 8, 0, 11, 0, DayPattern.SUNDAY, ProgramGenre.INFANTIL),
        Program("atv_d3", "atv", "Cine de Comedia", "Películas divertidas para el mediodía.", 11, 0, 13, 0, DayPattern.SUNDAY, ProgramGenre.CINE),
        Program("atv_d4", "atv", "Lucha Libre TNA / WWE", "Emocionantes combates en el cuadrilátero.", 13, 0, 15, 0, DayPattern.SUNDAY, ProgramGenre.DEPORTES),
        Program("atv_d5", "atv", "Cine ATV Premier", "Películas de Hollywood taquilleras.", 15, 0, 20, 0, DayPattern.SUNDAY, ProgramGenre.CINE),
        Program("atv_d6", "atv", "Día D", "Reportajes en profundidad, crónicas policiales y destapes dominicales.", 20, 0, 22, 0, DayPattern.SUNDAY, ProgramGenre.OPINION, presenter = "Pamela Vértiz"),
        Program("atv_d7", "atv", "Nunca Más", "Casos conmovedores de injusticia familiar para buscar soluciones reales.", 22, 0, 23, 0, DayPattern.SUNDAY, ProgramGenre.OPINION, presenter = "Andrea Llosa"),
        Program("atv_d8", "atv", "El Deportivo Dominical", "Resumen de la fecha de fútbol nacional e internacional.", 23, 0, 0, 0, DayPattern.SUNDAY, ProgramGenre.DEPORTES),

        // ==========================================
        // 5. WILLAX TELEVISIÓN (Canal 31)
        // ==========================================
        // Lunes a Viernes
        Program("wlx_00", "willax", "Repeticiones y Noche Informativa", "Lo más destacado del día político.", 0, 0, 6, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("wlx_01", "willax", "Al Día con Willax Nacional", "Primeras informaciones políticas de la mañana.", 6, 0, 7, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("wlx_02", "willax", "Al Día con Willax", "Entrevistas en vivo y actualidad nacional.", 7, 0, 9, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("wlx_03", "willax", "Entrometidos", "Comentarios de farándula con estilo directo.", 9, 0, 11, 25, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.ENTRETENIMIENTO, presenter = "Carlos Cacho"),
        Program("wlx_04", "willax", "Willax Noticias: Mediodía", "Actualización informativa de la mañana.", 11, 25, 12, 50, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("wlx_05", "willax", "Telenovela: Amor Prohibido", "Dramática teleserie de pasiones encontradas.", 12, 50, 14, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOVELA),
        Program("wlx_06", "willax", "Amor y Fuego", "El show de las tardes con destapes de farándula y primicias.", 14, 30, 17, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.ENTRETENIMIENTO, presenter = "Rodrigo González Peluchín y Gigi Mitre"),
        Program("wlx_07", "willax", "Un Día en el Mall", "Moda, compras y tendencias limeñas.", 17, 0, 18, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),
        Program("wlx_08", "willax", "Caso Cerrado", "Casos legales insólitos mediados en corte.", 18, 0, 19, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.ENTRETENIMIENTO, presenter = "Dra. Ana María Polo"),
        Program("wlx_09", "willax", "Willax Noticias: Central", "El bloque estelar de informaciones.", 19, 0, 19, 55, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("wlx_10", "willax", "Contra Corriente", "Investigaciones periodísticas exclusivas y destapes políticos de alto impacto.", 19, 55, 20, 55, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION, presenter = "Augusto Thorndike"),
        Program("wlx_11", "willax", "Beto A Saber", "Periodismo de opinión crítico y sin concesiones.", 20, 55, 22, 15, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION, presenter = "Beto Ortiz"),
        Program("wlx_12", "willax", "Ahora y En la Hora", "Entrevistas punzantes y análisis político de la coyuntura.", 22, 15, 23, 15, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION, presenter = "Milagros Leiva"),
        Program("wlx_13", "willax", "Crónicas de Impacto", "Reportajes insólitos del Perú nocturno.", 23, 15, 0, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),

        // Willax - Sábado
        Program("wlx_s0", "willax", "Madrugada de Series y Crónicas", "Investigaciones periodísticas de medianoche.", 0, 0, 6, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("wlx_s1", "willax", "Willax Noticias: Sábado", "Noticias del fin de semana.", 6, 0, 9, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("wlx_s2", "willax", "Lo Mejor de Amor y Fuego", "Los momentos más divertidos de la semana.", 9, 0, 11, 0, DayPattern.SATURDAY, ProgramGenre.ENTRETENIMIENTO),
        Program("wlx_s3", "willax", "Cine Willax Sábado", "Películas de acción.", 11, 0, 14, 0, DayPattern.SATURDAY, ProgramGenre.CINE),
        Program("wlx_s4", "willax", "Maratón Caso Cerrado", "Casos insólitos ante la Dra. Polo.", 14, 0, 17, 0, DayPattern.SATURDAY, ProgramGenre.ENTRETENIMIENTO),
        Program("wlx_s5", "willax", "Hechos en Willax", "Reportajes de fondo y entrevistas políticas.", 17, 0, 19, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("wlx_s6", "willax", "Willax Noticias: Sábado Noche", "Resumen informativo.", 19, 0, 20, 30, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("wlx_s7", "willax", "Polémicas y Debate Especial", "Análisis con panelistas de opinión.", 20, 30, 22, 30, DayPattern.SATURDAY, ProgramGenre.OPINION),
        Program("wlx_s8", "willax", "Willax Deportes Sabatino", "Toda la jornada futbolística.", 22, 30, 0, 0, DayPattern.SATURDAY, ProgramGenre.DEPORTES),

        // Willax - Domingo
        Program("wlx_d0", "willax", "Trasnoche Willax", "Crónicas y reportajes.", 0, 0, 6, 0, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),
        Program("wlx_d1", "willax", "Hechos en Willax: Matinal", "Reportajes especiales de investigación.", 6, 0, 9, 0, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),
        Program("wlx_d2", "willax", "Once Machos", "Tertulia deportiva y anécdotas entre amigos.", 9, 0, 11, 0, DayPattern.SUNDAY, ProgramGenre.ENTRETENIMIENTO),
        Program("wlx_d3", "willax", "Cine Willax Dominical", "Películas para disfrutar el domingo.", 11, 0, 16, 0, DayPattern.SUNDAY, ProgramGenre.CINE),
        Program("wlx_d4", "willax", "Caso Cerrado: Especial", "Los casos más comentados de la corte.", 16, 0, 18, 0, DayPattern.SUNDAY, ProgramGenre.ENTRETENIMIENTO),
        Program("wlx_d5", "willax", "Contra Corriente Dominical", "Destapes políticos de última hora.", 18, 0, 20, 30, DayPattern.SUNDAY, ProgramGenre.OPINION, presenter = "Augusto Thorndike"),
        Program("wlx_d6", "willax", "Rey con Barba", "Comentarios de coyuntura y debate frontal.", 20, 30, 21, 30, DayPattern.SUNDAY, ProgramGenre.OPINION),
        Program("wlx_d7", "willax", "Willax Deportes", "Análisis futbolístico contundente.", 21, 30, 22, 30, DayPattern.SUNDAY, ProgramGenre.DEPORTES, presenter = "Eddie Fleischman"),
        Program("wlx_d8", "willax", "Noche de Luna", "Entrevistas íntimas con personajes ilustres.", 22, 30, 0, 0, DayPattern.SUNDAY, ProgramGenre.OPINION),

        // ==========================================
        // 6. TV PERÚ (Canal 7 - IRTP)
        // ==========================================
        // Lunes a Viernes
        Program("tvp_00", "tvperu", "Presencia Cultural / Repetición Especial", "Literatura, memoria y arte del Perú.", 0, 0, 5, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.CULTURA),
        Program("tvp_01", "tvperu", "Jiwasanaka", "El noticiero televisivo en lengua aimara en el Perú.", 5, 0, 5, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("tvp_02", "tvperu", "Ñuqanchik", "El noticiero matutino en lengua quechua para todo el Perú.", 5, 30, 6, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("tvp_03", "tvperu", "TV Perú Noticias: Matinal", "Noticias descentralizadas al servicio de los ciudadanos.", 6, 0, 8, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Jennifer Cerecida y Julio Navarro"),
        Program("tvp_04", "tvperu", "Qué Está Pasando", "Noticiero con denuncias vecinales en vivo desde las 25 regiones.", 8, 30, 9, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("tvp_05", "tvperu", "Con Sabor a Perú", "Recetas tradicionales de la gastronomía nacional.", 9, 30, 10, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.CULTURA, presenter = "Israel Laura"),
        Program("tvp_06", "tvperu", "Más Conectados", "Magazine enfocado en salud, bienestar y economía familiar.", 10, 30, 12, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),
        Program("tvp_07", "tvperu", "Cuerpo Médico", "Especialistas resuelven consultas médicas en vivo.", 12, 0, 13, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),
        Program("tvp_08", "tvperu", "TV Perú Noticias: Mediodía", "Balance nacional de la información oficial.", 13, 0, 14, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("tvp_09", "tvperu", "Costumbres", "Recorrido por las festividades patronales y danzas del Perú.", 14, 0, 15, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.CULTURA, presenter = "Sonaly Tuesta"),
        Program("tvp_10", "tvperu", "Reportaje al Perú", "Rutas turísticas por los rincones más impresionantes.", 15, 0, 16, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.CULTURA, presenter = "Manolo del Castillo"),
        Program("tvp_11", "tvperu", "Chicos IPe en TV Perú", "Series animadas e historias entretenidas para niños.", 16, 0, 17, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.INFANTIL),
        Program("tvp_12", "tvperu", "Te Veo a las 5", "Espacio cultural y de entretenimiento para toda la familia.", 17, 0, 18, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),
        Program("tvp_13", "tvperu", "GeoMundo", "Análisis riguroso de las relaciones internacionales y geopolítica.", 18, 0, 19, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION, presenter = "Farid Kahhat"),
        Program("tvp_14", "tvperu", "TV Perú Noticias: Edición Central", "El balance informativo oficial más completo del país.", 19, 0, 20, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Fátima Saldonid"),
        Program("tvp_15", "tvperu", "Sucedió en el Perú", "Documentales sobre hitos y batallas históricas de la peruanidad.", 20, 0, 21, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.CULTURA, presenter = "Paul Vega"),
        Program("tvp_16", "tvperu", "En Pared", "Mesa de análisis político y debate con panelistas.", 21, 0, 22, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION),
        Program("tvp_17", "tvperu", "El Placer de los Ojos", "El programa de cine más prestigioso de la televisión peruana.", 22, 0, 23, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.CINE, presenter = "Ricardo Bedoya"),
        Program("tvp_18", "tvperu", "Noche de Arte y Cultura", "Transmisiones desde el Gran Teatro Nacional.", 23, 0, 0, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.CULTURA),

        // TV Perú - Sábado
        Program("tvp_s0", "tvperu", "Archivo Cultural de TV Perú", "Documentales sobre el patrimonio peruano.", 0, 0, 6, 0, DayPattern.SATURDAY, ProgramGenre.CULTURA),
        Program("tvp_s1", "tvperu", "La Voz de la Tierra", "Saberes ancestrales y agricultura peruana.", 6, 0, 7, 0, DayPattern.SATURDAY, ProgramGenre.CULTURA),
        Program("tvp_s2", "tvperu", "Primera Hora Noticias Sábado", "Primeras noticias de fin de semana.", 7, 0, 9, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("tvp_s3", "tvperu", "Tradiciones del Perú", "Crónicas vivas de nuestras comunidades.", 9, 0, 10, 30, DayPattern.SATURDAY, ProgramGenre.CULTURA),
        Program("tvp_s4", "tvperu", "Museos Puertas Abiertas", "Exploración de los tesoros arqueológicos peruanos.", 10, 30, 12, 0, DayPattern.SATURDAY, ProgramGenre.CULTURA),
        Program("tvp_s5", "tvperu", "Sabor y Música Peruana", "Gastronomía criolla y acordes criollos.", 12, 0, 14, 0, DayPattern.SATURDAY, ProgramGenre.CULTURA),
        Program("tvp_s6", "tvperu", "Sábados de Folclore", "Danzas originarias del norte, centro y sur.", 14, 0, 17, 0, DayPattern.SATURDAY, ProgramGenre.CULTURA),
        Program("tvp_s7", "tvperu", "Reportaje al Perú: Especial", "Aventuras por la selva y la sierra.", 17, 0, 19, 0, DayPattern.SATURDAY, ProgramGenre.CULTURA, presenter = "Manolo del Castillo"),
        Program("tvp_s8", "tvperu", "TV Perú Noticias: Fin de Semana", "Noticias del día.", 19, 0, 20, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("tvp_s9", "tvperu", "Conciertos Sinfónicos Nacionales", "La Orquesta Sinfónica Nacional en concierto.", 20, 0, 22, 0, DayPattern.SATURDAY, ProgramGenre.CULTURA),
        Program("tvp_s10", "tvperu", "Danzas y Tradición", "Música de nuestras regiones.", 22, 0, 0, 0, DayPattern.SATURDAY, ProgramGenre.CULTURA),

        // TV Perú - Domingo
        Program("tvp_d0", "tvperu", "Madrugada Cultural del Perú", "Música instrumental andina y criolla.", 0, 0, 6, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("tvp_d1", "tvperu", "La Santa Misa", "Transmisión eucarística dominical.", 6, 0, 7, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("tvp_d2", "tvperu", "TV Perú Noticias: Domingo", "Titulares del día y enlace nacional.", 7, 0, 9, 0, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),
        Program("tvp_d3", "tvperu", "A Cuatro Tiempos", "Música sinfónica y compositores peruanos.", 9, 0, 10, 30, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("tvp_d4", "tvperu", "Perú Afro", "Cultura, cajón, décimas y tradiciones afroperuanas.", 10, 30, 12, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("tvp_d5", "tvperu", "Mediodía Criollo", "Homenaje a la jarana y la música de la costa.", 12, 0, 13, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("tvp_d6", "tvperu", "Sabores y Rincones", "La cocina regional del Perú.", 13, 0, 14, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("tvp_d7", "tvperu", "Domingos de Fiesta", "El show musical que lleva cumbia y folclore a los barrios.", 14, 0, 16, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA, presenter = "María Jesús Rodríguez"),
        Program("tvp_d8", "tvperu", "Costumbres: Especial", "Fiestas tradicionales de los pueblos.", 16, 0, 17, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("tvp_d9", "tvperu", "Reportaje al Perú: Rutas", "Las mejores expediciones turísticas.", 17, 0, 18, 30, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("tvp_d10", "tvperu", "Documentales Bicentenario", "La historia de la República.", 18, 30, 20, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("tvp_d11", "tvperu", "Goles en Acción", "Resumen deportivo y goles del fútbol nacional.", 20, 0, 22, 0, DayPattern.SUNDAY, ProgramGenre.DEPORTES, presenter = "Alberto Beingolea"),
        Program("tvp_d12", "tvperu", "Presencia Cultural Dominical", "Literatura y teatro peruano.", 22, 0, 0, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),

        // ==========================================
        // 7. TV PERÚ NOTICIAS (Canal 7.3) - Continuo 24/7
        // ==========================================
        Program("tpn_00", "tvperunoticias", "Guardia Informativa Nocturna", "Monitoreo de noticias en directo durante la madrugada.", 0, 0, 6, 0, DayPattern.DAILY, ProgramGenre.NOTICIAS),
        Program("tpn_01", "tvperunoticias", "TV Perú Noticias: Amanecer", "Primer balance de noticias nacionales y clima.", 6, 0, 9, 0, DayPattern.DAILY, ProgramGenre.NOTICIAS),
        Program("tpn_02", "tvperunoticias", "Enlace Nacional y Despachos", "Despachos en vivo desde los 24 departamentos.", 9, 0, 12, 0, DayPattern.DAILY, ProgramGenre.NOTICIAS),
        Program("tpn_03", "tvperunoticias", "Edición Mediodía Perú", "Actualidad política y conferencias de prensa oficiales.", 12, 0, 14, 0, DayPattern.DAILY, ProgramGenre.NOTICIAS),
        Program("tpn_04", "tvperunoticias", "Panorama Regional en Directo", "Cobertura de problemáticas regionales y desarrollo.", 14, 0, 17, 0, DayPattern.DAILY, ProgramGenre.NOTICIAS),
        Program("tpn_05", "tvperunoticias", "Minuto a Minuto: Edición Tarde", "La noticia conforme se produce con analistas.", 17, 0, 19, 0, DayPattern.DAILY, ProgramGenre.NOTICIAS),
        Program("tpn_06", "tvperunoticias", "TV Perú Noticias: Edición Central", "El noticiero estelar del Estado con entrevistas clave.", 19, 0, 21, 0, DayPattern.DAILY, ProgramGenre.NOTICIAS),
        Program("tpn_07", "tvperunoticias", "Debate y Análisis en Vivo", "Mesa redonda con especialistas sobre las leyes y actualidad.", 21, 0, 23, 0, DayPattern.DAILY, ProgramGenre.OPINION),
        Program("tpn_08", "tvperunoticias", "Síntesis Informativa del Día", "Resumen de los hechos más trascendentes.", 23, 0, 0, 0, DayPattern.DAILY, ProgramGenre.NOTICIAS),

        // ==========================================
        // 8. CANAL IPE (Canal 7.4) - Continuo 24/7
        // ==========================================
        Program("ipe_00", "canalipe", "Noche Cultural IPe", "Animación independiente y documentales juveniles.", 0, 0, 6, 0, DayPattern.DAILY, ProgramGenre.INFANTIL),
        Program("ipe_01", "canalipe", "Bailemos con Martina & Ciudad Jardín", "Música, psicomotricidad y medio ambiente infantil.", 6, 0, 8, 0, DayPattern.DAILY, ProgramGenre.INFANTIL),
        Program("ipe_02", "canalipe", "Chicos IPe: Cuentos de Chaski", "Narraciones orales y mitos peruanos animados.", 8, 0, 10, 0, DayPattern.DAILY, ProgramGenre.INFANTIL),
        Program("ipe_03", "canalipe", "Viajeros del Tiempo & Papel", "Fomentando la lectura y la imaginación en los niños.", 10, 0, 12, 0, DayPattern.DAILY, ProgramGenre.INFANTIL),
        Program("ipe_04", "canalipe", "Laberinto de Aventuras", "Juegos de ingenio, adivinanzas y retos para niños.", 12, 0, 14, 0, DayPattern.DAILY, ProgramGenre.INFANTIL),
        Program("ipe_05", "canalipe", "Ciencia en Casa & Robótica", "Experimentos sencillos y tecnología para jóvenes mentes curiosas.", 14, 0, 16, 0, DayPattern.DAILY, ProgramGenre.INFANTIL),
        Program("ipe_06", "canalipe", "Zona de Reto & Chicos IPe", "Programas de destreza y trabajo en equipo.", 16, 0, 18, 0, DayPattern.DAILY, ProgramGenre.INFANTIL),
        Program("ipe_07", "canalipe", "Música y Creadores Peruanos", "Jóvenes talentos en artes visuales y música.", 18, 0, 20, 0, DayPattern.DAILY, ProgramGenre.CULTURA),
        Program("ipe_08", "canalipe", "Documentales de Flora y Fauna del Perú", "Biodiversidad de la Amazonía y los Andes.", 20, 0, 22, 0, DayPattern.DAILY, ProgramGenre.CULTURA),
        Program("ipe_09", "canalipe", "Cortos y Cine Juvenil", "Muestras del cine peruano juvenil.", 22, 0, 0, 0, DayPattern.DAILY, ProgramGenre.CINE),

        // ==========================================
        // 9. EXITOSA TV (Canal 6.1)
        // ==========================================
        // Lunes a Viernes
        Program("exi_00", "exitosa", "Madrugada de Exitosa", "Noticias y llamadas del pueblo con trabajadores nocturnos.", 0, 0, 6, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("exi_01", "exitosa", "Exitosa Perú", "La voz de los pueblos en vivo, reclamos vecinales y debate sin filtros.", 6, 0, 10, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION, presenter = "Nicolás Lúcar"),
        Program("exi_02", "exitosa", "En Defensa de la Verdad", "Análisis implacable de la coyuntura del país.", 10, 0, 12, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION, presenter = "Manuel Rosas"),
        Program("exi_03", "exitosa", "Informamos y Opinamos", "La actualidad del mediodía con denuncias de los ciudadanos.", 12, 0, 15, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Karina Novoa"),
        Program("exi_04", "exitosa", "Exitosa Deportes", "Debate futbolero caliente sobre la Selección y la Liga 1.", 15, 0, 17, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.DEPORTES, presenter = "Gonzalo Núñez y equipo"),
        Program("exi_05", "exitosa", "Exitosa Te Escucha", "Llamadas del público desde todo el Perú atendiendo problemas sociales.", 17, 0, 20, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION, presenter = "Katyusca Torres Aybar"),
        Program("exi_06", "exitosa", "La Voz de los Pueblos", "Resumen de las luchas sociales en provincias y debate en vivo.", 20, 0, 23, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION),
        Program("exi_07", "exitosa", "Cierre Informativo Exitosa", "Últimas noticias de la noche.", 23, 0, 0, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),

        // Exitosa - Sábado
        Program("exi_s0", "exitosa", "Madrugada de Exitosa Sábado", "Noticias y testimonios ciudadanos.", 0, 0, 6, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("exi_s1", "exitosa", "Exitosa Sábado", "El acontecer nacional con despachos descentralizados.", 6, 0, 10, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS, presenter = "Pedro Paredes"),
        Program("exi_s2", "exitosa", "La Voz del Pueblo Sabatina", "Consultas y quejas ciudadanas al aire.", 10, 0, 13, 0, DayPattern.SATURDAY, ProgramGenre.OPINION),
        Program("exi_s3", "exitosa", "Exitosa Deportes Especial Sabatino", "Toda la previa de la fecha de fútbol.", 13, 0, 15, 0, DayPattern.SATURDAY, ProgramGenre.DEPORTES),
        Program("exi_s4", "exitosa", "Enlace Regional Exitosa", "Informes desde Arequipa, Trujillo, Cusco, Piura e Iquitos.", 15, 0, 18, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("exi_s5", "exitosa", "La Hora de la Verdad", "Entrevistas políticas de fin de semana.", 18, 0, 21, 0, DayPattern.SATURDAY, ProgramGenre.OPINION),
        Program("exi_s6", "exitosa", "Noche Caliente en Exitosa", "Debate abierto con el público peruano.", 21, 0, 0, 0, DayPattern.SATURDAY, ProgramGenre.OPINION),

        // Exitosa - Domingo
        Program("exi_d0", "exitosa", "Madrugada de Exitosa Domingo", "Espacio de participación ciudadana.", 0, 0, 6, 0, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),
        Program("exi_d1", "exitosa", "Exitosa Domingo Matinal", "Las primeras noticias del día de descanso.", 6, 0, 9, 0, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),
        Program("exi_d2", "exitosa", "Los Desayunos de Exitosa", "Análisis con economistas y especialistas.", 9, 0, 12, 0, DayPattern.SUNDAY, ProgramGenre.OPINION),
        Program("exi_d3", "exitosa", "Hablemos Claro Dominical", "Entrevistas directas sobre la política nacional.", 12, 0, 15, 0, DayPattern.SUNDAY, ProgramGenre.OPINION, presenter = "Nicolás Lúcar"),
        Program("exi_d4", "exitosa", "Marcador Deportivo Exitosa", "Transmisión en directo de los partidos de la fecha.", 15, 0, 18, 0, DayPattern.SUNDAY, ProgramGenre.DEPORTES),
        Program("exi_d5", "exitosa", "Panorama Político Exitosa", "El balance de la semana con los personajes centrales.", 18, 0, 21, 0, DayPattern.SUNDAY, ProgramGenre.OPINION),
        Program("exi_d6", "exitosa", "Resumen Semanal de Denuncias", "Seguimiento a los pedidos de la población.", 21, 0, 0, 0, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),

        // ==========================================
        // 10. RPP TV (Canal 10.1)
        // ==========================================
        // Lunes a Viernes
        Program("rpp_00", "rpptv", "Resumen RPP Noticias: Madrugada", "Las noticias más importantes de la noche con actualización permanente.", 0, 0, 6, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("rpp_01", "rpptv", "La Rotativa del Aire: Matinal", "La mayor cadena informativa del Perú transmitiendo en directo.", 6, 0, 10, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("rpp_02", "rpptv", "Encendidos", "Espacio dedicado a la salud, familia y consejos para la vida cotidiana.", 10, 0, 12, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),
        Program("rpp_03", "rpptv", "Siempre en Casa", "Orientación al consumidor y nutrición saludable.", 12, 0, 13, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.MAGAZINE),
        Program("rpp_04", "rpptv", "La Rotativa del Aire: Mediodía", "El balance nacional de la noticia al momento con corresponsales.", 13, 0, 14, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("rpp_05", "rpptv", "Conexión", "El pulso del país con entrevistas a ministros y autoridades.", 14, 30, 17, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS, presenter = "Jorge Rodríguez"),
        Program("rpp_06", "rpptv", "Las Claves del Día", "Resumen analítico de los temas prioritarios de la tarde.", 17, 0, 19, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("rpp_07", "rpptv", "Las Cosas Como Son", "Editorial y análisis político con perspectiva histórica.", 19, 0, 20, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION, presenter = "Fernando Carvallo"),
        Program("rpp_08", "rpptv", "Nada Está Dicho", "Entrevistas centrales a los protagonistas de la jornada.", 20, 0, 21, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION, presenter = "Jaime Chincha"),
        Program("rpp_09", "rpptv", "Fútbol como Cancha", "Toda la actualidad del fútbol nacional y las copas internacionales.", 21, 0, 22, 30, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.DEPORTES),
        Program("rpp_10", "rpptv", "RPP Noticias: Noche", "Las principales noticias para cerrar el día con credibilidad.", 22, 30, 0, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),

        // RPP TV - Sábado
        Program("rpp_s0", "rpptv", "Trasnoche Informativo RPP", "Información continua y reportajes especiales.", 0, 0, 6, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("rpp_s1", "rpptv", "La Rotativa del Aire: Sábado", "El informativo de fin de semana con despachos regionales.", 6, 0, 9, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("rpp_s2", "rpptv", "Diálogo Abierto", "Entrevistas a especialistas sobre temas de interés ciudadano.", 9, 0, 11, 0, DayPattern.SATURDAY, ProgramGenre.OPINION),
        Program("rpp_s3", "rpptv", "Enfoque de los Sábados", "Mesa redonda sobre la economía y la política nacional.", 11, 0, 13, 0, DayPattern.SATURDAY, ProgramGenre.OPINION),
        Program("rpp_s4", "rpptv", "La Rotativa del Aire: Mediodía", "Actualización informativa del sábado.", 13, 0, 14, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("rpp_s5", "rpptv", "Espacio Vital", "Salud, prevención de enfermedades y avances médicos.", 14, 0, 16, 0, DayPattern.SATURDAY, ProgramGenre.MAGAZINE, presenter = "Dr. Elmer Huerta"),
        Program("rpp_s6", "rpptv", "Fútbol como Cancha: Sábado", "Toda la fecha del fútbol peruano en directo.", 16, 0, 18, 0, DayPattern.SATURDAY, ProgramGenre.DEPORTES),
        Program("rpp_s7", "rpptv", "El Poder en Tus Manos", "Análisis del ejercicio ciudadano y políticas públicas.", 18, 0, 20, 0, DayPattern.SATURDAY, ProgramGenre.OPINION),
        Program("rpp_s8", "rpptv", "Crónicas RPP", "Reportajes sobre personajes e historias de peruanos ejemplares.", 20, 0, 22, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),
        Program("rpp_s9", "rpptv", "Resumen de Noticias Fin de Semana", "Las noticias más comentadas de la jornada.", 22, 0, 0, 0, DayPattern.SATURDAY, ProgramGenre.NOTICIAS),

        // RPP TV - Domingo
        Program("rpp_d0", "rpptv", "Madrugada RPP Domingo", "Noticias y música para empezar el domingo.", 0, 0, 6, 0, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),
        Program("rpp_d1", "rpptv", "Domingo Es Fiesta y Fe", "Reflexiones dominicales y cultura peruana.", 6, 0, 8, 30, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("rpp_d2", "rpptv", "La Rotativa del Aire: Domingo", "Las primeras noticias del día con corresponsales en todo el Perú.", 8, 30, 10, 30, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),
        Program("rpp_d3", "rpptv", "Cuidando Tu Salud", "Consultas y consejos prácticos con destacados médicos.", 10, 30, 12, 0, DayPattern.SUNDAY, ProgramGenre.MAGAZINE),
        Program("rpp_d4", "rpptv", "El Gran Resumen de la Semana", "Las noticias que marcaron la pauta informativa.", 12, 0, 14, 0, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),
        Program("rpp_d5", "rpptv", "Transmisión Especial del Deporte", "Goles, jugadas y la liga peruana minuto a minuto.", 14, 0, 17, 0, DayPattern.SUNDAY, ProgramGenre.DEPORTES),
        Program("rpp_d6", "rpptv", "Ampliación de Noticias: Dominical", "Entrevistas de fondo con líderes de opinión.", 17, 0, 19, 0, DayPattern.SUNDAY, ProgramGenre.OPINION),
        Program("rpp_d7", "rpptv", "Las Cosas Claras", "Análisis periodístico de los destapes del domingo.", 19, 0, 21, 0, DayPattern.SUNDAY, ProgramGenre.OPINION),
        Program("rpp_d8", "rpptv", "Debate Político RPP", "Mesa redonda con analistas sobre la semana que empieza.", 21, 0, 22, 30, DayPattern.SUNDAY, ProgramGenre.OPINION),
        Program("rpp_d9", "rpptv", "Cierre Informativo RPP", "Resumen con las noticias del domingo.", 22, 30, 0, 0, DayPattern.SUNDAY, ProgramGenre.NOTICIAS),

        // ==========================================
        // 11. CONGRESO TV (Canal 07.2)
        // ==========================================
        // Lunes a Viernes
        Program("con_00", "congresotv", "Archivo Parlamentario y Documentales", "Sesiones históricas y archivo audiovisual del Congreso.", 0, 0, 8, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.CULTURA),
        Program("con_01", "congresotv", "Comisiones Ordinarias del Congreso", "Debate técnico de proyectos de ley en vivo desde las comisiones.", 8, 0, 13, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION),
        Program("con_02", "congresotv", "Resumen Parlamentario Mediodía", "Balance informativo de la actividad parlamentaria.", 13, 0, 15, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.NOTICIAS),
        Program("con_03", "congresotv", "Sesión del Pleno del Congreso", "Debate y votación de leyes en directo desde el Hemiciclo.", 15, 0, 20, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION),
        Program("con_04", "congresotv", "Mesa de Diálogo Parlamentario", "Entrevistas a congresistas de todas las bancadas.", 20, 0, 22, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION),
        Program("con_05", "congresotv", "Análisis Legislativo y Entrevistas", "Análisis de las leyes promulgadas.", 22, 0, 0, 0, DayPattern.WEEKDAY_MON_FRI, ProgramGenre.OPINION),

        // Congreso TV - Sábado y Domingo
        Program("con_fd0", "congresotv", "Memoria Histórica del Parlamento", "Grandes debates constitucionales del Perú.", 0, 0, 8, 0, DayPattern.DAILY, ProgramGenre.CULTURA),
        Program("con_fd1", "congresotv", "Lo Mejor de las Comisiones", "Resumen de las sesiones más importantes de la semana.", 8, 0, 11, 0, DayPattern.SATURDAY, ProgramGenre.OPINION),
        Program("con_fd2", "congresotv", "Sesiones Históricas del Pleno", "Hitos legislativos de la democracia peruana.", 11, 0, 14, 0, DayPattern.SATURDAY, ProgramGenre.CULTURA),
        Program("con_fd3", "congresotv", "Constitución y Democracia", "Documentales sobre las leyes fundamentales.", 14, 0, 17, 0, DayPattern.SATURDAY, ProgramGenre.CULTURA),
        Program("con_fd4", "congresotv", "Balance Semanal Legislativo", "Proyectos aprobados y dictámenes en curso.", 17, 0, 20, 0, DayPattern.SATURDAY, ProgramGenre.OPINION),
        Program("con_fd5", "congresotv", "Diálogo y Leyes Aprobadas", "Explicación ciudadana de las nuevas leyes vigentes.", 20, 0, 22, 0, DayPattern.SATURDAY, ProgramGenre.OPINION),
        Program("con_fd6", "congresotv", "Archivo Audiovisual del Congreso", "Cierre con documentales históricos.", 22, 0, 0, 0, DayPattern.SATURDAY, ProgramGenre.CULTURA),

        Program("con_su1", "congresotv", "Lo Mejor de las Comisiones", "Resumen dominical de las sesiones técnicas.", 8, 0, 11, 0, DayPattern.SUNDAY, ProgramGenre.OPINION),
        Program("con_su2", "congresotv", "Sesiones Históricas del Pleno", "Debates parlamentarios del siglo XX y XXI.", 11, 0, 14, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("con_su3", "congresotv", "Constitución y Democracia", "Historia parlamentaria del Perú republicano.", 14, 0, 17, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),
        Program("con_su4", "congresotv", "Balance Semanal Legislativo", "Resumen dominical de normas aprobadas.", 17, 0, 20, 0, DayPattern.SUNDAY, ProgramGenre.OPINION),
        Program("con_su5", "congresotv", "Diálogo y Leyes Aprobadas", "Panel con los autores de las leyes.", 20, 0, 22, 0, DayPattern.SUNDAY, ProgramGenre.OPINION),
        Program("con_su6", "congresotv", "Archivo Audiovisual del Congreso", "Documentales y discursos históricos.", 22, 0, 0, 0, DayPattern.SUNDAY, ProgramGenre.CULTURA),

        // ==========================================
        // 12. VIVA TV (Canal 11.1) - Continuo 24/7
        // ==========================================
        Program("viv_00", "vivatv", "Música Continua de Noche", "Baladas, pop y música del recuerdo en la madrugada.", 0, 0, 6, 0, DayPattern.DAILY, ProgramGenre.ENTRETENIMIENTO),
        Program("viv_01", "vivatv", "Amanecer Criollo", "Música de la guardia vieja limeña, valses y marineras.", 6, 0, 9, 0, DayPattern.DAILY, ProgramGenre.CULTURA),
        Program("viv_02", "vivatv", "Sabor Peruano: Gastronomía y Folclore", "Comida popular criolla y tradiciones del Perú.", 9, 0, 12, 0, DayPattern.DAILY, ProgramGenre.CULTURA),
        Program("viv_03", "vivatv", "Viva Cumbia: Grandes Éxitos", "Los mejores videos y orquestas de cumbia peruana.", 12, 0, 15, 0, DayPattern.DAILY, ProgramGenre.ENTRETENIMIENTO),
        Program("viv_04", "vivatv", "La Caravana del Folclore", "Huaynos, sayas y morenadas de los artistas del momento.", 15, 0, 18, 0, DayPattern.DAILY, ProgramGenre.CULTURA),
        Program("viv_05", "vivatv", "Variedades Viva TV", "Entrevistas musicales, lanzamientos artísticos y farándula.", 18, 0, 21, 0, DayPattern.DAILY, ProgramGenre.ENTRETENIMIENTO),
        Program("viv_06", "vivatv", "Conciertos del Perú en Vivo", "Presentaciones en directo de las grandes orquestas peruanas.", 21, 0, 0, 0, DayPattern.DAILY, ProgramGenre.ENTRETENIMIENTO)
    )

    fun getCurrentProgram(channelId: String, peruTime: ZonedDateTime = getCurrentPeruTime()): Program? {
        val hour = peruTime.hour
        val minute = peruTime.minute
        val dayOfWeek = peruTime.dayOfWeek
        val currentMinutes = hour * 60 + minute

        val channelPrograms = programs.filter { it.channelId == channelId }
        val todayPrograms = channelPrograms.filter { it.dayPattern.matches(dayOfWeek) }

        // 1. Exact match for current time
        val active = todayPrograms.firstOrNull { it.isCurrentlyPlaying(hour, minute, dayOfWeek) }
        if (active != null) return active

        // 2. Program of today that started before now
        val pastToday = todayPrograms
            .filter { (it.startHour * 60 + it.startMinute) <= currentMinutes }
            .maxByOrNull { it.startHour * 60 + it.startMinute }
        if (pastToday != null) return pastToday

        // 3. First program of today, or fallback to any channel program
        return todayPrograms.minByOrNull { it.startHour * 60 + it.startMinute }
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
