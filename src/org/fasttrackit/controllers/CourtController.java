package org.fasttrackit.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import org.fasttrackit.dao.CourtDAO;
import org.fasttrackit.pojo.Court;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CourtController {

	@RequestMapping(value = "court_list.htm")
	public ModelAndView courtList() throws ClassNotFoundException, SQLException {

		CourtDAO cdao = new CourtDAO();
		ArrayList<Court> court = cdao.getCourts();

		ModelMap model = new ModelMap();
		model.put("court", court);

		return new ModelAndView("WEB-INF/court/list.jsp", "model", model);
	}

	@RequestMapping(value = "court_edit.htm")

	public ModelAndView editCourt(@RequestParam("id") int courtId, Model model)
			throws ClassNotFoundException, SQLException {

		CourtDAO cdao = new CourtDAO();
		Court court = cdao.getCourtbyId(courtId);

		model.addAttribute("court", court);

		return new ModelAndView("WEB-INF/court/edit.jsp", "court", court);

	}

	@RequestMapping(value = "court_save.htm")

	public ModelAndView saveCourt(@ModelAttribute("court") Court court, Model model, BindingResult result)
			throws ClassNotFoundException, SQLException {

		CourtDAO cdao = new CourtDAO();
		cdao.updateCourt(court);

		return new ModelAndView("redirect:/court_list.htm");
	}

	@RequestMapping(value = "court_insert.htm")

	public ModelAndView insertCourt(Model model) throws ClassNotFoundException, SQLException {

		Court court = new Court();
		model.addAttribute("court", court);

		return new ModelAndView("WEB-INF/court/add.jsp", "court", court);

	}

	@RequestMapping(value = "court_save_new_court.htm")

	public ModelAndView saveNewCourt(@ModelAttribute("court") Court court, Model model, BindingResult result)
			throws ClassNotFoundException, SQLException {

		CourtDAO cdao = new CourtDAO();
		cdao.insertCourt(court);

		return new ModelAndView("redirect:/court_list.htm");
	}

	@RequestMapping(value = "court_delete.htm")

	public ModelAndView deleteCourt(@RequestParam("id") int courtId, Model model)
			throws ClassNotFoundException, SQLException {

		CourtDAO cdao = new CourtDAO();
		cdao.deleteCourtByID(courtId);

		return new ModelAndView("redirect:/court_list.htm");

	}

}
