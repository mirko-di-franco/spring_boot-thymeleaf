package com.generation.spring_bootthymeleaf.restController;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.generation.spring_bootthymeleaf.dto.ProdottoDTO;
import com.generation.spring_bootthymeleaf.entity.Prodotto;
import com.generation.spring_bootthymeleaf.service.ProdottoServ;

import jakarta.validation.Valid;

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
	
	
	@PostMapping("/crea")
	//@valid : esegue la validazione di prodottoDTO utilizzando le annotazioni di validazione presenti nella classe ProdottoDTO, come @NotNull, @Size
	//@ModelAttribute: Spring cerca di legare i dati del form (o altri parametri della richiesta) a un'istanza di ProdottoDTO.
	//@BindingResult: contiene i risultati della validazione di prodottoDTO. Può essere usato per verificare se ci sono stati errori di binding o di validazione.
	public String creazioneProdotto(@Valid @ModelAttribute ProdottoDTO prodottoDTO, BindingResult result) {
		
		
		if(prodottoDTO.getImmagine().isEmpty()) {
			result.addError(new FieldError("prodottoDTO", "immagine", "L'immagine è vuota"));
		}
		
		if(result.hasErrors()) {
			return "prodotti/creazioneProdotto";
		}
		
		//SALVARE IMMAGINE
		MultipartFile immagine = prodottoDTO.getImmagine();
		Date createdAt = new Date();
		
		String nomeFile = createdAt.getTime() + "_" + immagine.getOriginalFilename();
		
		try {
			String percorsoImmagine = "public/img/";
			Path percorsoCaricamento = Paths.get(percorsoImmagine);
			
			if(!Files.exists(percorsoCaricamento)) {
				Files.createDirectories(percorsoCaricamento);
			}
			
			try(InputStream inputStream = immagine.getInputStream()){
				Files.copy(inputStream, Paths.get(percorsoImmagine + nomeFile), StandardCopyOption.REPLACE_EXISTING);
			}
			
		}catch(Exception e){
			System.out.println("Exception:" + e.getMessage());
		}
		
		
		Prodotto prodotto = new Prodotto();
		
		prodotto.setNome(prodottoDTO.getNome());
		prodotto.setMarca(prodottoDTO.getMarca());
		prodotto.setCategoria(prodottoDTO.getCategoria());
		prodotto.setPrezzo(prodottoDTO.getPrezzo());
		prodotto.setDescrizione(prodottoDTO.getDescrizione());
		prodotto.setCreateAt(createdAt);
		prodotto.setImmagine(nomeFile);
		
		prodottoServ.aggiungiOModifica(prodotto);
		
		
		return "redirect:/api/prodotti";
	}

}
