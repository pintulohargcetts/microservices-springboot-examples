package demo.microservices.c.controller


import demo.microservices.c.config.MyConfig
import demo.microservices.c.log.Log
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/config")
class TestConfigController(
) {
    private val logger = KotlinLogging.logger {}
    @Autowired
    private lateinit var  config: MyConfig

    @GetMapping("/data")
    fun getConfiguration(): ResponseEntity<String> {
        logger.warn { ("getConfiguration data from consul") } // For demoing sleuth zipkin
        return ResponseEntity.status(HttpStatus.OK).body("{username}:"+config.username + " password{" +config.password +"}");
    }
}