package com.grpc.client.controller;

import com.grpc.client.service.GrpcClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GrpcController {

    private final GrpcClientService grpcClientService;

    @GetMapping("/test")
    public String printMessage() {
        return grpcClientService.sendMessage("HI?");
    }
}
