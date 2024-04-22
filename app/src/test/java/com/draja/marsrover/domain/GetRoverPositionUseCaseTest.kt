package com.draja.marsrover.domain

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.draja.marsrover.data.repository.RoverRepository
import com.draja.marsrover.exception
import com.draja.marsrover.roverPositionModel
import com.draja.marsrover.roverPositionResponse
import io.mockk.coEvery
import kotlinx.coroutines.runBlocking
import org.junit.Test
import io.mockk.mockk

class GetRoverPositionUseCaseTest {

    private val roverRepository = mockk<RoverRepository>()
    private val getRoverPositionUseCase = GetRoverPositionUseCase(roverRepository)

    @Test
    fun `get Rover position use case OK`() = runBlocking {
        coEvery {
            roverRepository.getRoverPosition()
        } returns Result.success(roverPositionResponse)


        val actual = getRoverPositionUseCase.invoke()

        assertThat(actual.getOrThrow()).isEqualTo(roverPositionModel)
    }

    @Test
    fun `get Rover position use case ERROR`() = runBlocking {
        coEvery {
            roverRepository.getRoverPosition()
        } returns Result.failure(exception)


        val actual = getRoverPositionUseCase.invoke()

        assertThat(actual.exceptionOrNull()).isEqualTo(exception)
    }

}