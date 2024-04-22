package com.draja.marsrover.domain

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.draja.marsrover.data.repository.RoverRepository
import com.draja.marsrover.exception
import com.draja.marsrover.roverCommandsModel
import com.draja.marsrover.roverCommandsRequest
import com.draja.marsrover.roverPositionModel
import com.draja.marsrover.roverPositionResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MoveRoverUseCaseTest {

    private val roverRepository = mockk<RoverRepository>()
    private val moveRoverUseCase = MoveRoverUseCase(roverRepository)

    @Test
    fun `move Rover use case OK`() = runBlocking {
        coEvery {
            roverRepository.moveRover(roverCommandsRequest)
        } returns Result.success(true)


        val actual = moveRoverUseCase.invoke(roverCommandsModel)

        assertThat(actual.getOrThrow()).isEqualTo(true)
    }

    @Test
    fun `move Rover use case ERROR`() = runBlocking {
        coEvery {
            roverRepository.moveRover(roverCommandsRequest)
        } returns Result.failure(exception)


        val actual = moveRoverUseCase.invoke(roverCommandsModel)

        assertThat(actual.exceptionOrNull()).isEqualTo(exception)
    }
}