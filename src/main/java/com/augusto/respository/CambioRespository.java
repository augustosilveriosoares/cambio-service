package com.augusto.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.augusto.model.Cambio;

public interface CambioRespository extends JpaRepository<Cambio, Long>{
	
	Cambio findByFromAndTo(String from, String to);

}
