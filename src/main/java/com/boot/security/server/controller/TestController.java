package com.boot.security.server.controller;

import com.boot.security.server.model.RestResponse;
import com.boot.security.server.util.ReturnUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Title: 测试
 * @Description:
 * @Company:
 * @Author: hudi
 * @Create: Date:2020年12月09日
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello_word")
    public RestResponse<String> helloWord() {

        return new RestResponse<>("hello word!");
    }
}
