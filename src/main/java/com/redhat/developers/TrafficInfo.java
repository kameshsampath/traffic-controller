package com.redhat.developers;

/**
 * TrafficInfo
 */
public class TrafficInfo {

    private String id;
    private int easternTraffic;
    private int westernTraffic;
    private int northernTraffic;
    private int southernTraffic;

    public int getEasternTraffic() {
        return easternTraffic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSouthernTraffic() {
        return southernTraffic;
    }

    public void setSouthernTraffic(int southernTraffic) {
        this.southernTraffic = southernTraffic;
    }

    public int getNorthernTraffic() {
        return northernTraffic;
    }

    public void setNorthernTraffic(int northernTraffic) {
        this.northernTraffic = northernTraffic;
    }

    public int getWesternTraffic() {
        return westernTraffic;
    }

    public void setWesternTraffic(int westernTraffic) {
        this.westernTraffic = westernTraffic;
    }

    public void setEasternTraffic(int easternTraffic) {
        this.easternTraffic = easternTraffic;
    }
}