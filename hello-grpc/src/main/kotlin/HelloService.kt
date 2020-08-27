package com.mancini

import com.mancini.proto.hello.HelloGrpcKt
import com.mancini.proto.hello.HelloOuterClass.*
import kotlinx.coroutines.flow.Flow


class HelloService : HelloGrpcKt.HelloCoroutineImplBase(){

    override suspend fun sayHello(request: HelloRequest):  HelloResponse {
        return HelloResponse.newBuilder()
                .setGreeting("Hello there ${request.name}!").build()
    }

}