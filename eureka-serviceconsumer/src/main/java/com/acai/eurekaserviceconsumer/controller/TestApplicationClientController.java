package com.acai.eurekaserviceconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
public class TestApplicationClientController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/list")
    public List<Map<String, Object>> test() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-serviceprovider");

        // 拼接访问服务的URL
        StringBuilder sb = new StringBuilder();
        sb.append("http://").append(serviceInstance.getHost())
                .append(":").append(serviceInstance.getPort()).append("/list");

        System.out.println("本次访问的service是： " + sb.toString());

        RestTemplate restTemplate = new RestTemplate();

        ParameterizedTypeReference<List<Map<String, Object>>> type =
                new ParameterizedTypeReference<List<Map<String, Object>>>(){
                };

        ResponseEntity<List<Map<String, Object>>> responseEntity =
                restTemplate.exchange(sb.toString(), HttpMethod.GET, null, type);

        return responseEntity.getBody();
    }
}
