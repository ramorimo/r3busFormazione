package org.bitbucket.r3bus.controller;

import javax.validation.Valid;

import org.bitbucket.r3bus.model.Attivita;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.HttpClientErrorException;

@Controller
public class OrganizzatoreController {

	// selezione centro

	@GetMapping("/organizzatore")
	public String selezioneCentroForm() {
		throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/organizzatore")
	public String selezioneCentro() {
		// processa dati
		long centroID = 1;
		return "redirect:/organizzatore/" + centroID + "/attivita";
	}

	// lista attivita

	@GetMapping("/organizzatore/{centroID}/attivita")
	public String listaAttivita(@PathVariable("centroID") Long centroID) {
		throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
	}

	// inserisci attivita

	@GetMapping("/organizzatore/{centroID}/attivita/inserisci")
	public String nuovaAttivitaForm(@PathVariable("centroID") Long centroID, ModelMap model) {
		model.addAttribute("activity", new Attivita()); // TOFIX
		return "activity_form";
	}

	@PostMapping("/organizzatore/{centroID}/attivita/inserisci")
	public String nuovaAttivita(@PathVariable("centroID") Long centroID,
			@Valid @ModelAttribute("activity") Attivita activity, BindingResult bindingResult, ModelMap model) {
		if (bindingResult.hasErrors())
			return "activity_form";
		// controller stuff
		model.clear();
		return "redirect:/organizzatore/" + centroID + "/attivita";
	}

	// modifica attivita

	@GetMapping("/organizzatore/{centroID}/attivita/{id}/modifica")
	public String modificaAttivitaForm(@PathVariable("centroID") Long centroID, @PathVariable("id") Long id) {
		throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/organizzatore/{centroID}/attivita/{id}/modifica")
	public String modificaAttivita(@PathVariable("centroID") Long centroID, @PathVariable("id") Long id) {
		// processa dati
		return "redirect:/organizzatore/" + centroID + "/attivita";
	}
}