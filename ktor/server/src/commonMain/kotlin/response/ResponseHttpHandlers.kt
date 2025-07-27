package response

import io.ktor.server.routing.Route
import io.ktor.server.routing.RoutingContext
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.patch
import io.ktor.server.routing.post
import io.ktor.server.routing.put
import kotlinx.serialization.StringFormat

inline fun <reified D> Route.post(
    path: String,
    codec: StringFormat,
    noinline block: suspend RoutingContext.() -> D
) = post(path) { respondJson(codec) { block() } }

inline fun <reified D> Route.put(
    path: String,
    codec: StringFormat,
    noinline block: suspend RoutingContext.() -> D
) = put(path) { respondJson(codec) { block() } }

inline fun <reified D> Route.patch(
    path: String,
    codec: StringFormat,
    noinline block: suspend RoutingContext.() -> D
) = patch(path) { respondJson(codec) { block() } }

inline fun <reified D> Route.delete(
    path: String,
    codec: StringFormat,
    noinline block: suspend RoutingContext.() -> D
) = delete(path) { respondJson(codec) { block() } }

inline fun <reified D> Route.get(
    path: String,
    codec: StringFormat,
    noinline block: suspend RoutingContext.() -> D
) = get(path) { respondJson(codec) { block() } }