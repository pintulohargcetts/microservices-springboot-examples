package demo.microservices.c

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean


@SpringBootApplication
@EnableEurekaClient
@EnableConfigurationProperties
class ConsulConfigExample{
	@Bean
	fun objectMapper(): ObjectMapper? {
		return ObjectMapper()
	}
}

fun main(args: Array<String>) {
	runApplication<ConsulConfigExample>(*args)
}
