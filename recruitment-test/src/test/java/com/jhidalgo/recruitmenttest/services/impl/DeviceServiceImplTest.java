package com.jhidalgo.recruitmenttest.services.impl;

import com.jhidalgo.recruitmenttest.domain.Device;
import com.jhidalgo.recruitmenttest.services.DeviceService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DeviceServiceImplTest {
    List<Device> devices = new ArrayList<>();
    DeviceService deviceService = new DeviceServiceImpl();

    private static final List<Device> FALLBACK = new ArrayList<>();

    @BeforeAll
    void setUp(){
        devices.add(new Device("58422422-9605-4b1d-b7d2-4e3a54a30c08",10L,
                "01-14-AA-0E-11-B4",true,97L,new Date(),-29L));
    }

    @Test
    void filter() {
        assertEquals(deviceService.filter(devices, 8L, 8L, false), FALLBACK);
        assertEquals(deviceService.filter(devices, 10L, 97L, false), FALLBACK);
        assertEquals(deviceService.filter(devices, 8L, 97L, false), FALLBACK);
        assertEquals(deviceService.filter(devices, 8L, 8L, true), FALLBACK);
        assertEquals(deviceService.filter(devices, 10L, 97L, true), devices);
    }

    @Test
    void filterByLocation() {
        assertEquals(deviceService.filterByLocation(devices, null), devices);
        assertEquals(deviceService.filterByLocation(devices, 8L), FALLBACK);
        assertEquals(deviceService.filterByLocation(devices, 10L), devices);
    }

    @Test
    void filterByParentLocation() {
        assertEquals(deviceService.filterByParentLocation(devices, null), devices);
        assertEquals(deviceService.filterByParentLocation(devices, 8L), FALLBACK);
        assertEquals(deviceService.filterByParentLocation(devices, 97L), devices);
    }

    @Test
    void filterByConnected() {
        assertEquals(deviceService.filterByConnected(devices, null), devices);
        assertEquals(deviceService.filterByConnected(devices, false), FALLBACK);
        assertEquals(deviceService.filterByConnected(devices, true), devices);
    }

    @Test
    void filterById() {
        assertEquals(deviceService.filterById(devices, null), FALLBACK);
        assertEquals(deviceService.filterById(devices, "58422422-9605-4b1d-b7d2-4e3a54a30c08"), devices);
    }

    @AfterAll
    void teardown(){
        devices.clear();
    }
}