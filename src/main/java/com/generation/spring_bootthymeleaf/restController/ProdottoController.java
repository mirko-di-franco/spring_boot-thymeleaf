package com.generation.spring_bootthymeleaf.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.spring_bootthymeleaf.dto.ProdottoDTO;
import com.generation.spring_bootthymeleaf.entity.Prodotto;
import com.generation.spring_bootthymeleaf.service.ProdottoServ;

@Controller
@RequestMapping("api/prodotti")
public class ProdottoController {
	
	@Autowired
	ProdottoServ prodottoServ;
	
	
	//significa che questa rotta funziona sia con "http://localhost:8080/api/prodotti" oppure "http://localhost:8080/api/prodotti/"
	@GetMapping({"", "/"})
	//il MODEL è un interfaccia di Spring che viene utilizzata per passare dati dal controller alla vista
	public String listaProdotti(Model model) {
		List<Prodotto> prodotti = prodottoServ.tuttiIprodotti();
		//questo metodo aggiunge l'attributo `prodotti` al Model. il primo parametro è il nome con cui l'attributo sarà disponibile nella vista(in questo caso, `"prodotti"`),
		  // e il secondo parametro è il valore effettivo dell'attributo(la lista dei prodotti a riga 26)
		model.addAttribute("prodotti", prodotti);
		//mi collego alla pagina index.html che si trova dentro la cartella template/prodotti
		return "prodotti/index";
	}
	
	
	//mi reinderizza alla pagina per creare un nuovo prodotto
	@GetMapping("/crea")
	public String paginaCrezioneProdotto(Model model) {
		ProdottoDTO prodottoDTO = new ProdottoDTO();
		model.addAttribute("prodottoDTO", prodottoDTO);
		return "prodotti/creazioneProdotto";
	}

}
