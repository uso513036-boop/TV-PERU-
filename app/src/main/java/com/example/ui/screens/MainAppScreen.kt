package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.LiveTv
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.player.VideoPlayerView
import com.example.ui.theme.PeruRedPrimary
import com.example.ui.viewmodel.TvViewModel

@Composable
fun MainAppScreen(
    viewModel: TvViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    var selectedBottomTab by remember { mutableIntStateOf(0) }

    // Intercept back button when in fullscreen mode
    BackHandler(enabled = uiState.isFullscreen) {
        viewModel.setFullscreen(false)
    }

    if (uiState.isFullscreen) {
        // Immersive Fullscreen In-App Player (No system bars, no bottom navigation)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .testTag("fullscreen_player_container")
        ) {
            VideoPlayerView(
                channel = uiState.selectedChannel,
                currentProgram = uiState.currentProgram,
                isPlaying = uiState.isPlaying,
                isMuted = uiState.isMuted,
                isFullscreen = true,
                resizeMode = uiState.resizeMode,
                onTogglePlayPause = viewModel::togglePlayPause,
                onToggleMute = viewModel::toggleMute,
                onToggleFullscreen = viewModel::toggleFullscreen,
                onCycleResizeMode = viewModel::cycleResizeMode,
                onNextChannel = viewModel::playNextChannel,
                onPreviousChannel = viewModel::playPreviousChannel,
                modifier = Modifier.fillMaxSize()
            )
        }
    } else {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .statusBarsPadding(),
            bottomBar = {
                NavigationBar(
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.onSurface,
                    tonalElevation = 8.dp,
                    modifier = Modifier
                        .navigationBarsPadding()
                        .testTag("main_navigation_bar")
                ) {
                    NavigationBarItem(
                        selected = selectedBottomTab == 0,
                        onClick = { selectedBottomTab = 0 },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.LiveTv,
                                contentDescription = "Canales en Vivo"
                            )
                        },
                        label = {
                            Text(
                                text = "Canales",
                                fontSize = 12.sp,
                                fontWeight = if (selectedBottomTab == 0) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.White,
                            selectedTextColor = Color.White,
                            indicatorColor = PeruRedPrimary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        modifier = Modifier.testTag("nav_tab_canales")
                    )

                    NavigationBarItem(
                        selected = selectedBottomTab == 1,
                        onClick = {
                            // Sync current playing channel to EPG selected channel
                            viewModel.selectEpgChannel(uiState.selectedChannel.id)
                            selectedBottomTab = 1
                        },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.CalendarToday,
                                contentDescription = "Guía de Programación EPG"
                            )
                        },
                        label = {
                            Text(
                                text = "Guía EPG",
                                fontSize = 12.sp,
                                fontWeight = if (selectedBottomTab == 1) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.White,
                            selectedTextColor = Color.White,
                            indicatorColor = PeruRedPrimary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        modifier = Modifier.testTag("nav_tab_epg")
                    )

                    NavigationBarItem(
                        selected = selectedBottomTab == 2,
                        onClick = { selectedBottomTab = 2 },
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Buscar en EPG"
                            )
                        },
                        label = {
                            Text(
                                text = "Buscar",
                                fontSize = 12.sp,
                                fontWeight = if (selectedBottomTab == 2) FontWeight.Bold else FontWeight.Normal
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.White,
                            selectedTextColor = Color.White,
                            indicatorColor = PeruRedPrimary,
                            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                        ),
                        modifier = Modifier.testTag("nav_tab_buscar")
                    )
                }
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .background(MaterialTheme.colorScheme.background)
            ) {
                // Top Fixed In-App Video Player (Plays internal HLS or in-app embedded WebView, never external links)
                VideoPlayerView(
                    channel = uiState.selectedChannel,
                    currentProgram = uiState.currentProgram,
                    isPlaying = uiState.isPlaying,
                    isMuted = uiState.isMuted,
                    isFullscreen = false,
                    resizeMode = uiState.resizeMode,
                    onTogglePlayPause = viewModel::togglePlayPause,
                    onToggleMute = viewModel::toggleMute,
                    onToggleFullscreen = viewModel::toggleFullscreen,
                    onCycleResizeMode = viewModel::cycleResizeMode,
                    onNextChannel = viewModel::playNextChannel,
                    onPreviousChannel = viewModel::playPreviousChannel,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f)
                )

                // Sub-Screen Container
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f)
                ) {
                    when (selectedBottomTab) {
                        0 -> ChannelListScreen(
                            channels = uiState.channels,
                            selectedChannel = uiState.selectedChannel,
                            selectedCategory = uiState.selectedCategory,
                            favoriteIds = uiState.favoriteChannelIds,
                            currentPeruTime = uiState.currentPeruTime,
                            onSelectCategory = viewModel::setCategory,
                            onSelectChannel = viewModel::selectChannel,
                            onToggleFavorite = viewModel::toggleFavorite
                        )

                        1 -> EpgScreen(
                            channels = uiState.channels,
                            selectedChannelId = uiState.selectedEpgChannelId,
                            selectedDay = uiState.selectedEpgDay,
                            programs = uiState.epgPrograms,
                            currentPeruTime = uiState.currentPeruTime,
                            onSelectChannel = viewModel::selectEpgChannel,
                            onSelectDay = viewModel::selectEpgDay,
                            onPlayChannel = { channel ->
                                viewModel.selectChannel(channel)
                                selectedBottomTab = 0
                            }
                        )

                        2 -> SearchEpgScreen(
                            searchQuery = uiState.searchQuery,
                            searchResults = uiState.searchResults,
                            onQueryChanged = viewModel::onSearchQueryChanged,
                            onTuneChannel = { channel ->
                                viewModel.selectChannel(channel)
                                selectedBottomTab = 0
                            }
                        )
                    }
                }
            }
        }
    }
}
