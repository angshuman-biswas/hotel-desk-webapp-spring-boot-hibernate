package spring.assignment.number4.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.assignment.number4.dao.BookingDAO;
import spring.assignment.number4.entity.Bookings;
import spring.assignment.number4.entity.Rooms;
import spring.assignment.number4.service.BookingService;
import spring.assignment.number4.service.RoomService;

@Controller
public class AppController {
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	BookingDAO bookingDAO;
	
    @RequestMapping("/")
    public ModelAndView adminLogin() {
    	ModelAndView mv = new ModelAndView();
    	mv.setViewName("login.jsp");
    	return mv;
    }
	@RequestMapping("/alogin")
	public ModelAndView alogin(@RequestParam String ausername, @RequestParam String apassword) {
		ModelAndView mv = new ModelAndView();
		if(ausername.equals("admin") && apassword.equals("admin"))
		{
			List<Rooms> rooms = roomService.findAvailableRooms();
			mv.addObject("availablerooms", rooms);
			mv.setViewName("index.jsp");
			return mv;
		}
		else
		{
			mv.setViewName("login.jsp");
			return mv;
		}	
	}
	
	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		List<Rooms> rooms = roomService.findAvailableRooms();
		mv.addObject("availablerooms", rooms);
		mv.setViewName("index.jsp");
		return mv;
	}
	
	@RequestMapping(value="/book/{roomno}", method = RequestMethod.GET)
	public ModelAndView bookARoom(@PathVariable("roomno") int roomno ,HttpServletRequest request , HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("../bookingform.jsp");
		return mv;
	}
		
	@RequestMapping(value="/confirmed", method = RequestMethod.POST)
	public ModelAndView confirmBooking(@RequestParam("roomno") int roomno, @RequestParam("fromdate") String from, @RequestParam("todate") String to,
			@RequestParam("username") String username, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		Bookings booking = new Bookings();
		booking.setRoomno(roomno);
		booking.setFromDate(from);
		booking.setToDate(to);
		booking.setUsername(username);
		bookingService.addBooking(booking);
		
		List<Rooms> rooms = roomService.findAvailableRooms();
		mv.addObject("availablerooms", rooms);
		mv.setViewName("index.jsp");
		return mv;
	}
	
	@RequestMapping(value="/showallbookings")
	public ModelAndView showAllBookings() {
		ModelAndView mv = new ModelAndView();
		List<Bookings> allBookings = bookingService.findAll();
		mv.addObject("bookings", allBookings);
		mv.setViewName("allbookings.jsp");
		return mv;
	}
	
	@RequestMapping(value="/deletebooking/{bookingid}")
	public ModelAndView deleteBooking(@PathVariable("bookingid") int bookingid) {
		ModelAndView mv = new ModelAndView();
		bookingService.deleteBooking(bookingDAO.find(bookingid).get(0));
		List<Rooms> rooms = roomService.findAvailableRooms();
		mv.addObject("availablerooms", rooms);
		mv.setViewName("redirect:/index.jsp");
		return mv;
	}

}
