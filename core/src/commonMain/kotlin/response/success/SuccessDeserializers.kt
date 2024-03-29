package response.success

import response.Status
import response.Success
import response.payload.decodePayloadFromString
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

//import kotlinx.serialization.mapper.Mapper

fun <D> Json.decodeSuccessFromString(
    serializer: KSerializer<D>,
    json: String
): Success<D, Nothing?> {
//    val mapper = Mapper(this)
//    val map = mapper.decodeFromString(json)
//    val statusMap = map[Success<Any?, Any?>::status.name] as? Map<String, Any?> ?: throw Throwable(
//        "${Success<Any?, Any?>::status.name} field is missing in the response JSON"
//    )
//    val payloadMap = map[Success<Any?, Any?>::payload.name] as? Map<String, Any?> ?: throw Throwable(
//        "${Success<Any?, Any?>::payload.name} field is missing the response json"
//    )
//    val status = decodeFromString(Status.serializer(), mapper.encodeToString(statusMap))
//    val payload = decodePayloadFromString(serializer, mapper.encodeToString(payloadMap))
//    return Success(status, payload)
    TODO()
}

fun <D, I : Any> Json.decodeSuccessFromString(
    dataSerializer: KSerializer<D>,
    infoSerializer: KSerializer<I>,
    json: String
): Success<D, I> {
//    val mapper = Mapper(this)
//    val map = mapper.decodeFromString(json)
//    val statusMap = map[Success<Any?, Any?>::status.name] as? Map<String, Any?> ?: throw Throwable(
//        "${Success<Any?, Any?>::status.name} field is missing in the response JSON"
//    )
//    val payloadMap = map[Success<Any?, Any?>::payload.name] as? Map<String, Any?> ?: throw Throwable(
//        "${Success<Any?, Any?>::payload.name} field is missing the response json"
//    )
//    val status = decodeFromString(Status.serializer(), mapper.encodeToString(statusMap))
//    val payload = decodePayloadFromString(dataSerializer, infoSerializer, mapper.encodeToString(payloadMap))
//    return Success(status, payload)
    TODO()
}