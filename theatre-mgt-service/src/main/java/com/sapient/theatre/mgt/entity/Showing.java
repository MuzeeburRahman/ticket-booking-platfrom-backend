package com.sapient.theatre.mgt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "tb_showing")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Showing {
	@Id
	private String id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "theater_id")
	private Theatre theater;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "movie_id")
	private Movie movie;

	@Column(nullable = false)
	private String showTime;

	@Column(nullable = false)
	private int totalSeats;

	@Column(nullable = false)
	private int bookedSeats;
}
