package com.jhidalgo.recruitmenttest.data.impl;

import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import com.jhidalgo.recruitmenttest.data.DeviceReader;
import com.jhidalgo.recruitmenttest.domain.Device;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

@Component
public class DeviceReaderImpl implements DeviceReader {

    private final static Logger LOG = LoggerFactory.getLogger(DeviceReaderImpl.class);

    private String devicePath;

    public DeviceReaderImpl() {
    }

    @Autowired
    public DeviceReaderImpl( @Value("${device.path}") String devicePath) {
        this.devicePath = devicePath;
    }


    @Override
    public List<Device> readDevices() {
        List<Device> devices = null;
        try {
            JsonReader reader = new JsonReader(new FileReader(devicePath));
            devices = Arrays.asList(new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                    .create()
                    .fromJson(reader, Device[].class));
        } catch (FileNotFoundException e) {
            LOG.error("devices.json was not found");
        }
        return devices;
    }
}
