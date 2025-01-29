package com.livros.simulated.dashboard.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.livros.simulated.dashboard.form.AutorCodeForm;
import com.livros.simulated.dashboard.form.AutorForm;
import com.livros.simulated.dashboard.form.LivrosForm;
import com.livros.simulated.dashboard.form.TestForm;
import com.livros.simulated.dashboard.service.ReactiveLivrosService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.livros.model.entity.Autor;

@RestController
public class MonitorLivrosController {

	@Autowired
	private ReactiveLivrosService reactiveLivrosService;

	@GetMapping(path = "/monitor/autorCode", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<AutorForm> autorCode(final Model model, @ModelAttribute TestForm testForm) {

		AutorForm autorForm = new AutorForm();

		TestForm test = reactiveLivrosService.getTestForm();

		if (test != null) {
			System.out.println("Autor Code: " + test.getAutorCode());
			autorForm.getAutorCodes().add(new AutorCodeForm(test.getAutorCode()));
		}

		autorForm.setAutores(new ArrayList<Autor>());

		List<AutorForm> list = new ArrayList<AutorForm>();
		list.add(autorForm);

		return Flux.fromIterable(list);

	}

	@GetMapping(path = "/monitor/autores", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<AutorForm> autores(final Model model, @ModelAttribute TestForm testForm) {

		System.out.println("test");

		TestForm test = reactiveLivrosService.getTestForm();

		if (test != null) {

			System.out.println("test: " + test.getAutorCode());

			model.addAttribute("testForm", test);

		}

		return reactiveLivrosService.autores();

	}

	@GetMapping(path = "/monitor/livros", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<LivrosForm> livros(final Model model, @ModelAttribute TestForm testForm) {

		TestForm test = reactiveLivrosService.getTestForm();
		String autorCode = null;
		if(test != null) {
			autorCode = test.getAutorCode();
			
			model.addAttribute("testForm", test);
		}
		
		Flux<LivrosForm> ret = reactiveLivrosService.livros(autorCode);
		
		return ret;

	}
	
	@RequestMapping(path = "/monitor/submitLivrosByAutorId", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public ModelAndView getLibrosById(final Model model, ModelMap modelMap, @ModelAttribute TestForm testForm) {

		reactiveLivrosService.setTestForm(testForm);

		model.addAttribute("testForm", testForm);

		System.out.println("test: " + testForm.getAutorCode());

		try {

			modelMap.addAttribute("attribute", "redirectWithRedirectPrefix");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/securedPage", modelMap);

	}

	

	@RequestMapping("/erpEnviarNotaFiscal")
	public ModelAndView erpEnviarNotaFiscal(ModelMap model) {

		try {

			model.addAttribute("attribute", "redirectWithRedirectPrefix");

			//reactiveNotaFiscalService.erpEnviarNotaFiscal();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ModelAndView("redirect:/", model);
	}

}
