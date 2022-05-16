package ru.shop.proviant.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.shop.proviant.model.Order;
import ru.shop.proviant.repository.OrderRepository;

import javax.mail.MessagingException;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;



    public ResponseEntity getAll(){
        ResponseEntity all = ResponseEntity.ok(this.orderRepository.findAll());
        return all;
    }

    public ResponseEntity saveOrder(Order orders){
        orderRepository.save(orders);
        return new ResponseEntity<>("First Stage", HttpStatus.OK);
    }



}
