package ru.job4j.kitchen.model;

import lombok.*;
import net.bytebuddy.asm.*;
import net.bytebuddy.implementation.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    private int id;
    private int dishId;
}