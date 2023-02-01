package demo.microservices.b.dto

import com.fasterxml.jackson.annotation.JsonInclude

class DemoResponse (
    val content: String,

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    val additionalContent: String = ""
)
