package com.draja.marsrover.domain.mapper

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.draja.marsrover.domain.entity.mapper.toModel
import com.draja.marsrover.roverPositionModel
import com.draja.marsrover.roverPositionResponse
import org.junit.Test

class RoverPositionMapperTest {

    @Test
    fun `should return RoverPositionModel from RoverPositionResponse with same values`() {
        val actual = roverPositionResponse.toModel()

        assertThat(actual).isEqualTo(roverPositionModel)
    }
}