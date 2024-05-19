package com.generation.spring_bootthymeleaf.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.spring_bootthymeleaf.service.ProdottoServ;

@RestController
@RequestMapping("api/prodotti")
public class ProdottoController {
	
	@Autowired
	ProdottoServ prodottoServ;

}
