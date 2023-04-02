package com.ss.BookingService.service;

import java.util.List;

import com.ss.BookingService.entity.Booking;
import com.ss.BookingService.exceptions.BookingNotFoundException;

public interface BookingService {

	
    // Save operation
	Booking saveBooking(Booking route);
 
    // Read operation
    List<Booking> fetchBookingList() throws BookingNotFoundException;
    
    // Read operation
    Booking fetchBooking(Long routeId) throws BookingNotFoundException;
 
    // Update operation
    Booking updateBooking(Booking route,
                                Long routeId) throws BookingNotFoundException;
 
    // Delete operation
    void deleteBookingById(Long routeId) throws BookingNotFoundException;
}
