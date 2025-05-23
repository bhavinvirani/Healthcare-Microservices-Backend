package com.pm.patientservice.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BillingServiceGrpcClient {
    private final BillingServiceGrpc.BillingServiceBlockingStub blockingStub;

    //localhost:9091/BillingService/CreatePatientAccount
    public BillingServiceGrpcClient(
            @Value("${billing.service.address:localhost}") String serverAddress,
            @Value("${billing.service.grpc.port: 9001}") int serverPort) {

        log.info("Server address: {}", serverAddress);


        // Create a gRPC channel to the billing service
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress, serverPort)
                .usePlaintext()
                .build();

        // Create a blocking stub for the billing service
        this.blockingStub = BillingServiceGrpc.newBlockingStub(channel);
    }

        public BillingResponse createBillingAccount(String patientId, String name, String email) {
            // Create a request object
            BillingRequest request = BillingRequest.newBuilder()
                .setPatientId(patientId)
                .setName(name)
                .setEmail(email)
                .build();

        // Call the gRPC method and get the response
        BillingResponse response = blockingStub.createBillingAccount(request);
        log.info("Received response from billing service: {}", response);
        return response;
    }

}
