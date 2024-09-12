package kase.response

import io.ktor.server.routing.Routing
import io.ktor.server.routing.RoutingContext
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.patch
import io.ktor.server.routing.post
import io.ktor.server.routing.put
import kotlinx.serialization.StringFormat


inline fun Routing.post(
    path: String,
    codec: StringFormat,
    noinline block: suspend RoutingContext.() -> String
) = post(path) { respondJson(codec) { block() } }

inline fun Routing.put(
    path: String,
    codec: StringFormat,
    noinline block: suspend RoutingContext.() -> String
) = put(path) { respondJson(codec) { block() } }

inline fun Routing.patch(
    path: String,
    codec: StringFormat,
    noinline block: suspend RoutingContext.() -> String
) = patch(path) { respondJson(codec) { block() } }

inline fun Routing.delete(
    path: String,
    codec: StringFormat,
    noinline block: suspend RoutingContext.() -> String
) = delete(path) { respondJson(codec) { block() } }

inline fun Routing.get(
    path: String,
    codec: StringFormat,
    noinline block: suspend RoutingContext.() -> String
) = get(path) { respondJson(codec) { block() } }