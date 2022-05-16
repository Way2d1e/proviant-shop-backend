package ru.shop.proviant.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shop.proviant.model.OrderProducts;
import ru.shop.proviant.repository.OrderProductPriceRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class OrderProductController {

    private final OrderProductPriceRepository orderProductPriceRepository;


    @GetMapping("/ordersPer")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(this.orderProductPriceRepository.findAll());
    }

}
