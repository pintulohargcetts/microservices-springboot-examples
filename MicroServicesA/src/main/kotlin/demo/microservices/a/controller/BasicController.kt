package demo.microservices.a.controller

import demo.microservices.a.log.Log
import demo.microservices.b.dto.DemoResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Register controller
 *
 * @constructor Create empty Register controller
 */
@RestController
@RequestMapping("/users")
class BasicController(
) {

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: String): ResponseEntity<DemoResponse>{
        Log.logger.info("getUser/users/User id $id") // For demoing sleuth zipkin
        return ResponseEntity.status(HttpStatus.OK).body(DemoResponse("userdetail"));
    }
}