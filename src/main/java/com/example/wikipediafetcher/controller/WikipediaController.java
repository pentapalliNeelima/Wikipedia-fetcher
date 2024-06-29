package com.example.wikipediafetcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class WikipediaController {

    @GetMapping("/fetch")
    @ResponseBody
    public String fetchWikipedia(@RequestParam String query) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://en.wikipedia.org/api/rest_v1/page/summary/" + query;
        return restTemplate.getForObject(url, String.class);
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
