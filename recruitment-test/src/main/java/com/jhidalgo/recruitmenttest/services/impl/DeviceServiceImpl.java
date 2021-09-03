package com.jhidalgo.recruitmenttest.services.impl;

import com.jhidalgo.recruitmenttest.data.DeviceReader;
import com.jhidalgo.recruitmenttest.domain.Device;
import com.jhidalgo.recruitmenttest.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    public DeviceServiceImpl(DeviceReader deviceReader) {
        this.deviceReader = deviceReader;
    }

    public DeviceServiceImpl() { }

    private DeviceReader deviceReader;

    @Override
    public List<Device> filter(List<Device> devices, Long location, Long parentLocation, Boolean connected) {
        devices = filterByLocation(devices, location);
        devices = filterByParentLocation(devices, parentLocation);
        devices = filterByConnected(devices, connected);
        return devices;
    }

    @Override
    public List<Device> filterByLocation(List<Device> devices, Long location) {
        if(location == null) return devices;
        return devices.stream().filter(device -> device.getLocation().equals(location)).collect(Collectors.toList());
    }

    @Override
    public List<Device> filterByParentLocation(List<Device> devices, Long parentLocation) {
        if(parentLocation == null) return devices;
        return devices.stream().filter(device -> device.getParentLocation().equals(parentLocation) && parentLocation != 0).collect(Collectors.toList());
    }

    @Override
    public List<Device> filterByConnected(List<Device> devices, Boolean connected) {
        if(connected == null) return devices;
        return devices.stream().filter(device -> device.isConnected() == connected).collect(Collectors.toList());
    }

    @Override
    public List<Device> filterById(List<Device> devices, String id) {
        if(id == null) return new ArrayList<>();
        return devices.stream().filter(device -> device.getId().equals(id)).collect(Collectors.toList());
    }
}
