package com.ss.BookingService.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column 
	private Long bookingNo;
	@Column 
	private String busNo;
	@Column 
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private String busDate;
	@Column 
	private String source;
	@Column 
	private String destination;
	@Column 
	private String noOfseats;
	@Column 
	private String status;
	
	
	@OneToMany(cascade = {CascadeType.ALL})
    private List<Passenger> passengerlist;

}
