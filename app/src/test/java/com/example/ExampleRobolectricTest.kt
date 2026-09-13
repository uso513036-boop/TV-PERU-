package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("TV Perú", appName)
  }

  @Test
  fun `verify channels exist and have valid stream urls`() {
    val channels = com.example.data.repository.ChannelRepository.channels
    org.junit.Assert.assertTrue("Debe contener canales peruanos", channels.isNotEmpty())
    val tvPeru = channels.firstOrNull { it.id == "tvperu" }
    org.junit.Assert.assertNotNull("Canal TV Perú debe existir", tvPeru)
    org.junit.Assert.assertTrue("Stream URL no debe estar vacía", tvPeru?.streamUrl?.isNotEmpty() == true)
  }

  @Test
  fun `verify epg repository schedules contain accurate programs`() {
    val programs = com.example.data.repository.EpgRepository.programs
    org.junit.Assert.assertTrue("La guía EPG debe contener programas", programs.isNotEmpty())

    // Check América TV has Al Fondo Hay Sitio
    val afhs = programs.firstOrNull { it.title.contains("Al Fondo Hay Sitio") }
    org.junit.Assert.assertNotNull("Debe existir Al Fondo Hay Sitio en EPG", afhs)

    // Check Latina has El Gran Chef Famosos
    val granChef = programs.firstOrNull { it.title.contains("El Gran Chef") }
    org.junit.Assert.assertNotNull("Debe existir El Gran Chef Famosos en EPG", granChef)

    // Check TV Perú has Reportaje al Perú
    val reportaje = programs.firstOrNull { it.title.contains("Reportaje al Perú") }
    org.junit.Assert.assertNotNull("Debe existir Reportaje al Perú en EPG", reportaje)
  }
}
