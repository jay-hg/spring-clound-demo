package com.acai.api.pojo;

import lombok.Data;

@Data
public class FeignTestPOJO {
    private Long id;
    private String name;

    public FeignTestPOJO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public FeignTestPOJO() {
    }
}
