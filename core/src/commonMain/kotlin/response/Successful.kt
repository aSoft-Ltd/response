@file:JsExport

package response

import kase.internal.AbstractPossible
import kotlinx.serialization.Serializable
import kotlinx.JsExport
import kotlin.js.JsName

@Serializable
data class Successful<out D>(
    override val status: Status,
    val data: D
) : AbstractPossible<D>(), Response<D> {

    @JsName("withData")
    constructor(data: D) : this(Status.CODE_200_Ok, data)

    override fun valueOrThrow(exp: Throwable) = throw exp

    override fun valueOrThrow(msg: String) = data

    override fun valueOrThrow() = data

    override fun valueOrNull() = data

    override fun exists() = true

    override fun valueOr(default: @UnsafeVariance D) = data
}