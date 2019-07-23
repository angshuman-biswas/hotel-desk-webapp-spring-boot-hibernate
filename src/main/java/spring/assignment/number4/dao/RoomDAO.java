package spring.assignment.number4.dao;

import java.util.List;

import spring.assignment.number4.entity.Rooms;

public interface RoomDAO {
	public void addRoom(Rooms room);
	public void deleteRoom(Rooms room);
	public void updateRoom(Rooms room);
	public List<Rooms> findAll();
	public List<Rooms> findAvailableRooms();
	public Rooms find(int roomno);

}
