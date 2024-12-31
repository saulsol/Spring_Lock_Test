package com.example.spring_lock_test.service;

import com.example.spring_lock_test.domain.Stock;
import com.example.spring_lock_test.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

//    @Transactional
//    public void decrease(Long id, Long quantity){
//        Stock stock = stockRepository.findById(id).orElseThrow();
//        stock.decrease(quantity);
//
//        stockRepository.save(stock);
//    }

    // synchronized 추가
    //@Transactional
    public synchronized void decrease(Long id, Long quantity){
        Stock stock = stockRepository.findById(id).orElseThrow();
        stock.decrease(quantity);

        stockRepository.save(stock);
    }
    // synchronized 키워드는 하나의 서버에서만 보장되는 상황
    // 하나의 프로세스에서만 동기화가 적용

}
