package response.payload

import response.Payload
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json

//import kotlinx.serialization.mapper.Mapper

fun <D> Json.decodePayloadFromString(
    serializer: KSerializer<D>,
    json: String
): Payload<out D, out Nothing?> {
//    val mapper = Mapper(this)
//    val map = mapper.decodeFromString(json)
//    val dataValue = map[Payload<Any?, Any?>::data.name]
//    val data = when (dataValue) {
//        is Map<Any?, Any?> -> decodeFromString(serializer, mapper.encodeToString(dataValue as Map<String, Any?>))
//        is List<Any?> -> decodeFromString(serializer, mapper.encodeToString(dataValue as List<Map<String, Any?>>))
//        else -> decodeFromString(serializer, """"$dataValue"""")
//    }
//    return payloadOf(data)
    TODO()
}

fun <D, I> Json.decodePayloadFromString(
    dataSerializer: KSerializer<D>,
    infoSerializer: KSerializer<I>,
    json: String
): Payload<out D, out I> {
//    val mapper = Mapper(this)
//    val map = mapper.decodeFromString(json)
//    val infoValue = map[Payload<Any?, Any?>::info.name] as Map<String, Any?>
//    val dataValue = map[Payload<Any?, Any?>::data.name]
//    val info = decodeFromString(infoSerializer, mapper.encodeToString(infoValue))
//    val data = when (dataValue) {
//        is Map<Any?, Any?> -> decodeFromString(dataSerializer, mapper.encodeToString(dataValue as Map<String, Any?>))
//        is List<Any?> -> decodeFromString(dataSerializer, mapper.encodeToString(dataValue as List<Map<String, Any?>>))
//        else -> decodeFromString(dataSerializer, dataValue.toString())
//    }
//    return payloadOf(data, info)
    TODO()
}