package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LiveTv
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.model.Channel
import com.example.data.model.Program
import com.example.data.model.ProgramGenre
import com.example.ui.theme.LiveBadgeRed
import com.example.ui.theme.LiveGreen
import com.example.ui.theme.PeruGold
import com.example.ui.theme.PeruRedPrimary
import com.example.ui.theme.TvDarkCard
import com.example.ui.theme.TvDarkOutline
import com.example.ui.theme.TvTextMuted
import com.example.ui.theme.TvTextPrimary
import com.example.ui.theme.TvTextSecondary
import java.time.DayOfWeek
import java.time.ZonedDateTime
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun EpgScreen(
    channels: List<Channel>,
    selectedChannelId: String,
    selectedDay: DayOfWeek,
    programs: List<Program>,
    currentPeruTime: ZonedDateTime,
    onSelectChannel: (String) -> Unit,
    onSelectDay: (DayOfWeek) -> Unit,
    onPlayChannel: (Channel) -> Unit,
    modifier: Modifier = Modifier
) {
    val selectedChannel = channels.firstOrNull { it.id == selectedChannelId } ?: channels.first()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Header info banner
        Surface(
            color = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.CalendarToday,
                        contentDescription = null,
                        tint = PeruRedPrimary,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Guía Oficial EPG Perú",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
                Text(
                    text = "Hora de Lima (GMT-5)",
                    fontSize = 11.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        // Channel Selector Horizontal Row
        LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(channels) { channel ->
                val isSelected = channel.id == selectedChannelId
                Surface(
                    onClick = { onSelectChannel(channel.id) },
                    shape = RoundedCornerShape(12.dp),
                    color = if (isSelected) PeruRedPrimary else MaterialTheme.colorScheme.surface,
                    border = if (!isSelected) androidx.compose.foundation.BorderStroke(1.dp, TvDarkOutline) else null,
                    modifier = Modifier.testTag("epg_channel_tab_${channel.id}")
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(6.dp))
                                .background(if (isSelected) Color.White.copy(alpha = 0.25f) else Color(channel.brandColor))
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = channel.channelNumber,
                                color = Color.White,
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = channel.name,
                            fontSize = 13.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }

        // Day of Week Selector
        val days = listOf(
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY,
            DayOfWeek.FRIDAY,
            DayOfWeek.SATURDAY,
            DayOfWeek.SUNDAY
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(days) { day ->
                val isToday = day == currentPeruTime.dayOfWeek
                val isSelected = day == selectedDay
                val dayName = when (day) {
                    DayOfWeek.MONDAY -> "Lunes"
                    DayOfWeek.TUESDAY -> "Martes"
                    DayOfWeek.WEDNESDAY -> "Miércoles"
                    DayOfWeek.THURSDAY -> "Jueves"
                    DayOfWeek.FRIDAY -> "Viernes"
                    DayOfWeek.SATURDAY -> "Sábado"
                    DayOfWeek.SUNDAY -> "Domingo"
                }

                Surface(
                    onClick = { onSelectDay(day) },
                    shape = RoundedCornerShape(8.dp),
                    color = when {
                        isSelected -> MaterialTheme.colorScheme.primary.copy(alpha = 0.18f)
                        else -> Color.Transparent
                    },
                    border = androidx.compose.foundation.BorderStroke(
                        width = 1.dp,
                        color = if (isSelected) PeruRedPrimary else TvDarkOutline.copy(alpha = 0.5f)
                    ),
                    modifier = Modifier.testTag("epg_day_${day.name}")
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = dayName,
                            fontSize = 12.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                            color = if (isSelected) PeruRedPrimary else MaterialTheme.colorScheme.onSurface
                        )
                        if (isToday) {
                            Spacer(modifier = Modifier.width(4.dp))
                            Box(
                                modifier = Modifier
                                    .size(6.dp)
                                    .clip(CircleShape)
                                    .background(LiveGreen)
                            )
                        }
                    }
                }
            }
        }

        // Selected Channel Header Details
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 6.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(selectedChannel.brandColor)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = selectedChannel.logoText,
                            color = Color.White,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Column {
                        Text(
                            text = selectedChannel.name,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = "${selectedChannel.dial} • ${programs.size} programas",
                            fontSize = 12.sp,
                            color = TvTextSecondary
                        )
                    }
                }

                Surface(
                    onClick = { onPlayChannel(selectedChannel) },
                    shape = RoundedCornerShape(16.dp),
                    color = PeruRedPrimary,
                    modifier = Modifier.testTag("epg_play_channel_button")
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.PlayArrow,
                            contentDescription = "Ver canal",
                            tint = Color.White,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Sintonizar",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                    }
                }
            }
        }

        // Program Schedule Timeline
        if (programs.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No hay programación registrada para este día.",
                    color = TvTextSecondary,
                    fontSize = 14.sp
                )
            }
        } else {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(programs) { program ->
                    val isLive = selectedDay == currentPeruTime.dayOfWeek &&
                            program.isCurrentlyPlaying(currentPeruTime.hour, currentPeruTime.minute, currentPeruTime.dayOfWeek)
                    ProgramScheduleItem(
                        program = program,
                        isLiveNow = isLive,
                        currentHour = currentPeruTime.hour,
                        currentMinute = currentPeruTime.minute,
                        onPlayClick = { onPlayChannel(selectedChannel) }
                    )
                }
            }
        }
    }
}

@Composable
fun ProgramScheduleItem(
    program: Program,
    isLiveNow: Boolean,
    currentHour: Int,
    currentMinute: Int,
    onPlayClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = if (isLiveNow) 1.5.dp else 0.dp,
                color = if (isLiveNow) PeruRedPrimary else Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            ),
        colors = CardDefaults.cardColors(
            containerColor = if (isLiveNow)
                MaterialTheme.colorScheme.primary.copy(alpha = 0.08f)
            else
                MaterialTheme.colorScheme.surface
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Time Range Badge
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(6.dp))
                            .background(
                                if (isLiveNow) PeruRedPrimary else MaterialTheme.colorScheme.surfaceVariant
                            )
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = program.timeRangeFormatted,
                            color = if (isLiveNow) Color.White else MaterialTheme.colorScheme.onSurface,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    GenreBadge(genre = program.genre)
                }

                if (isLiveNow) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .background(LiveBadgeRed)
                            .padding(horizontal = 8.dp, vertical = 2.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(5.dp)
                                .clip(CircleShape)
                                .background(Color.White)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "AL AIRE AHORA",
                            color = Color.White,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Program Title
            Text(
                text = program.title,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            // Presenter if any
            if (program.presenter.isNotBlank()) {
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "Conducción: ${program.presenter}",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    color = PeruGold
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            // Description
            Text(
                text = program.description,
                fontSize = 12.sp,
                color = TvTextSecondary,
                lineHeight = 16.sp
            )

            // If Live, show progress bar and play button
            if (isLiveNow) {
                Spacer(modifier = Modifier.height(8.dp))
                val progress = program.calculateProgress(currentHour, currentMinute)
                val remainingMins = program.calculateRemainingMinutes(currentHour, currentMinute)

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Quedan aprox. $remainingMins min",
                        fontSize = 11.sp,
                        color = TvTextSecondary
                    )
                    Text(
                        text = "${(progress * 100).toInt()}% emitido",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        color = PeruRedPrimary
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                LinearProgressIndicator(
                    progress = { progress },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(4.dp)
                        .clip(RoundedCornerShape(2.dp)),
                    color = PeruRedPrimary,
                    trackColor = TvDarkOutline
                )
            }
        }
    }
}

@Composable
fun GenreBadge(genre: ProgramGenre) {
    val (bgColor, textColor) = when (genre) {
        ProgramGenre.NOTICIAS -> Pair(Color(0xFF1E3A8A), Color(0xFF93C5FD))
        ProgramGenre.MAGAZINE -> Pair(Color(0xFF831843), Color(0xFFF9A8D4))
        ProgramGenre.NOVELA -> Pair(Color(0xFF581C87), Color(0xFFD8B4FE))
        ProgramGenre.ENTRETENIMIENTO -> Pair(Color(0xFF701A75), Color(0xFFF0ABFC))
        ProgramGenre.DEPORTES -> Pair(Color(0xFF14532D), Color(0xFF86EFAC))
        ProgramGenre.CULTURA -> Pair(Color(0xFF713F12), Color(0xFFFDE047))
        ProgramGenre.OPINION -> Pair(Color(0xFF7C2D12), Color(0xFFFDBA74))
        ProgramGenre.INFANTIL -> Pair(Color(0xFF065F46), Color(0xFF6EE7B7))
        ProgramGenre.CINE -> Pair(Color(0xFF312E81), Color(0xFFA5B4FC))
    }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(4.dp))
            .background(bgColor.copy(alpha = 0.5f))
            .padding(horizontal = 6.dp, vertical = 2.dp)
    ) {
        Text(
            text = genre.displayName,
            color = textColor,
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium
        )
    }
}
