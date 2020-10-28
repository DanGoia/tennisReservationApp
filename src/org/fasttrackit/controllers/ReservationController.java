package org.fasttrackit.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import org.fasttrackit.dao.CourtDAO;
import org.fasttrackit.dao.PlayerDAO;
import org.fasttrackit.dao.ReservationDAO;
import org.fasttrackit.pojo.Court;
import org.fasttrackit.pojo.Player;
import org.fasttrackit.pojo.Reservation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReservationController {

	@RequestMapping(value = "reservation_list.htm")
	public ModelAndView reservationList() throws ClassNotFoundException, SQLException {

		ReservationDAO rdao = new ReservationDAO();
		ArrayList<Reservation> reservation = rdao.getReservationList();

		ModelMap model = new ModelMap();
		model.put("reservation", reservation);

		return new ModelAndView("WEB-INF/reservation/list.jsp", "model", model);
	}

	@RequestMapping(value = "reservation_edit.htm")

	public ModelAndView editReservation(@RequestParam("id") int reservationId, Model model)
			throws ClassNotFoundException, SQLException {

		ReservationDAO rdao = new ReservationDAO();
		Reservation reservation = rdao.getReservationById(reservationId);

		model.addAttribute("reservation", reservation);

		return new ModelAndView("WEB-INF/reservation/edit.jsp", "reservation", reservation);

	}

	@RequestMapping(value = "reservation_save.htm")

	public ModelAndView saveReservation(@ModelAttribute("reservation") Reservation reservation, Model model, Player p,
			Court c, BindingResult result) throws ClassNotFoundException, SQLException {

		ReservationDAO rdao = new ReservationDAO();
		reservation.setCourtNumber(c);
		reservation.setP(p);

		rdao.updateReservation(reservation);

		return new ModelAndView("redirect:/reservation_list.htm");
	}

	@RequestMapping(value = "reservation_insert.htm")

	public ModelAndView insertReservation(@ModelAttribute("reservation") Reservation r)
			throws ClassNotFoundException, SQLException {
		ModelMap model = new ModelMap();

		CourtDAO cdao = new CourtDAO();
		ArrayList<Court> court = cdao.getCourts();

		PlayerDAO pdao = new PlayerDAO();
		ArrayList<Player> player = pdao.getPlayers();

		model.addAttribute("court", court);
		model.addAttribute("player", player);

		Reservation reservation = new Reservation();
		model.addAttribute("reservation", reservation);

		return new ModelAndView("WEB-INF/reservation/add.jsp", "model", model);

	}

	@RequestMapping(value = "reservation_save_new_reservation.htm")

	public ModelAndView saveNewReservation(@ModelAttribute("reservation") Reservation reservation, Model model,
			BindingResult result) throws ClassNotFoundException, SQLException {

		ReservationDAO rdao = new ReservationDAO();
		rdao.insertReservation(reservation);

		return new ModelAndView("redirect:/reservation_list.htm");
	}

	@RequestMapping(value = "reservation_delete.htm")

	public ModelAndView deleteReservation(@RequestParam("id") int reservationId, Model model)
			throws ClassNotFoundException, SQLException {

		ReservationDAO rdao = new ReservationDAO();
		rdao.deleteReservationByID(reservationId);

		return new ModelAndView("redirect:/reservation_list.htm");

	}

}
