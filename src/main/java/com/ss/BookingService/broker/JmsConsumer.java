package com.ss.BookingService.broker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.ss.BookingService.entity.Booking;
import com.ss.BookingService.service.BookingService;

import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.ObjectMessage;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JmsConsumer implements MessageListener {

	@Autowired  
	BookingService bookingService;

    @Override
    @JmsListener(destination = "${active-mq.topic}")
    public void onMessage(Message message) {
        try{
            ObjectMessage objectMessage = (ObjectMessage)message;
            Long bookid = (Long)objectMessage.getObject();
            //do additional processing
            
            Booking book = bookingService.fetchBooking(bookid);
            book.setStatus("Completed");
            bookingService.updateBooking(book, bookid); 
            log.info("Received Message from Topic: "+ book.toString());
        } catch(Exception e) {
            log.error("Received Exception while processing message: "+ e);
        }

    }