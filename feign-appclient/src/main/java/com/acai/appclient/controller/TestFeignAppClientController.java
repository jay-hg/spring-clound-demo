package com.acai.appclient.controller;

import com.acai.appclient.service.FirstClientFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestFeignAppClientController {

    @Autowired
    private FirstClientFeignService service;

    @GetMapping("/testFeign")
    public List<String> testFeign() {
        System.out.println(this.service.getClass().getName());
        return this.service.testFeign();
    }
}
