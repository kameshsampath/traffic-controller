package com.redhat.developers;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.reactivestreams.Publisher;
import io.smallrye.reactive.messaging.annotations.Channel;

/**
 * TrafficSignalResource
 */
@Path("/traffic")
public class TrafficSignalResource {


    @Inject
    @Channel("traffic-signal-stream")
    Publisher<String> trafficSignalPublisher;


    @GET
    @Path("/flow")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Publisher<String> trafficFlow() {
        return trafficSignalPublisher;
    }
}
