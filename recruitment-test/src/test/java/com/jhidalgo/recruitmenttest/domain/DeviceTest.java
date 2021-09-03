package com.jhidalgo.recruitmenttest.domain;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeviceTest {
    Date updatedDate = new Date();
    Device device = new Device("58422422-9605-4b1d-b7d2-4e3a54a30c08",10L,
            "01-14-AA-0E-11-B4",true,97L,updatedDate, -29L);

    @Test
    void getLocation() {
        assertEquals(device.getLocation(), 10L);
    }

    @Test
    void isConnected() {
        assertEquals(device.isConnected(), true);
    }

    @Test
    void getParentLocation() {
        assertEquals(device.getParentLocation(), 97L);
    }

    @Test
    void getId() {
        assertEquals(device.getId(), "58422422-9605-4b1d-b7d2-4e3a54a30c08");
    }

    @Test
    void getMacAddress() {
        assertEquals(device.getMacAddress(), "01-14-AA-0E-11-B4");
    }

    @Test
    void getUpdatedAt() {
        assertEquals(device.getUpdatedAt(), updatedDate);
    }

    @Test
    void getSignal() {
        assertEquals(device.getSignal(), -29L);
    }
}