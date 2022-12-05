package com.searchlead.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.searchlead.dto.Lead;

@Controller
public class LeadController {
	@Autowired
	private LeadRestClient restClient;
	
	//http://localhost:9090/search1
	
	@RequestMapping("/search1")
	public String viewSearchLeadPage() {
		return "search_lead";
	}
	
	@RequestMapping("/searchById")
	public String searchById(@RequestParam("id") long id,Model model) {
		Lead lead = restClient.getLeadById(id);
		model.addAttribute("lead", lead);
		return "lead_info";
	}
}
