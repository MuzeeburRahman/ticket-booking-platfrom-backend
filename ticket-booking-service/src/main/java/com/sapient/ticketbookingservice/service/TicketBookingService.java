package com.sapient.ticketbookingservice.service;

import java.util.UUID;

import com.sapient.ticketbookingservice.dto.BookTicketRequest;
import com.sapient.ticketbookingservice.dto.Response;
import com.sapient.ticketbookingservice.dto.ValidationDto;
import com.sapient.ticketbookingservice.exceptions.InvalidTokenException;
import com.sapient.ticketbookingservice.exceptions.ResourceNotFoundException;
import com.sapient.ticketbookingservice.feign.AuthClient;
import com.sapient.ticketbookingservice.model.TicketBooking;
import com.sapient.ticketbookingservice.repository.ShowingRepository;
import com.sapient.ticketbookingservice.repository.TicketBookingRepository;
import com.sapient.ticketbookingservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.ticketbookingservice.model.Showing;
import com.sapient.ticketbookingservice.model.User;

@Service
public class TicketBookingService {
	@Autowired
	private AuthClient authClient;
	@Autowired
	private ShowingRepository showingRepository;
	@Autowired
	private TicketBookingRepository bookingRepository;
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public Response bookTicket(String token, BookTicketRequest request) {
		String invalidMsg = "Invalid Token";
		try {
			ValidationDto authResponse = authClient.validateAuthToken(token);
			if (authResponse.isStatus()) {

				// Only CUSTOMER can perform the book ticket operation
				if (authResponse.getRole().equals("CUSTOMER")) {

					// Retrieve the show details
					Showing show = showingRepository.findById(request.getShowingId()).orElseThrow(
							() -> new ResourceNotFoundException("No show found with id: " + request.getShowingId()));

					// Find the remaining seats available for the show
					int remainingSeats = show.getTotalSeats() - show.getBookedSeats();

					// If requested seat count is less than or equal to remaining seats
					if (request.getSeats() <= remainingSeats) {
						show.setBookedSeats(show.getBookedSeats() + request.getSeats());

						// Retrieve the user details
						User user = userRepository.findById(authResponse.getUserId()).orElse(null);

						TicketBooking ticket = TicketBooking.builder().id(generateRandomId()).showing(show).user(user)
								.numSeats(request.getSeats()).status("CONFIRM").build();

						// Save the ticket and show record
						bookingRepository.save(ticket);
						showingRepository.save(show);

						// Return response
						return Response.builder().status("success").message("Ticket booking successfull").build();
					} else
						throw new RuntimeException("Ticket not available!");
				} else
					throw new InvalidTokenException("Only a customer can perform ticket book");
			} else
				throw new InvalidTokenException(invalidMsg);
		} catch (Exception e) {
			throw e;
		}
	}

	private String generateRandomId() {
		return "TB" + UUID.randomUUID().toString();
	}

}
