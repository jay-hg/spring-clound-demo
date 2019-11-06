package com.acai.appservice.controller;

import com.acai.api.pojo.FeignTestPOJO;
import com.acai.api.service.FirstFeignService;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Override
    public FeignTestPOJO getById(Long id) {
        return new FeignTestPOJO(id, "getById");
    }

    /**
     * 如果方法参数是处理POST请求的JSON数据的。
     * 那么还是需要定义@RequestBody注解来描述方法参数的。
     */
    @Override
    public FeignTestPOJO getByIdWithPOST(@RequestBody Long id) {
        return new FeignTestPOJO(id, "getByIdWithPOST");
    }

    @Override
    public FeignTestPOJO add(Long id, String name) {
        System.out.println( "add(Long id, String name)" );
        return new FeignTestPOJO(id, name);
    }

    /**
     * 在默认的情况下，Feign不能通过GET请求传递自定义类型的请求参数。
     */
    @Override
    public FeignTestPOJO add(@RequestBody FeignTestPOJO pojo) {
        System.out.println( "add(@RequestBody FeignTestPOJO pojo)" );
        return pojo;
    }

    @Override
    public FeignTestPOJO addWithPOST(@RequestBody FeignTestPOJO pojo) {
        System.out.println( "addWithPOST(@RequestBody FeignTestPOJO pojo)" );
        return pojo;
    }
}
