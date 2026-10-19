package com.baozistore.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.baozistore.demo.model.PedidoModel;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
}
