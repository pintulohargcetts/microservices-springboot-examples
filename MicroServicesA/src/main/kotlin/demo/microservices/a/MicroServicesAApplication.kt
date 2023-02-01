package demo.microservices.a

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class MicroServicesAApplication

fun main(args: Array<String>) {
    runApplication<MicroServicesAApplication>(*args)
}
