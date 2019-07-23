package spring.assignment.number4.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.assignment.number4.entity.Rooms;

@Repository
public class RoomDAOImpl implements RoomDAO {
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	public RoomDAOImpl(EntityManager entityManager) {
		this.em = entityManager;
	}

	@Override
	public void addRoom(Rooms room) {
		em.persist(room);
	}

	@Override
	public void deleteRoom(Rooms room) {
		em.remove(room);
	}

	@Override
	public void updateRoom(Rooms room) {
			
		em.merge(room);
	}

	@Override
	public List<Rooms> findAll() {
		return em.createQuery("from Rooms", Rooms.class).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Rooms> findAvailableRooms() {
		String hql= "SELECT RM FROM Rooms RM WHERE RM.username=null";
		Query q = em.createQuery(hql);
		return q.getResultList();
		
	}

	@Override
	public Rooms find(int roomno) {
		return em.find(Rooms.class,new Integer(roomno));
	}
	
	
}
