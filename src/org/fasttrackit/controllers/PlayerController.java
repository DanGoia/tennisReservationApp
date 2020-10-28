package org.fasttrackit.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import org.fasttrackit.dao.PlayerDAO;
import org.fasttrackit.pojo.Player;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlayerController {

	@RequestMapping(value = "player_list.htm")
	public ModelAndView playersList() throws ClassNotFoundException, SQLException {

		PlayerDAO pdao = new PlayerDAO();
		ArrayList<Player> player = pdao.getPlayers();

		ModelMap model = new ModelMap();
		model.put("player", player);

		return new ModelAndView("WEB-INF/players/list_new.jsp", "model", model);
	}

	@RequestMapping(value = "ranking_list.htm")
	public ModelAndView rankingsList() throws ClassNotFoundException, SQLException {

		PlayerDAO pdao = new PlayerDAO();
		ArrayList<Player> player = pdao.getPlayersRankings();

		ModelMap model = new ModelMap();
		model.put("player", player);

		return new ModelAndView("WEB-INF/players/list_new.jsp", "model", model);
	}

	@RequestMapping(value = "player_edit.htm")

	public ModelAndView editPlayer(@RequestParam("id") int playerId, Model model)
			throws ClassNotFoundException, SQLException {

		PlayerDAO pdao = new PlayerDAO();
		Player player = pdao.getPlayerbyId(playerId);

		model.addAttribute("player", player);

		return new ModelAndView("WEB-INF/players/edit_new.jsp", "player", player);

	}

	@RequestMapping(value = "player_save.htm")

	public ModelAndView savePlayer(@ModelAttribute("player") Player player, Model model, BindingResult result)
			throws ClassNotFoundException, SQLException {

		PlayerDAO pdao = new PlayerDAO();
		pdao.updatePlayer(player);

		return new ModelAndView("redirect:/player_list.htm");
	}

	@RequestMapping(value = "player_insert.htm")

	public ModelAndView insertPlayer(@ModelAttribute("player") Player p) throws ClassNotFoundException, SQLException {
		PlayerDAO pdao = new PlayerDAO();
		ArrayList<Player> player = pdao.getPlayers();
		ModelMap model = new ModelMap();
		model.addAttribute("player", player);

		return new ModelAndView("WEB-INF/players/add_new.jsp", "model", model);

	}

	@RequestMapping(value = "player_save_new_player.htm")

	public ModelAndView saveNewPlayer(@ModelAttribute("player") Player player, Model model, BindingResult result)
			throws ClassNotFoundException, SQLException {

		PlayerDAO pdao = new PlayerDAO();
		pdao.insertPlayer(player);

		return new ModelAndView("redirect:/player_list.htm");
	}

	@RequestMapping(value = "player_delete.htm")

	public ModelAndView deletePlayer(@RequestParam("id") int playerId, Model model)
			throws ClassNotFoundException, SQLException {

		PlayerDAO pdao = new PlayerDAO();
		pdao.deletePlayer(playerId);

		return new ModelAndView("redirect:/player_list.htm");

	}

	@RequestMapping(value = "index.htm")
	public ModelAndView index() throws ClassNotFoundException, SQLException {

		ModelMap model = new ModelMap();

		return new ModelAndView("WEB-INF/players/home.jsp", "model", model);
	}

	@RequestMapping(value = "drop.htm")
	public ModelAndView playerList(@ModelAttribute("player") Player p) throws ClassNotFoundException, SQLException {

		PlayerDAO pdao = new PlayerDAO();
		ArrayList<Player> player = pdao.getPlayers();

		ModelMap model = new ModelMap();
		model.addAttribute("player", player);
		return new ModelAndView("/WEB-INF/common/droplist.jsp", "model", model);
	}
}