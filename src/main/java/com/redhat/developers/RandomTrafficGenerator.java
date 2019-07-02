package com.redhat.developers;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import io.reactivex.Flowable;

/**
 * RandomTrafficGenerator
 */
@ApplicationScoped
public class RandomTrafficGenerator {

    Random random = new Random();
    @Outgoing("traffic-info-stream")
    public Flowable<TrafficInfo> generate(){
           return Flowable
           .interval(10, TimeUnit.SECONDS)
           .map(tick -> {
               TrafficInfo trafficInfo = new TrafficInfo();
               trafficInfo.setId("mgroad");
               trafficInfo.setEasternTraffic(random.nextInt(100));
               trafficInfo.setWesternTraffic(random.nextInt(100));
               trafficInfo.setNorthernTraffic(random.nextInt(100));
               trafficInfo.setSouthernTraffic(random.nextInt(100));
               return trafficInfo;
           });
    }
    
}