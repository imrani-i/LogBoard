package com.example.logboard.grpc;

import com.example.logproto.LogRequest;
import com.example.logproto.LogResponse;
import com.example.logproto.LogServiceGrpc;
import io.grpc.stub.StreamObserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class LogServiceImpl extends LogServiceGrpc.LogServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

    @Override
    public void sendLog(LogRequest request, StreamObserver<LogResponse> responseObserver) {
        // 1. 들어온 로그를 서버 콘솔에 출력
        logger.info("[{}] {} - {}", request.getLevel(), request.getService(), request.getMessage());

        // 2. 응답 객체 생성
        LogResponse response = LogResponse.newBuilder()
                .setStatus("OK")
                .build();

        // 3. 클라이언트에 응답 전달
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}