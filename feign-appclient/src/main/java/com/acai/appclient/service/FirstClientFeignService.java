package com.acai.appclient.service;

import com.acai.api.service.FirstFeignService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "feign-appservice")
public interface FirstClientFeignService extends FirstFeignService {
}
