package ru.job4j.kitchen.service;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.*;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.job4j.kitchen.model.*;
import ru.job4j.kitchen.repository.*;

import javax.transaction.*;
import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class KitchenService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KitchenRepository kitchenRepository;

    public Optional<Kitchen> findById(int id) {
        return kitchenRepository.findById(id);
    }

    /**@KafkaListener(topics = "job4j_orders")*/
    @KafkaListener(topics = "preorder")
    public void receiveOrder(Order order) {
        log.debug(order.toString());
        kafkaTemplate.send("cooked_order", getDish(order.getDishId()));
    }

    private String getDish(int dishId) {
        if (findById(dishId).isPresent()) {
            return "Готов к выдаче";
        }
        return "Нет такого блюда";
    }

}
