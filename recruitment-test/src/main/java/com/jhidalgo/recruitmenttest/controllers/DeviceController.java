package com.jhidalgo.recruitmenttest.controllers;

import com.jhidalgo.recruitmenttest.data.DeviceReader;
import com.jhidalgo.recruitmenttest.domain.Device;
import com.jhidalgo.recruitmenttest.services.DeviceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("devices")
public class DeviceController {

    final private DeviceService deviceService;

    final private DeviceReader deviceReader;

    public DeviceController(DeviceService deviceService, DeviceReader deviceReader) {
        this.deviceService = deviceService;
        this.deviceReader = deviceReader;
    }

    @RequestMapping("/{id:.+}")
    public List<Device> device(final @PathVariable String id) {
        final List<Device> devices = deviceReader.readDevices();
        return deviceService.filterById(devices, id);
    }

    @CrossOrigin
    @RequestMapping("/")
    public List<Device> devices(final @RequestParam(required = false) Long location,
                                final @RequestParam(required = false) Long parentLocation,
                                final @RequestParam(required = false) Boolean connected) {
        final List<Device> devices = deviceReader.readDevices();
        return deviceService.filter(devices, location, parentLocation, connected);
    }
}
