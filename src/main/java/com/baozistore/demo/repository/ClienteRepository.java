package com.baozistore.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.baozistore.demo.model.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
}
