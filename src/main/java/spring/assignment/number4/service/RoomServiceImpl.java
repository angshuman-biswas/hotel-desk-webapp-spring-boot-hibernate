package spring.assignment.number4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.assignment.number4.dao.RoomDAO;
import spring.assignment.number4.entity.Rooms;

@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	RoomDAO roomDAO;

	@Transactional
	@Override
	public List<Rooms> findAll() {
		return roomDAO.findAll();
	}

	@Transactional
	@Override
	public List<Rooms> findAvailableRooms() {
		return roomDAO.findAvailableRooms();
	}

	@Transactional
	@Override
	public Rooms find(int roomno) {
		return roomDAO.find(roomno);
	}
	
	

}
