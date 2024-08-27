package com.augusto.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.augusto.exception.CurrencyUnsupportedException;
import com.augusto.model.Cambio;
import com.augusto.respository.CambioRespository;

@Service
public class CambioService {
	
	@Autowired
	private CambioRespository cambioRespository;
	
	public Cambio findByFromAndTo(String from, String to) {
		var cambio = cambioRespository.findByFromAndTo(from, to);
		if(cambio == null)
			throw new CurrencyUnsupportedException();
		
		return cambio;		
	}
	
	public Cambio conversion (Cambio cambio, BigDecimal ammount) {
		cambio.setConvertedValue(cambio.getConversionFactor().multiply(ammount).setScale(2, RoundingMode.CEILING));
		return cambio;
	}

}
