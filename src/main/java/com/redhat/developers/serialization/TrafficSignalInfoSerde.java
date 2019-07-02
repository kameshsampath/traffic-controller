package com.redhat.developers.serialization;

import com.redhat.developers.TrafficSignalInfo;
import io.quarkus.kafka.client.serialization.JsonbSerde;

/**
 * TrafficSignalInfoSerde
 */
public class TrafficSignalInfoSerde extends JsonbSerde<TrafficSignalInfo> {

    public TrafficSignalInfoSerde(){
        super(TrafficSignalInfo.class);
    }
    
}