package com.pm.analyticsservice.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import patient_event.PatientEvent;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "patient", groupId = "analytics-group")
    public void consumeEvent(byte[] event) {
        // Logic to consume the event from Kafka
        try {
            PatientEvent patientEvent = PatientEvent.parseFrom(event);
            log.info("Received PatientEvent [PatientId={}, PatientName={}, PatientEmail={}]", patientEvent.getPatientID(),
                    patientEvent.getName(), patientEvent.getEmail());
        } catch (InvalidProtocolBufferException e) {
            log.error("Error parsing PatientEvent {}", e.getMessage());
        }
    }
}
