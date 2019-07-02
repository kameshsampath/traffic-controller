package com.redhat.developers;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import io.smallrye.reactive.messaging.annotations.Broadcast;

/**
 * TrafficTimeoutComputer
 */
@ApplicationScoped
public class TrafficTimeoutComputer {


    @Incoming("trafficinfo")
    @Outgoing("traffic-signal-stream")
    @Broadcast
    public TrafficSignalInfo generateTimeout(TrafficInfo trafficInfo) {
        return new TrafficSignalInfo().build(trafficInfo);
    }

}