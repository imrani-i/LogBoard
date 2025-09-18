package com.example.logboard;
// src/test/java/com/example/logboard/LogClientTest.java

import com.example.logproto.LogRequest;
import com.example.logproto.LogResponse;
import com.example.logproto.LogServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.Test;

public class LogClientTest {

    @Test
    public void testSendLog() {
        // 1. gRPC 채널 생성
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        // 2. 스텁 생성
        LogServiceGrpc.LogServiceBlockingStub stub = LogServiceGrpc.newBlockingStub(channel);

        // 3. 요청 생성
        LogRequest request = LogRequest.newBuilder()
                .setService("test-service")
                .setLevel("INFO")
                .setMessage("Hello gRPC!")
                .setTimestamp(Long.toString(System.currentTimeMillis()))
                .build();

        // 4. 호출
        LogResponse response = stub.sendLog(request);
        System.out.println("✅ Server Response: " + response.getStatus());

        // 5. 종료
        channel.shutdown();
    }
}
