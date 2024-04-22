package com.draja.marsrover.domain.mapper

import assertk.assertThat
import assertk.assertions.isEqualTo
import com.draja.marsrover.domain.entity.mapper.toRequest
import com.draja.marsrover.roverCommandsModel
import com.draja.marsrover.roverCommandsRequest
import org.junit.Test

class RoverCommandsMapperTest {

    @Test
    fun `should return RoverCommandsRequest from RoverCommandsModel with same values`() {
        val actual = roverCommandsModel.toRequest()

        assertThat(actual).isEqualTo(roverCommandsRequest)
    }
}