package com.example.feign.web;

import com.example.feign.model.Post;
import com.example.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeignController {

    @Autowired
    FeignService feignService;

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public ResponseEntity<?> test() {
        List list = feignService.getPosts();
        return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test/{postId}")
    public ResponseEntity<?> test2(@PathVariable("postId") Long postId) {
        Post p = feignService.getPostById(postId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/post")
    public ResponseEntity<?> Post() {
        return new ResponseEntity<>(feignService.posts(), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/greet/{username}")
    public ResponseEntity<?> greet(@PathVariable("username") String username) {
        return new ResponseEntity<>(feignService.greeting(username), HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/greetme/{username}")
    public ResponseEntity<?> greetme(@PathVariable("username") String username) {
        return new ResponseEntity<>(feignService.produce(username), HttpStatus.CREATED);

    }


    @RequestMapping(method = RequestMethod.GET, value = "/userdetails")
    public ResponseEntity<?> getUserDetails() {
        return new ResponseEntity<>(feignService.viewUser("test"), HttpStatus.CREATED);
    }

}
