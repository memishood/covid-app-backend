package com.covidapp

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.gson.*
import io.ktor.features.*
import io.ktor.util.pipeline.*
import kotlinx.coroutines.launch
import org.jsoup.Jsoup
import com.covidapp.ext.Extensions.HOST_URL
import com.covidapp.ext.Extensions.TURKEY_PATH
import com.covidapp.ext.Extensions.ACCESS_TOKEN
import com.covidapp.ext.Extensions.ACCESS_TOKEN_KEY
import com.covidapp.ext.Extensions.DELIMITER_AFTER_KEY
import com.covidapp.ext.Extensions.DELIMITER_BEFORE_KEY
import com.covidapp.model.Response
import com.covidapp.service.NewsService
import com.google.gson.Gson
import kotlinx.coroutines.runBlocking

/**
 * @author emremms35@gmail.com
 */

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    println(testing)
    install(ContentNegotiation) {
        gson { }
    }

    routing {
        get("/") {
            launch {
                call.respondRedirect(TURKEY_PATH)
            }
        }

        get(TURKEY_PATH) {
            launch {
                val params = call.parameters
                val accessToken = params[ACCESS_TOKEN_KEY]

                when (accessToken != ACCESS_TOKEN) {
                    true -> showError()
                    false -> showResponse()
                }
            }
        }
    }
}

suspend fun PipelineContext<Unit, ApplicationCall>.showError() {
    call.respond(
            Response(
                    success_status = false
            )
    )
}

fun PipelineContext<Unit, ApplicationCall>.showResponse() {
    val data = Jsoup.connect(HOST_URL)
            .get()
            .data()
            .substringAfter(DELIMITER_BEFORE_KEY)
            .substringBefore(DELIMITER_AFTER_KEY)

    val response = Gson()
            .fromJson(
                    data,
                    Response::class.java
            )

    runBlocking {
        val news = NewsService.api.getNews()
                ?.result ?: mutableListOf()

        response.haberler = news
        call.respond(response)
    }
}