package response

import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.ApplicationCall
import io.ktor.server.response.respondText
import io.ktor.server.routing.RoutingContext
import kotlinx.serialization.StringFormat
import kotlinx.serialization.encodeToString

suspend inline fun <reified D> RoutingContext.respondJson(codec: StringFormat, block: () -> D) = try {
    call.respond(codec, Successful(block()))
} catch (exp: ResponseException) {
    call.respond(codec, exp.toFailed())
} catch (err: Throwable) {
    call.respond(codec, err.toFailed())
}

suspend inline fun <reified D> ApplicationCall.respond(codec: StringFormat, res: Successful<D>) = respondText(
    text = codec.encodeToString<D>(res.data),
    contentType = ContentType.Application.Json,
    status = res.status.toKtorStatus()
)

suspend fun ApplicationCall.respond(codec: StringFormat, res: Failed) = respondText(
    text = codec.encodeToString<ResponseError>(res.error),
    contentType = ContentType.Application.Json,
    status = res.status.toKtorStatus()
)

inline fun Status.toKtorStatus() = HttpStatusCode(code, message)