package com.epl.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.epl.service.interfaces.TeamService;
import com.epl.vo.Team;
import com.epl.vo.UpdateTeam;

@Controller
public class TeamController {
	@Autowired
	private TeamService teamService;

	@GetMapping("/addTeam")
	public String addTeam(HttpSession session, Team team, Model model) {

		team = (Team) session.getAttribute("team");
		model.addAttribute("team", team);
		return "club/addTeam";
	}

	

	@GetMapping("/getTeamList")
	public List<Team> getTeamList(Model model) {
		List<Team> list = teamService.getTeamList();
		model.addAttribute("list", list);
		System.out.println("list:" + list);
		return list;
	}

	@GetMapping("/leagueUpdate")
	public String leagueUpdate() {
		
		return "/leagueUpdate";
	}
	
	
	
	/*
	 * @GetMapping("/removeTeam") public String removeTeam(String teamName) {
	 * 
	 * return "removeTeam"; }
	 * 
	 * @PostMapping("/removeTeam") public String removeTeam(Team team) { int row =
	 * teamService.removeTeam(team); if (row == 0) { return "fail"; } return
	 * "redirect:/removeTeam"; }
	 * 
	 * @GetMapping("/modifyTeam") public String modifyTeam() {
	 * 
	 * return "modifyTeam"; }
	 * 
	 * @PostMapping("/modifyTeam") public String modifyTeam(Team team) {
	 * teamService.modifyTeam(team); return "redirect:/modifyTeam"; }
	 */

}
