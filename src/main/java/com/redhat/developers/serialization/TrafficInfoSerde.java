package com.redhat.developers.serialization;

import com.redhat.developers.TrafficInfo;
import io.quarkus.kafka.client.serialization.JsonbSerde;

/**
 * TrafficInfoSerializer
 */
public class TrafficInfoSerde extends JsonbSerde<TrafficInfo> {

    public TrafficInfoSerde(){
        super(TrafficInfo.class);
    }
}