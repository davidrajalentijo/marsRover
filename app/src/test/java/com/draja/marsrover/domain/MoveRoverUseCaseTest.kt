package com.draja.marsrover.domain

import com.draja.marsrover.data.repository.RoverRepository
import com.draja.marsrover.domain.MoveRoverUseCase
import com.draja.marsrover.domain.RoverRepository
import com.draja.marsrover.domain.model.Rover
import com.draja.marsrover.roverCommandsRequest
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class MoveRoverUseCaseTest {

    @Mock
    private lateinit var roverRepository: RoverRepository

    private lateinit var moveRoverUseCase: MoveRoverUseCase

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        moveRoverUseCase = MoveRoverUseCase(roverRepository)
    }

    @Test
    fun `test move rover use case`() = runBlocking {

       // `when`(roverRepository.moveRover(roverCommandsRequest)).thenReturn(Result.success(true)

        // Act
        /*val result = moveRoverUseCase?.execute(roverCommandsRequest)

        // Assert
        assertEquals(Rover(1, 2, "N"), result)*/
    }
}