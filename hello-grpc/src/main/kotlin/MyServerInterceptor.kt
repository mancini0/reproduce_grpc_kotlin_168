package com.mancini

import io.grpc.*
import java.util.*

class MyServerInterceptor : ServerInterceptor {
    companion object {
        val AFTER_KEY = Context.key<String>("after-interception")
    }

    override fun <ReqT : Any, RespT : Any> interceptCall(call: ServerCall<ReqT, RespT>, headers: Metadata,
                                                         next: ServerCallHandler<ReqT, RespT>): ServerCall.Listener<ReqT> {

        headers.get(Metadata.Key.of("before-interception",
                Metadata.ASCII_STRING_MARSHALLER))?.let {

            val ctx = Context.current().withValue(AFTER_KEY, it)
            return Contexts.interceptCall(ctx, call, headers, next)
        }
        call.close(Status.UNAUTHENTICATED, headers)
        return object : ServerCall.Listener<ReqT>() {}
    }
}