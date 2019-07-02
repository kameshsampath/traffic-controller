package com.redhat.developers.serialization;

import com.redhat.developers.TrafficInfo;
import io.quarkus.kafka.client.serialization.JsonbDeserializer;

/**
 * TrafficInfoDeserializer
 */
public class TrafficInfoDeserializer extends JsonbDeserializer<TrafficInfo> {

    public TrafficInfoDeserializer() {
        super(TrafficInfo.class);
    }
}