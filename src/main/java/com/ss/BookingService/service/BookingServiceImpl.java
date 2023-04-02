package com.ss.BookingService.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.BookingService.entity.Booking;
import com.ss.BookingService.exceptions.BookingNotFoundException;
import com.ss.BookingService.repository.BookingRepository;

import jakarta.transaction.Transactional;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	@Override
	@Transactional
	public Booking saveBooking(Booking route) {
		// TODO Auto-generated method stub
		return bookingRepository.save(route);
	}

	@Override
	public List<Booking> fetchBookingList() throws BookingNotFoundException{
		return (List<Booking>)
				bookingRepository.findAll();
	}

	@Override
	@Transactional
	public Booking updateBooking(Booking route, Long routeId) throws BookingNotFoundException{
		Booking depDB
        = bookingRepository.findById(routeId)
              .get();

    if (Objects.nonNull(route.getBusDate())) {
        depDB.setBusDate(
        		route.getBusDate());
    }
    
    if (Objects.nonNull(route.getBusNo())
            && !"".equalsIgnoreCase(
            		route.getBusNo())) {
            depDB.setBusNo(
            		route.getBusNo());
     }
    
    if (Objects.nonNull(route.getDestination())
            && !"".equalsIgnoreCase(
            		route.getDestination())) {
            depDB.setDestination(
            		route.getDestination());
     }
    
    if (Objects.nonNull(route.getNoOfseats())
            && !"".equalsIgnoreCase(
            		route.getNoOfseats())) {
            depDB.setNoOfseats(
            		route.getNoOfseats());
     }
    
    
    if (Objects.nonNull(route.getSource())
            && !"".equalsIgnoreCase(
            		route.getSource())) {
            depDB.setSource(
            		route.getSource());
     }
    
    if (Objects.nonNull(route.getStatus())
            && !"".equalsIgnoreCase(
            		route.getStatus())) {
            depDB.setStatus(
            		route.getStatus());
     }
    
    if (Objects.nonNull(route.getPassengerlist())) {
            depDB.setPassengerlist(
            		route.getPassengerlist());
     }

    
    return bookingRepository.save(depDB);

	}

	@Override
	@Transactional
	public void deleteBookingById(Long routeId) throws BookingNotFoundException{
		bookingRepository.deleteById(routeId);
		
	}

	@Override
	public Booking fetchBooking(Long routeId) throws BookingNotFoundException{
		// TODO Auto-generated method stub
		return bookingRepository.findById(routeId)
	              .get();
	}

}
