package com.bcp.prueba.demo.adapter.database.repository;

import com.bcp.prueba.demo.adapter.database.model.ExchangeHistoryJPA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeHistoryRepository extends JpaRepository<ExchangeHistoryJPA, Long> {
}
