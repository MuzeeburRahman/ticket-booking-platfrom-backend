package com.moviebooking.search.service.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TheatreID")
    private Long id;
    
    private String name;

    @ManyToOne
    @JoinColumn(name = "CityID")
    private City city;

    @OneToMany(mappedBy = "theatre")
    private List<Screen> screens;

    private String address;
}
