package emo.microservices.appgateway.fallbackj

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class FallbackController {

    @RequestMapping("/userFallback")
    fun users(): Mono<String> {
        return Mono.just("Plan B userFallback");
    }

    @RequestMapping("/chatFallback")
    fun chat(): Mono<String> {
        return Mono.just("Plan B chatFallback");
    }

    @RequestMapping("/callFallback")
    fun call(): Mono<String> {
        return Mono.just("Plan B callFallback");
    }



}