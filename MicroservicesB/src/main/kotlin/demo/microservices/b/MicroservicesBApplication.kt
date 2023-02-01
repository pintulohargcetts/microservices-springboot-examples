package demo.microservices.b

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.client.loadbalancer.LoadBalanced

import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate


@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
class MicroservicesBApplication{

    //Spring Cloud Eureka has a built-in client side load balancer called Ribbon.
    //Ribbon can automatically be configured by registering RestTemplate as a bean and annotating it with @LoadBalanced.
    @Bean
    @LoadBalanced
    fun restTemplate(): RestTemplate? {
        return RestTemplate()
    }
}

fun main(args: Array<String>) {
    runApplication<MicroservicesBApplication>(*args)



}
