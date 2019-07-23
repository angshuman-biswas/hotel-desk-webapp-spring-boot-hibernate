package spring.assignment.number4.dao;

import java.util.List;

import spring.assignment.number4.entity.Bookings;

public interface BookingDAO {
	public List<Bookings> findAll();
	public List<Bookings> find(int bookingid);
	public void makeBooking(Bookings booking);
	public void deleteBooking(Bookings booking);

}
