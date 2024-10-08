@file:JsExport

package response

import kase.Possible
import kotlinx.JsExport

sealed interface  Response<out D> : Possible<D> {
    val status: Status

    val asSuccessful get() = this as? Successful
    val asFailure get() = this as? Failed

    val message
        get() = when (this) {
            is Successful -> "Succeeded ✅"
            is Failed -> "Failed ❌"
        }
}