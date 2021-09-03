package com.jhidalgo.recruitmenttest.domain;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Device {

    public Device(String id, Long location, String macAddress, boolean connected, Long parentLocation, Date updatedAt, Long signal) {
        this.id = id;
        this.location = location;
        this.macAddress = macAddress;
        this.connected = connected;
        this.parentLocation = parentLocation;
        this.updatedAt = updatedAt;
        this.signal = signal;
    }

    private String id;

    private Long location;

    @SerializedName(value = "mac_address")
    private String macAddress;

    private boolean connected;

    @SerializedName(value = "parent_location")
    private Long parentLocation;

    @SerializedName(value = "updated_at")
    private Date updatedAt;

    private Long signal;

    public Long getLocation() {
        return location;
    }

    public boolean isConnected() {
        return connected;
    }

    public Long getParentLocation() {
        return parentLocation;
    }

    public String getId() { return id; }

    public String getMacAddress() { return macAddress; }

    public Date getUpdatedAt() { return updatedAt; }

    public Long getSignal() { return signal; }
}
