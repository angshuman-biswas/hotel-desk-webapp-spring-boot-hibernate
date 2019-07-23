package spring.assignment.number4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.assignment.number4.dao.BookingDAO;
import spring.assignment.number4.dao.RoomDAO;
import spring.assignment.number4.entity.Bookings;
import spring.assignment.number4.entity.Rooms;

@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	BookingDAO bookingDAO;
	@Autowired
	RoomDAO roomDAO;

	@Transactional
	@Override
	public List<Bookings> findAll() {
		return bookingDAO.findAll();
	}

	@Transactional
	@Override
	public void addBooking(Bookings booking) {
		Rooms room = new Rooms();
		room = roomDAO.find(booking.getRoomno());
		roomDAO.deleteRoom(room);
		bookingDAO.makeBooking(booking);		
	}

	@Transactional
	@Override
	public void deleteBooking(Bookings booking) {
		Rooms room = new Rooms();
		room.setRoomno(booking.getRoomno());
		room.setUsername(null);
		roomDAO.addRoom(room);
		bookingDAO.deleteBooking(booking);
		
	}
	
	

}
