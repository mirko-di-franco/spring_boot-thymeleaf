package com.generation.spring_bootthymeleaf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.spring_bootthymeleaf.entity.Prodotto;
import com.generation.spring_bootthymeleaf.repository.ProdottoRepo;

@Service
public class ProdottoServ {

	@Autowired
	ProdottoRepo prodottoRepo;
	
	//METODO PER MOSTRARE TUTTI I PRODOTTI
	public List<Prodotto> tuttiIprodotti(){
		//se vuoi vedere l'ordine al contrario nella vista
		//List<Prodotto> prodotti = prodottoRepo.findAll(Sort.by(Sort.Direction.DESC, "id"));
		List<Prodotto> prodotti = prodottoRepo.findAll();
		return prodotti;
	}
	
	
	
}
