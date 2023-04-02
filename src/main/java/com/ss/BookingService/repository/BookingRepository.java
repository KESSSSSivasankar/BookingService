package com.ss.BookingService.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ss.BookingService.entity.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

}

