package com.redhat.developers;

import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.jboss.logging.Logger;
import io.smallrye.reactive.messaging.annotations.Broadcast;
import io.vertx.core.json.JsonObject;

/**
 * TrafficTimeoutComputer
 */
@ApplicationScoped
public class TrafficTimeoutComputer {


    Logger logger = Logger.getLogger(TrafficTimeoutComputer.class);

    @Incoming("traffic-info-stream")
    @Outgoing("traffic-signal-stream")
    @Broadcast
    public String generateTimeout(TrafficInfo trafficInfo) {
        TrafficSignalInfo info = new TrafficSignalInfo().build(trafficInfo);
        JsonObject rep = JsonObject.mapFrom(info);
        logger.debugf("Signal JSON: %s",rep);
        return rep.encodePrettily();
    }

    //TODO: Unable to push POJO where to configure??
    // @Incoming("traffic-info-stream")
    // @Outgoing("traffic-signal-stream")
    // @Broadcast
    // public TrafficSignalInfo generateTimeout(TrafficInfo trafficInfo) {
    //     TrafficSignalInfo info = new TrafficSignalInfo().build(trafficInfo);
    //     return info;
    // }

}
