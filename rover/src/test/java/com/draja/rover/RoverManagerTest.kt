package com.draja.rover

import com.draja.rover.domain.Rover
import com.draja.rover.domain.RoverManager
import com.draja.rover.entities.Coordinates
import com.draja.rover.entities.Direction
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class RoverManagerTest {

    @Mock
    private lateinit var rover: Rover

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        RoverManager.initializeRover(rover)
    }

    @Test
    fun `test rover manager`() {
        // given
        `when`(rover.getRoverPosition()).thenReturn(Coordinates(1, 2))
        `when`(rover.getRoverDirection()).thenReturn(Direction.N)

        // when
        val position = RoverManager.rover.getRoverPosition()
        val direction = RoverManager.rover.getRoverDirection()

        // then
        assertEquals(Coordinates(1, 2), position)
        assertEquals(Direction.N, direction)
    }
}