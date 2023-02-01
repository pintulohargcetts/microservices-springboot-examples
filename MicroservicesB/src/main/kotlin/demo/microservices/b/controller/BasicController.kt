package demo.microservices.b.controller


import demo.microservices.b.dto.DemoResponse
import demo.microservices.b.log.Log
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

/*


MICROSERVICES--B(CHAT)--------->>>using RestTemplate------->>>MICROSERVICES-A(USER).

#Actutator health endpoint localhost:9092/actuator/health
 */

@RestController
@RequestMapping("/chat")
class BasicController(
val testService: TestService
) {
    companion object{
        var BASE_URL = "http://MICROSERVICE-A" // Can come from config server or application yaml
        //var BASE_URL = "http://192.168.0.136:9091" // Can come from config server or application yaml
        const val USER_SERVICE = "userService";
        var USER_SERVICE_URL: String = BASE_URL + "/users";
    }

    @GetMapping("/{id}")
    fun getChats(@PathVariable id: String): ResponseEntity<DemoResponse> {
        Log.logger.info("getChats/for User id $id get chats histories") // For demoing sleuth zipkin
        return ResponseEntity.status(HttpStatus.OK).body(testService.getUserDetails(id).body?.let {
            DemoResponse("chat_history",
                it
            )
        })
       // return ResponseEntity.status(HttpStatus.OK).body("{chat_history{id:$id,total_count:100} \n" + testService.getUserDetails(id).body);
    }

    /*fun fallbackChats(): Mono<String> {
           return Mono.just("fallbackChats - circuit closed");
   }*/
}


