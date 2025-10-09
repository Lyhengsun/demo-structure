package com.test.demostructure.controller;

import com.test.demostructure.model.dto.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tests")
public class TestController extends BaseController {

    @GetMapping
    ResponseEntity<ApiResponse<String>> test() {
        return responseEntity("Hello World");
    }
}
