package com.redhat.developers;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * TrafficSignal
 */
public class TrafficSignalInfo {

    private String timestamp;
    private int east;
    private int west;
    private int north;
    private int south;

    public TrafficSignalInfo build(TrafficInfo trafficInfo) {
        this.setEast(computeTrafficTimeout(trafficInfo.getEasternTraffic()));
        this.setWest(computeTrafficTimeout(trafficInfo.getWesternTraffic()));
        this.setNorth(computeTrafficTimeout(trafficInfo.getNorthernTraffic()));
        this.setSouth(computeTrafficTimeout(trafficInfo.getSouthernTraffic()));
        this.setTimestamp(LocalDateTime.now(ZoneId.of("GMT+05:30")).toString());
        return this;
    }

    public int getSouth() {
        return south;
    }

    public void setSouth(int south) {
        this.south = south;
    }

    public int getNorth() {
        return north;
    }

    public void setNorth(int north) {
        this.north = north;
    }

    public int getWest() {
        return west;
    }

    public void setWest(int west) {
        this.west = west;
    }

    public int getEast() {
        return east;
    }

    public void setEast(int east) {
        this.east = east;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    private int computeTrafficTimeout(int trafficVol) {
        if (trafficVol > 30) {
            return 30;
        } else if (trafficVol > 15
                && trafficVol < 30) {
            return 15;
        } 
        return 10;
    }
}
