package com.example.spring_lock_test.facade;

import com.example.spring_lock_test.service.OptimisticLockStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OptimisticLockFacade {

    private final OptimisticLockStockService optimisticLockStockService;

    public void decrease(Long id, Long quantity) throws InterruptedException {
        while (true){
            try {
                optimisticLockStockService.decrease(id, quantity);
                break;
            }catch (Exception e){
                Thread.sleep(50);
            }
        }
    }
}
