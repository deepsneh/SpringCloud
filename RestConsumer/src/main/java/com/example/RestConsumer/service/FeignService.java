package com.example.RestConsumer.service;


import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "jplaceholder", url = "localhost:8083")
public interface FeignService {
    @RequestMapping(method = RequestMethod.GET, value = "/greeting/{username}")
    String greet(String username) ;

    @RequestMapping(method = RequestMethod.GET, value = "/greeting")
    String greet2() ;
}
