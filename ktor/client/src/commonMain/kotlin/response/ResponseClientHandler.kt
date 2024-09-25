package response

import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import kotlinx.serialization.KSerializer
import kotlinx.serialization.StringFormat
import kotlinx.serialization.serializer
import lexi.LogTracer

suspend inline fun <reified T> HttpResponse.getOrThrow(codec: StringFormat, tracer: LogTracer): T = getOrThrow(
    serializer = serializer(),
    codec = codec,
    tracer = tracer
)

@Suppress("ThrowableNotThrown")
suspend fun <T> HttpResponse.getOrThrow(serializer: KSerializer<T>, codec: StringFormat, tracer: LogTracer): T {
    val txt = bodyAsText()
    tracer.debug(txt)
    val status = toStatus()
    val res: Response<T> = try {
        Successful(
            status = status,
            data = codec.decodeFromString(serializer, txt)
        )
    } catch (exp: Throwable) {
        try {
            Failed(
                status = status,
                error = codec.decodeFromString(ResponseError.serializer(), txt)
            )
        } catch (cause: Throwable) {
            cause.addSuppressed(exp)
            Failed(status, cause.toError())
        }
    }
    tracer.debug(res.message)
    when (res) {
        is Successful -> tracer.passed()
        is Failed -> tracer.failed(res.error.toException())
    }
    return res.getOrThrow()
}

@PublishedApi
internal fun HttpResponse.toStatus() = Status(status.value, status.description)