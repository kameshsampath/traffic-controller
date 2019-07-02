package com.redhat.developers.serialization;

import com.redhat.developers.TrafficSignalInfo;
import io.quarkus.kafka.client.serialization.JsonbDeserializer;

/**
 * TrafficSignalInfoDeserializer
 */
public class TrafficSignalInfoDeserializer extends JsonbDeserializer<TrafficSignalInfo> {

    public TrafficSignalInfoDeserializer() {
        super(TrafficSignalInfo.class);
    }
}