package com.acai.eurekaserviceprovider;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {
    @RequestMapping(value="/list")
    public List<Map<String, Object>> list(){

        List<Map<String, Object>> result = new ArrayList<>();

        for(int i = 0; i < 3; i++){
            Map<String, Object> data = new HashMap<>();
            data.put("id", i+1);
            data.put("name", "test name " + i);
            data.put("age", 20+i);

            result.add(data);
        }

        return result;
    }
}
