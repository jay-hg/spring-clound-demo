package com.acai.api.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface FirstFeignService {

    @RequestMapping(value = "/testFeign",method = RequestMethod.GET)
    public List<String> testFeign();
}
