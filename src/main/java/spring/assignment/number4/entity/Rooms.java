package spring.assignment.number4.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rooms")
public class Rooms {
	
	@Id
	@Column(name="roomno", unique = true, nullable = false)
	int roomno;
	
	@Column(name="username")
	String username;  //if username = null , room is available
	
	public int getRoomno() {
		return roomno;
	}
	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
