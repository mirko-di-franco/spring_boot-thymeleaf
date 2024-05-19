package com.generation.spring_bootthymeleaf.dto;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProdottoDTO {

	@NotEmpty(message = "Il nome é richiesto")
	private String nome;
	
	@NotEmpty(message = "La marca é richiesta")
	private String marca;
	
	@NotEmpty(message = "La categoria é richiesta")
	private String categoria;
	
	@NotNull(message = "Il prezzo non può essere nullo")
    @DecimalMin(value = "0.0", inclusive = false, message = "Il prezzo deve essere maggiore di zero")
	private BigDecimal prezzo;
	
	//IMPOSTO LA LUNGHEZZA MINIMA E MASSIMA DELLA DESCRIZIONE
	@Size(min = 10, message = "La descrizione deve contenere almeno 10 caratteri")
	@Size(max = 2000, message = "La descrizione deve contenere massimo 2000 caratteri")
	private String descrizione;
	
	//OPZIONALE: serve per caricare l'immagine direttamente con un file nel pc
	private MultipartFile immagine;

	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public MultipartFile getImmagine() {
		return immagine;
	}

	public void setImmagine(MultipartFile immagine) {
		this.immagine = immagine;
	}
	
	
	
}
