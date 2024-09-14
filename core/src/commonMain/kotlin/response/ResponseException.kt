package response

abstract class ResponseException : RuntimeException() {
    abstract val status: Status
}