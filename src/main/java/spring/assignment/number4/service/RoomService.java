package spring.assignment.number4.service;

import java.util.List;

import spring.assignment.number4.entity.Rooms;

public interface RoomService {
	
	public List<Rooms> findAll();
	public List<Rooms> findAvailableRooms();
	public Rooms find(int roomno);

}
