package com.acai.appservice.controller;

import com.acai.api.service.FirstFeignService;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestFeignAppServiceController implements FirstFeignService {
    @Override
    public List<String> testFeign() {
        List<String> result = new ArrayList<>();

        result.add("test feign");
        result.add("this is first spring cloud with feign");

        return result;
    }
}
