package com.example.demo.Controller;

import Model.Movies;
import Service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class moviecontroller {
    private MovieService movieService = new MovieService();

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Welcome to the Movie Database";
    }

    @GetMapping("/getFirst")
    @ResponseBody
    public String findFirst() {
        Movies movies = movieService.findFirstMovie();
        return movieService.findFirstMovie().toString();
    }

    @GetMapping("/getRandom")
    @ResponseBody
    public String findRandom() {
        return movieService.findRandomMovie();
    }
    @GetMapping("/getTenSortByPopularity")
    @ResponseBody
    public String findTenMostPopular(){
        return movieService.getTenSortByPop().toString();
    }
    @GetMapping("/howManyWonAnAward")
    @ResponseBody
    public int howManyWonAnAward(){return movieService.findAward();}

    @GetMapping("/howManyComedyAward")
    @ResponseBody
    public String howManyWonComedyAward(){return movieService.findComedyAward().toString();}
}