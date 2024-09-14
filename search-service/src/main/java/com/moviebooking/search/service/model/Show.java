package com.moviebooking.search.service.model;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Data
@Entity
@Table(name = "Showing")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShowID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "MovieID")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "ScreenID")
    private Screen screen;

    private LocalTime showTime;
    @Column(name = "Date")
    private Date showDate;
}
