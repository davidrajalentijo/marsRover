package com.draja.network

import assertk.assertThat
import assertk.assertions.isNotNull
import assertk.assertions.isNull
import org.junit.After
import org.junit.Before
import org.junit.Test

class NetworkServiceTest {

    @Before
    fun setUp() {
        KtorClient.destroyClient()
        NetworkService.createInstance()
    }

    @After
    fun tearDown() {

    }

    @Test
    fun `check if Network service is instanced`() {
        assertThat(NetworkService.getInstance()).isNotNull()
    }

    @Test
    fun `check if Network service is NOT instanced`() {
        NetworkService.destroy()
        assertThat(NetworkService.getInstance()).isNull()
    }
}