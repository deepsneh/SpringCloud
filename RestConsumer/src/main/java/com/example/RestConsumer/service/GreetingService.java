package com.example.RestConsumer.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.client.RestTemplate;

@Service
public class GreetingService {

    @Autowired
    FeignService feignService;

    @HystrixCommand(fallbackMethod = "defaultGreeting")
    public String getGreeting(String username) {
      //  return feignService.greet(username);
        //  return feignService.greet2();
            return new RestTemplate()
                    .getForObject("http://localhost:8083/greeting/{username}",
                            String.class, username);
    }

    private String defaultGreeting(String username) {
        return "Hello User!";
    }
}

