package ru.shop.proviant.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.shop.proviant.model.Order;
import ru.shop.proviant.repository.OrderRepository;

import javax.mail.MessagingException;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public ResponseEntity findAll(){
        return ResponseEntity.ok(this.orderRepository.findAll());
    }

    public Order saveOrder(Order orders){
        return orderRepository.save(orders);
    }


}
