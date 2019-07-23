package spring.assignment.number4.service;

import java.util.List;

import spring.assignment.number4.entity.Bookings;

public interface BookingService {
	
	public List<Bookings> findAll();
	void addBooking(Bookings booking);
	void deleteBooking(Bookings booking);

}
