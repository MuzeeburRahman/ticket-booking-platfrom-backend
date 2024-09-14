package com.moviebooking.search.service.service;

import com.moviebooking.search.service.dto.TheatreSearchResponse;
import com.moviebooking.search.service.model.Theatre;
import com.moviebooking.search.service.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    private static final Logger logger = LoggerFactory.getLogger(SearchService.class);

    @Autowired
    private TheatreRepository theatreRepository;

    public List<TheatreSearchResponse> searchTheatres(Long movieId, String cityName, Date showDate) {
        logger.info("Searching for theatres showing movieId: {} in city: {} on date: {}", movieId, cityName, showDate);
        
        List<Theatre> theatres = theatreRepository.findByCityNameAndScreensShowsMovieIdAndScreensShowsShowDate(cityName, movieId, showDate);

        return theatres.stream().map(this::mapToTheatreResponse).collect(Collectors.toList());
    }

    private TheatreSearchResponse mapToTheatreResponse(Theatre theatre) {
        TheatreSearchResponse response = new TheatreSearchResponse();
        response.setTheatreName(theatre.getName());
        response.setAddress(theatre.getAddress());
        response.setShows(
                theatre.getScreens().stream().flatMap(screen ->
                        screen.getShows().stream().map(show -> {
                            TheatreSearchResponse.ShowDetail showDetail = new TheatreSearchResponse.ShowDetail();
                            showDetail.setScreenType(screen.getScreenType());
                            showDetail.setShowTime(show.getShowTime().toString());
                            return showDetail;
                        })).collect(Collectors.toList())
        );
        return response;
    }
}
