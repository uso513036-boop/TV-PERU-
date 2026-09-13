package com.example.ui.screens

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
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.data.model.ChannelCategory
import com.example.data.repository.EpgRepository
import com.example.ui.theme.LiveBadgeRed
import com.example.ui.theme.PeruGold
import com.example.ui.theme.PeruRedPrimary
import com.example.ui.theme.TvDarkOutline
import com.example.ui.theme.TvTextSecondary
import java.time.ZonedDateTime

@Composable
fun ChannelListScreen(
    channels: List<Channel>,
    selectedChannel: Channel,
    selectedCategory: ChannelCategory,
    favoriteIds: Set<String>,
    currentPeruTime: ZonedDateTime,
    onSelectCategory: (ChannelCategory) -> Unit,
    onSelectChannel: (Channel) -> Unit,
    onToggleFavorite: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val filteredChannels = channels.filter {
        selectedCategory == ChannelCategory.TODOS || it.category == selectedCategory
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Category Filter Chips
        LazyRow(
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(ChannelCategory.values()) { category ->
                val isSelected = category == selectedCategory
                Surface(
                    onClick = { onSelectCategory(category) },
                    shape = RoundedCornerShape(20.dp),
                    color = if (isSelected) PeruRedPrimary else MaterialTheme.colorScheme.surface,
                    border = if (!isSelected) androidx.compose.foundation.BorderStroke(1.dp, TvDarkOutline) else null,
                    modifier = Modifier.testTag("category_chip_${category.name}")
                ) {
                    Text(
                        text = category.displayName,
                        fontSize = 13.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 7.dp)
                    )
                }
            }
        }

        // Channels List
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(filteredChannels) { channel ->
                val isCurrentlyPlaying = channel.id == selectedChannel.id
                val isFavorite = favoriteIds.contains(channel.id)
                val currentProg = EpgRepository.getCurrentProgram(channel.id, currentPeruTime)
                val nextProg = EpgRepository.getNextProgram(channel.id, currentProg, currentPeruTime)

                ChannelCardItem(
                    channel = channel,
                    isSelected = isCurrentlyPlaying,
                    isFavorite = isFavorite,
                    currentProgramTitle = currentProg?.title ?: "Transmisión en vivo",
                    currentProgramTime = currentProg?.timeRangeFormatted ?: "--:--",
                    nextProgramTitle = nextProg?.title,
                    onSelect = { onSelectChannel(channel) },
                    onToggleFav = { onToggleFavorite(channel.id) }
                )
            }
        }
    }
}

@Composable
fun ChannelCardItem(
    channel: Channel,
    isSelected: Boolean,
    isFavorite: Boolean,
    currentProgramTitle: String,
    currentProgramTime: String,
    nextProgramTitle: String?,
    onSelect: () -> Unit,
    onToggleFav: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onSelect)
            .border(
                width = if (isSelected) 1.5.dp else 0.dp,
                color = if (isSelected) PeruRedPrimary else Color.Transparent,
                shape = RoundedCornerShape(14.dp)
            )
            .testTag("channel_item_${channel.id}"),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected)
                MaterialTheme.colorScheme.primary.copy(alpha = 0.09f)
            else
                MaterialTheme.colorScheme.surface
        ),
        shape = RoundedCornerShape(14.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Channel Logo Box
            Box(
                modifier = Modifier
                    .size(54.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(channel.brandColor)),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = channel.logoText,
                        color = Color.White,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Black
                    )
                    Text(
                        text = channel.channelNumber,
                        color = Color.White.copy(alpha = 0.85f),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Channel Details & Live Show
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = channel.name,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    if (channel.isVerified) {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = "Señal verificada",
                            tint = PeruRedPrimary,
                            modifier = Modifier.size(14.dp)
                        )
                    }
                    if (channel.isHd) {
                        Spacer(modifier = Modifier.width(4.dp))
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(3.dp))
                                .background(MaterialTheme.colorScheme.surfaceVariant)
                                .padding(horizontal = 4.dp, vertical = 1.dp)
                        ) {
                            Text(
                                text = "HD",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(2.dp))

                // Current program
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(6.dp)
                            .clip(CircleShape)
                            .background(LiveBadgeRed)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = currentProgramTitle,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = if (isSelected) PeruRedPrimary else MaterialTheme.colorScheme.onSurface,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                // Time and next program
                Text(
                    text = if (nextProgramTitle != null) {
                        "$currentProgramTime • A cont: $nextProgramTitle"
                    } else {
                        currentProgramTime
                    },
                    fontSize = 11.sp,
                    color = TvTextSecondary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Favorite Button & Play Indicator
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton(
                    onClick = onToggleFav,
                    modifier = Modifier.size(36.dp)
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favorito",
                        tint = if (isFavorite) PeruRedPrimary else TvTextSecondary,
                        modifier = Modifier.size(20.dp)
                    )
                }

                if (isSelected) {
                    Surface(
                        shape = RoundedCornerShape(10.dp),
                        color = PeruRedPrimary,
                        modifier = Modifier.padding(top = 2.dp)
                    ) {
                        Text(
                            text = "ACTIVO",
                            color = Color.White,
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                        )
                    }
                }
            }
        }
    }
}
