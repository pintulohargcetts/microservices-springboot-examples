package demo.microservices.c.controller

import demo.microservices.c.log.Log
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/call")
class BasicController(
) {

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: String): ResponseEntity<String> {
        Log.logger("User id $id") // For demoing sleuth zipkin
        return ResponseEntity.status(HttpStatus.OK).body("This api returns call history of the user $id"/*(message = result)*/);

    }
}