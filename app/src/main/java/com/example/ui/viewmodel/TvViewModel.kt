package com.example.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.Channel
import com.example.data.model.ChannelCategory
import com.example.data.model.Program
import com.example.data.repository.ChannelRepository
import com.example.data.repository.EpgRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.time.DayOfWeek
import java.time.ZonedDateTime

enum class ResizeMode(val label: String) {
    FIT("Ajustar"),
    FILL("Llenar"),
    ZOOM("Zoom")
}

data class TvUiState(
    val channels: List<Channel> = ChannelRepository.channels,
    val selectedChannel: Channel = ChannelRepository.channels.first(),
    val selectedCategory: ChannelCategory = ChannelCategory.TODOS,
    val currentProgram: Program? = null,
    val nextProgram: Program? = null,
    val currentPeruTime: ZonedDateTime = EpgRepository.getCurrentPeruTime(),
    val isPlaying: Boolean = true,
    val isBuffering: Boolean = false,
    val isMuted: Boolean = false,
    val isFullscreen: Boolean = false,
    val resizeMode: ResizeMode = ResizeMode.FIT,
    val playbackError: String? = null,
    val selectedEpgChannelId: String = ChannelRepository.channels.first().id,
    val selectedEpgDay: DayOfWeek = EpgRepository.getCurrentPeruTime().dayOfWeek,
    val epgPrograms: List<Program> = emptyList(),
    val searchQuery: String = "",
    val searchResults: List<Program> = emptyList(),
    val favoriteChannelIds: Set<String> = setOf("tvperu", "america", "latina")
)

class TvViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(TvUiState())
    val uiState: StateFlow<TvUiState> = _uiState.asStateFlow()

    init {
        updateTimeAndEpg()
        loadEpgForSelectedChannel()
        startTimeTicker()
    }

    private fun startTimeTicker() {
        viewModelScope.launch {
            while (isActive) {
                delay(30_000) // Update every 30 seconds
                updateTimeAndEpg()
            }
        }
    }

    private fun updateTimeAndEpg() {
        val now = EpgRepository.getCurrentPeruTime()
        val currentChannel = _uiState.value.selectedChannel
        val currProg = EpgRepository.getCurrentProgram(currentChannel.id, now)
        val nextProg = EpgRepository.getNextProgram(currentChannel.id, currProg, now)

        _uiState.update {
            it.copy(
                currentPeruTime = now,
                currentProgram = currProg,
                nextProgram = nextProg
            )
        }
    }

    fun selectChannel(channel: Channel) {
        if (_uiState.value.selectedChannel.id == channel.id) return
        val now = _uiState.value.currentPeruTime
        val currProg = EpgRepository.getCurrentProgram(channel.id, now)
        val nextProg = EpgRepository.getNextProgram(channel.id, currProg, now)

        _uiState.update {
            it.copy(
                selectedChannel = channel,
                selectedEpgChannelId = channel.id,
                currentProgram = currProg,
                nextProgram = nextProg,
                isPlaying = true,
                isBuffering = true,
                playbackError = null
            )
        }
        loadEpgForSelectedChannel()
    }

    fun selectChannelById(channelId: String) {
        val channel = ChannelRepository.getChannelById(channelId) ?: return
        selectChannel(channel)
    }

    fun playNextChannel() {
        val all = _uiState.value.channels
        val currentIndex = all.indexOfFirst { it.id == _uiState.value.selectedChannel.id }
        val nextIndex = if (currentIndex < all.size - 1) currentIndex + 1 else 0
        selectChannel(all[nextIndex])
    }

    fun playPreviousChannel() {
        val all = _uiState.value.channels
        val currentIndex = all.indexOfFirst { it.id == _uiState.value.selectedChannel.id }
        val prevIndex = if (currentIndex > 0) currentIndex - 1 else all.size - 1
        selectChannel(all[prevIndex])
    }

    fun setCategory(category: ChannelCategory) {
        _uiState.update { it.copy(selectedCategory = category) }
    }

    fun togglePlayPause() {
        _uiState.update { it.copy(isPlaying = !it.isPlaying) }
    }

    fun toggleMute() {
        _uiState.update { it.copy(isMuted = !it.isMuted) }
    }

    fun toggleFullscreen() {
        _uiState.update { it.copy(isFullscreen = !it.isFullscreen) }
    }

    fun setFullscreen(fullscreen: Boolean) {
        _uiState.update { it.copy(isFullscreen = fullscreen) }
    }

    fun cycleResizeMode() {
        val next = when (_uiState.value.resizeMode) {
            ResizeMode.FIT -> ResizeMode.FILL
            ResizeMode.FILL -> ResizeMode.ZOOM
            ResizeMode.ZOOM -> ResizeMode.FIT
        }
        _uiState.update { it.copy(resizeMode = next) }
    }

    fun setPlayerBuffering(isBuffering: Boolean) {
        _uiState.update { it.copy(isBuffering = isBuffering) }
    }

    fun setPlayerError(error: String?) {
        _uiState.update { it.copy(playbackError = error, isBuffering = false) }
    }

    fun retryPlayback() {
        _uiState.update { it.copy(playbackError = null, isBuffering = true, isPlaying = true) }
    }

    fun selectEpgChannel(channelId: String) {
        _uiState.update { it.copy(selectedEpgChannelId = channelId) }
        loadEpgForSelectedChannel()
    }

    fun selectEpgDay(day: DayOfWeek) {
        _uiState.update { it.copy(selectedEpgDay = day) }
        loadEpgForSelectedChannel()
    }

    private fun loadEpgForSelectedChannel() {
        val channelId = _uiState.value.selectedEpgChannelId
        val day = _uiState.value.selectedEpgDay
        val list = EpgRepository.getScheduleForChannel(channelId, day)
        _uiState.update { it.copy(epgPrograms = list) }
    }

    fun onSearchQueryChanged(query: String) {
        val results = EpgRepository.searchPrograms(query)
        _uiState.update { it.copy(searchQuery = query, searchResults = results) }
    }

    fun toggleFavorite(channelId: String) {
        _uiState.update { state ->
            val favs = state.favoriteChannelIds.toMutableSet()
            if (favs.contains(channelId)) {
                favs.remove(channelId)
            } else {
                favs.add(channelId)
            }
            state.copy(favoriteChannelIds = favs)
        }
    }
}
