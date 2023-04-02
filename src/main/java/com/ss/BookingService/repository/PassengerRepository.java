package com.ss.BookingService.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ss.BookingService.entity.Passenger;

@Repository
public interface PassengerRepository extends CrudRepository<Passenger, Long> {

}

