package com.example.logboard.config;

import com.example.logboard.grpc.LogServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;


@Configuration
public class GrpcServerConfig {

    private final LogServiceImpl logService;
    private Server server;

    public GrpcServerConfig(LogServiceImpl logService) {
        this.logService = logService;
    }

    @PostConstruct
    public void start() throws IOException {
        this.server = ServerBuilder.forPort(9090)
                .addService(logService)
                .build()
                .start();
        System.out.println("🚀 gRPC Server started on port 9090");
    }

    @PreDestroy
    public void stop() {
        if (server != null) {
            server.shutdown();
        }
    }
}
