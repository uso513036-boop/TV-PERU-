package com.example

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onRoot
import com.example.data.model.ChannelCategory
import com.example.data.repository.ChannelRepository
import com.example.data.repository.EpgRepository
import com.example.ui.screens.ChannelListScreen
import com.example.ui.theme.MyApplicationTheme
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.captureRoboImage
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(RobolectricTestRunner::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(qualifiers = RobolectricDeviceQualifiers.Pixel8, sdk = [36])
class GreetingScreenshotTest {

  @get:Rule val composeTestRule = createComposeRule()

  @Test
  fun channels_screen_screenshot() {
    composeTestRule.setContent {
      MyApplicationTheme {
        ChannelListScreen(
          channels = ChannelRepository.channels,
          selectedChannel = ChannelRepository.channels.first(),
          selectedCategory = ChannelCategory.TODOS,
          favoriteIds = setOf("tvperu", "america"),
          currentPeruTime = EpgRepository.getCurrentPeruTime(),
          onSelectCategory = {},
          onSelectChannel = {},
          onToggleFavorite = {}
        )
      }
    }

    composeTestRule.onRoot().captureRoboImage(filePath = "src/test/screenshots/channels.png")
  }
}
