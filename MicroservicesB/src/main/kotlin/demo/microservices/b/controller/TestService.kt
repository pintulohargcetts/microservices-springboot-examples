package demo.microservices.b.controller

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.client.RestTemplate

@Service
class TestService {
    @Autowired
    lateinit var restTemplate: RestTemplate;

    fun fallbackChats(string: Exception): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.OK).body("Cached response from fallback");
    }

    @CircuitBreaker(name= BasicController.USER_SERVICE, fallbackMethod = "fallbackChats" )
    fun getUserDetails(@PathVariable id: String): ResponseEntity<String> {
        var url = BasicController.USER_SERVICE_URL + "/$id"; // With Smart rest template.
        var response = restTemplate.getForObject(url, String::class.java) // Use Webflux and webclient to use non-blocking rest call.
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * @HystrixCommand(fallbackMethod = "fallbackChats", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000") })

    fun getUserDetails(@PathVariable id: String): ResponseEntity<String> {
        var url = BasicController.USER_SERVICE_URL + "/$id"; // With Smart rest template.
        var response = restTemplate.getForObject(url, String::class.java) // Use Webflux and webclient to use non-blocking rest call.
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
     */
}