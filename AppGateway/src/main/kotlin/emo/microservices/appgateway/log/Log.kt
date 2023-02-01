package com.sspl.services.gateway.log

import mu.KLoggable
import mu.KLogger
import mu.KLogging

/**
 * Log
 *
 * @constructor Create empty Log
 */
open class Log : KLoggable{
    override val logger: KLogger = logger()
    companion object : KLogging()
}