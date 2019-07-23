package spring.assignment.number4.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.assignment.number4.entity.Bookings;

@Repository
public class BookingDAOImpl implements BookingDAO {
	
	@PersistenceContext
	EntityManager em;
	
	@Autowired
	public BookingDAOImpl(EntityManager entityManager) {
		this.em = entityManager;
	}

	@Override
	public List<Bookings> findAll() {
			return em.createQuery("FROM Bookings", Bookings.class).getResultList();
	}

	@Override
	public void makeBooking(Bookings booking) {
		em.persist(booking);
		
	}

	@Override
	public void deleteBooking(Bookings booking) {
		em.remove(booking);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Bookings> find(int bookingid) {
		String hql= "SELECT BK FROM Bookings BK WHERE BK.bookingid= :bookingid";
		Query q = em.createQuery(hql).setParameter("bookingid", bookingid);
		return q.getResultList();
		
	}
	

}
