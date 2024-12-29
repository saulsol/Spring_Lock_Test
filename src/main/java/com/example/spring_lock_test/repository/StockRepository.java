package com.example.spring_lock_test.repository;

import com.example.spring_lock_test.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
