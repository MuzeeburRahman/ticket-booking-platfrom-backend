package com.moviebooking.search.service.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Screen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ScreenID")
    private Long id;

    @Column(name = "screen_number")
    private String screenNumber;

    @Column(name = "screen_type")
    private String screenType;
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "TheatreID")
    private Theatre theatre;

    @OneToMany(mappedBy = "screen")
    private List<Show> shows;
}
