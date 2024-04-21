package com.draja.rover.domain


object RoverManager {

    lateinit var rover: RoverInterface

    fun initializeRover(rover: RoverInterface) {
        RoverManager.rover = rover
    }
}

