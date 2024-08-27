package com.augusto.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.augusto.model.Cambio;
import com.augusto.service.CambioService;

@RestController
@RequestMapping("cambio-service")
public class CambioController {
	
	@Autowired
	private Environment environment;
	@Autowired
	private CambioService cambioService;
	
	@GetMapping(value="/{amount}/{from}/{to}")
	public Cambio getCambio( @PathVariable("amount") BigDecimal amount, @PathVariable("from") String from, @PathVariable("to") String to ) {
		var cambio = cambioService.findByFromAndTo(from, to);
		cambio = cambioService.conversion(cambio, amount);
		cambio.setEnvironment(environment.getProperty("local.server.port"));
		return cambio;		
	}
}
