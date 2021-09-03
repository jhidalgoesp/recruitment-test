package com.jhidalgo.recruitmenttest.data.impl;

import com.jhidalgo.recruitmenttest.data.DeviceReader;
import com.jhidalgo.recruitmenttest.domain.Device;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestPropertySource(properties = {"device.path:./devices.json"})
class DeviceReaderImplTest {

    @Value("${device.path}")
    private String devicePath;

    @Test
    void readDevices(){
        DeviceReader deviceReader = new DeviceReaderImpl(devicePath);
        Device device = new Device("58422422-9605-4b1d-b7d2-4e3a54a30c08",10L,
                "01-14-AA-0E-11-B4",true,97L,new Date(),-29L);
        List<Device> devices = deviceReader.readDevices();
        Optional<Device> deviceFound = devices.stream().filter(device1 -> device1.getId().equals(device.getId())).findFirst();
        assertTrue(deviceFound.isPresent());
    }
}