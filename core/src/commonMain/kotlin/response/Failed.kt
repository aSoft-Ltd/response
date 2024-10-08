@file:JsExport
@file:Suppress("NON_EXPORTABLE_TYPE")

package response

import kase.internal.AbstractPossible
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.JsExport

@Serializable
data class Failed(
    override val status: Status,
    val error: ResponseError
) : AbstractPossible<Nothing>(), Response<Nothing> {

    @Transient
    private val exception by lazy { error.toException() }

    override fun valueOrThrow(exp: Throwable): Nothing = throw exp

    override fun valueOrThrow(msg: String): Nothing = valueOrThrow(Exception(msg, exception))

    override fun valueOrThrow(): Nothing = throw exception

    override fun valueOrNull(): Nothing? = null

    override fun exists(): Boolean = false

    override fun valueOr(default: Nothing): Nothing = default
}