package com.livros.simulated.dashboard.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;

import com.livros.simulated.dashboard.form.TestForm;

import reactor.core.publisher.Mono;

@Controller
public class MonitorMainController {

	@GetMapping("/dashboard")
	public String index(final Model model, @ModelAttribute TestForm testForm) {

		// model.addAttribute("testForm", testForm);

		return "dashboard/dashboard";
	}

	@RequestMapping("/securedPage")
	public String securedPage(final Model model, @ModelAttribute TestForm testForm, Principal principal) {

		TestForm test = new TestForm();
		test.setAutorCode("0");

		model.addAttribute("testForm", test);

		return "dashboard/dashboard";
	}

	@RequestMapping("/")
	public String index(Model model, @ModelAttribute TestForm testForm, Principal principal) {

		TestForm test = new TestForm();
		test.setAutorCode("0");

		model.addAttribute("testForm", test);

		return "index";
	}

}
