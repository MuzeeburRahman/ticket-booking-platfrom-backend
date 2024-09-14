package com.moviebooking.search.service.controller;

import com.moviebooking.search.service.dto.TheatreSearchResponse;
import com.moviebooking.search.service.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/theatres")
    public List<TheatreSearchResponse> searchTheatres(@RequestParam Long movieId, @RequestParam String cityName, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date showDate) {
        return searchService.searchTheatres(movieId, cityName, showDate);
    }
}
