package demo.microservices.discoveryserver


import org.springframework.boot.runApplication

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer


@EnableEurekaServer
@EnableAutoConfiguration
class DiscoveryServerApplication

fun main(args: Array<String>) {
    runApplication<DiscoveryServerApplication>(*args)
}

