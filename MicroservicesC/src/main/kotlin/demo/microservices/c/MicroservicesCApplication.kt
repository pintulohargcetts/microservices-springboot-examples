package demo.microservices.c

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class MicroServicesCApplication

fun main(args: Array<String>) {
	runApplication<MicroServicesCApplication>(*args)
}
