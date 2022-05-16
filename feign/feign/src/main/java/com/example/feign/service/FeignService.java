package com.example.feign.service;


import com.example.feign.model.Post;
import feign.Param;
import feign.RetryableException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.UnknownHostException;
import java.util.List;

@FeignClient(value = "jplaceholder", url = "localhost:8080")
public interface FeignService {

    @RequestMapping(method = RequestMethod.GET, value = "/posts")
    List<Post> getPosts() throws RetryableException;

    @RequestMapping(method = RequestMethod.POST, value = "/posts")
    Post posts();

    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = "application/json")
    Post getPostById(@PathVariable("postId") Long postId);

    @RequestMapping(method = RequestMethod.GET, value = "/greeting/{username}")
    String greeting(@PathVariable("username") String username);

    @RequestMapping(method = RequestMethod.GET, value = "/produce/{username}")
    String produce(@PathVariable("username") String username);

    @RequestMapping(method = RequestMethod.GET, value = "/view/user/details")
    String viewUser(@RequestHeader(value = "X-COM-PERSIST", required = true) String authorizationHeader);

}

