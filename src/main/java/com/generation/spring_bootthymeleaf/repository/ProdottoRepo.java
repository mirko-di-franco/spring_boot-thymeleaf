package com.generation.spring_bootthymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.spring_bootthymeleaf.entity.Prodotto;

@Repository
public interface ProdottoRepo extends JpaRepository<Prodotto, Integer>{

}
