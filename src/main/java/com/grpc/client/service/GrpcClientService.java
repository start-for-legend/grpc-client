package com.grpc.client.service;

import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import org.chb.examples.lib.HelloReply;
import org.chb.examples.lib.HelloRequest;
import org.chb.examples.lib.SimpleGrpc;

@Service
public class GrpcClientService {

    @GrpcClient("test")
    private SimpleGrpc.SimpleBlockingStub simpleStub;

    public String sendMessage(final String name) {
        try{
            HelloReply response = this.simpleStub.sayHello(HelloRequest.newBuilder().setName(name).build());
            return response.getMessage();
        } catch (StatusRuntimeException e) {
            return "FAILED with " + e.getStatus().getCode().name();
        }
    }
}
