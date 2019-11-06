package com.acai.appclient.controller;

import com.acai.api.pojo.FeignTestPOJO;
import com.acai.appclient.service.FirstClientFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/id/{id}")
    public FeignTestPOJO getById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    /**
     * 一个参数，调用远程服务的时候，发起的请求是POST请求
     * @return
     */
    @GetMapping("/get")
    public FeignTestPOJO getByIdWithPOST(Long id){
        return this.service.getByIdWithPOST(id);
    }

    /**
     * 多个参数，调用远程服务的时候，发起的请求是GET请求
     * @return
     */
    @GetMapping("/add/{id}/{name}")
    public FeignTestPOJO add(@PathVariable("id") Long id, @PathVariable("name") String name){
        return this.service.add(id, name);
    }

    /**
     * 自定义类型参数，调用远程服务的时候，发起的请求是POST请求
     * feign技术远程访问application service的时候，默认情况下GET请求不能传递自定义类型参数
     * @return
     */
    @GetMapping("/add")
    public FeignTestPOJO add(FeignTestPOJO pojo){
        return this.service.addWithPOST(pojo);
    }
}
