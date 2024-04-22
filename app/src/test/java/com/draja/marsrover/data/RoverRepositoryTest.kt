package com.draja.marsrover.data

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.draja.marsrover.data.datasource.cloud.RoverCloudDataSource
import com.draja.marsrover.data.repository.RoverRepositoryImpl
import com.draja.marsrover.exception
import com.draja.marsrover.roverCommandsRequest
import com.draja.marsrover.roverPositionResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Test

class RoverRepositoryTest {

    private val roverCloudDataSource = mockk<RoverCloudDataSource>()
    private val roverRepositoryImpl = RoverRepositoryImpl(roverCloudDataSource)

    @Test
    fun `move Rover repository OK`() = runBlocking {
        coEvery {
            roverCloudDataSource.moveRover(roverCommandsRequest)
        } returns Result.success(true)

        val actual = roverRepositoryImpl.moveRover(roverCommandsRequest)

        assertThat(actual.getOrThrow()).isEqualTo(true)
    }

    @Test
    fun `move Rover repository ERROR`() = runBlocking {
        coEvery {
            roverCloudDataSource.moveRover(roverCommandsRequest)
        } returns Result.failure(exception)

        val actual = roverRepositoryImpl.moveRover(roverCommandsRequest)

        assertThat(actual.exceptionOrNull()).isEqualTo(exception)
    }

    @Test
    fun `get Rover Position repository OK`() = runBlocking {
        coEvery {
            roverCloudDataSource.getRoverPosition()
        } returns Result.success(roverPositionResponse)

        val actual = roverRepositoryImpl.getRoverPosition()

        assertThat(actual.getOrThrow()).isEqualTo(roverPositionResponse)
    }

    @Test
    fun `get Rover position repository ERROR`() = runBlocking {
        coEvery {
            roverCloudDataSource.getRoverPosition()
        } returns Result.failure(exception)

        val actual = roverRepositoryImpl.getRoverPosition()


        assertThat(actual.exceptionOrNull()).isEqualTo(exception)
    }
}