package com.jhidalgo.recruitmenttest.services;

import com.jhidalgo.recruitmenttest.domain.Device;

import java.util.List;

public interface DeviceService {
    List<Device> filter(List<Device> devices, Long location, Long parentLocation, Boolean connected);

    List<Device> filterByLocation(List<Device> devices, Long location);

    List<Device> filterByParentLocation(List<Device> devices, Long parentLocation);

    List<Device> filterByConnected(List<Device> devices, Boolean connected);

    List<Device> filterById(List<Device> devices, String id);
}
