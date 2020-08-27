package com.mancini

import com.mancini.proto.hello.HelloGrpcKt
import com.mancini.proto.hello.HelloOuterClass.*
import io.grpc.inprocess.InProcessChannelBuilder
import io.grpc.inprocess.InProcessServerBuilder
import io.grpc.testing.GrpcCleanupRule
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import com.google.common.truth.Truth.assertThat
import io.grpc.ManagedChannel
import io.grpc.Server

class HelloServiceTest{

    @get:Rule
    val grpcCleanup = GrpcCleanupRule()

    private val serverName: String = InProcessServerBuilder.generateName()

    private val channel : ManagedChannel = grpcCleanup.register(InProcessChannelBuilder
            .forName(serverName).directExecutor().build())

    private val grpcServer : Server= grpcCleanup.register(InProcessServerBuilder
            .forName(serverName).directExecutor()
            .addService(HelloService())
            .build()).start()

    private val helloStub = HelloGrpcKt.HelloCoroutineStub(channel)


    @Test
    fun test(){
        runBlocking {
            val helloResponse = helloStub.sayHello(HelloRequest.newBuilder().setName("mike")
                    .build())

            assertThat(helloResponse.greeting).isEqualTo("Hello there mike!")

        }
    }
}