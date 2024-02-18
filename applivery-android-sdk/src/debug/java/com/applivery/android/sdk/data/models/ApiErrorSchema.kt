package com.applivery.android.sdk.data.models

import com.google.gson.annotations.SerializedName

sealed class ApiError(message: String?) : Throwable(message){
    class LimitExceeded(message: String?) : ApiError(message)
    class Unauthorized(message: String?) : ApiError(message)
    class Subscription(message: String?) : ApiError(message)
    class Internal(message: String? = null) : ApiError(message)
    class IO : ApiError(null)
}

// TODO: test with real call if this is the expected schema
data class ApiErrorSchema(
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("data") val data: Map<String, Any>?
) {
    fun toApiError(): ApiError {
        return when (code) {
            LIMIT_EXCEEDED_ERROR -> ApiError.LimitExceeded(message)
            UNAUTHORIZED_ERROR -> ApiError.Unauthorized(message)
            SUBSCRIPTION_ERROR -> ApiError.Subscription(message)
            else -> ApiError.Internal(message)
        }
    }
}

private const val LIMIT_EXCEEDED_ERROR = 5003
private const val UNAUTHORIZED_ERROR = 4004
private const val SUBSCRIPTION_ERROR = 5004

