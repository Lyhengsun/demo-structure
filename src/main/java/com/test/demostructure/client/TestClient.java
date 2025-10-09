package com.test.demostructure.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "test-service", path = "")
public interface TestClient {

}
