package com.ss.BookingService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ss.BookingService.entity.Booking;
import com.ss.BookingService.exceptions.BookingNotFoundException;
import com.ss.BookingService.service.BookingService;

@RestController
public class BookingContoller {
	
	
	@Autowired  
	BookingService bookingService;
	
	
	@GetMapping("/booking")  
	private ResponseEntity<List<Booking>> getAllBusRoutes() throws BookingNotFoundException 
	{  
	return new ResponseEntity<>(bookingService.fetchBookingList(), 
			   HttpStatus.OK);
	}  
	
	@GetMapping("/booking/{bookingid}")  
	private ResponseEntity<Booking> getBusroutesId(@PathVariable("bookingid") long busroutesid) throws BookingNotFoundException  
	{  
	return new ResponseEntity<>(bookingService.fetchBooking(busroutesid), 
			   HttpStatus.OK);
	}  
	
	@DeleteMapping("/booking/{bookingid}")  
	private ResponseEntity<String> deleteBook(@PathVariable("bookingid") long busroutesid)  throws BookingNotFoundException 
	{  
		try{
			bookingService.deleteBookingById(busroutesid);  
			return ResponseEntity.ok("Entity deleted");      
		   }
		   catch (EmptyResultDataAccessException e){
		      return ResponseEntity.notFound().build();
		  } 
		
		
	}
	
	@PostMapping("/booking")  
	@ResponseStatus(HttpStatus.OK)
	private ResponseEntity<String> saveBook(@RequestBody Booking busroute)   
	{  
		bookingService.saveBooking(busroute) ;
		return new ResponseEntity<>("Bus Route updated success", 
				   HttpStatus.OK);  
	
	}  
	
	@PutMapping("/booking/{bookingid}")  
	@ResponseStatus(HttpStatus.OK)
	private ResponseEntity<String> update(@RequestBody Booking busroute,@PathVariable("bookingid") long busroutesid) throws BookingNotFoundException  
	{  
		bookingService.updateBooking(busroute, busroutesid);  
		return new ResponseEntity<>("Bus Route updated success", 
				   HttpStatus.OK);   
	}  

}
