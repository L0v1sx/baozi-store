package com.baozistore.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.baozistore.demo.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
