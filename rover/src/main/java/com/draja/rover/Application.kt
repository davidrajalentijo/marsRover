package com.draja.rover

import com.draja.rover.domain.Rover
import com.draja.rover.domain.RoverManager
import com.draja.rover.entities.Coordinates
import com.draja.rover.entities.Direction
import com.draja.rover.entities.MoveRequest
import com.draja.rover.entities.Position
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.http.HttpStatusCode
import io.ktor.jackson.jackson
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun Application.module() {
    install(ContentNegotiation) {
        jackson { }
    }
    routing {
        post("/move") {
            val moveRequest = call.receive<MoveRequest>()

            val rover = Rover(
                Coordinates(moveRequest.topRightCorner.x, moveRequest.topRightCorner.y),
                Coordinates(moveRequest.roverPosition.x, moveRequest.roverPosition.y),
                Direction.valueOf(moveRequest.roverDirection),
            )

            RoverManager.initializeRover(rover)

            moveRequest.movements.forEach { command: Char ->
                when (command) {
                    'M' -> RoverManager.rover.moveForward()
                    'L' -> RoverManager.rover.turnLeft()
                    'R' -> RoverManager.rover.turnRight()
                    else -> {}
                }
            }
            call.respond(HttpStatusCode.OK)
        }

        get("/position") {
            val position = Position(
                RoverManager.rover.getRoverPosition().x, RoverManager.rover.getRoverPosition().y,
                RoverManager.rover.getRoverDirection().name
            )
            call.respond(position)
        }
    }
}

fun main() {
    embeddedServer(Netty, host = "192.168.0.23", port = 8080, module = Application::module).start(
        wait = true
    )
}