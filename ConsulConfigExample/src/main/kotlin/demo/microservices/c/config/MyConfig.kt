package demo.microservices.c.config

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import java.io.Serializable



@Component
@RefreshScope
class MyConfig (

    @Value("\${username}") var username: String = "",
    @Value("\${password}") var password: String = "")
