package com.moviebooking.search.service.dto;

import lombok.Data;
import java.util.List;

@Data
public class TheatreSearchResponse {
    private String theatreName;
    private String address;
    private List<ShowDetail> shows;

    @Data
    public static class ShowDetail {
        private String screenType;
        private String showTime;
    }
}
