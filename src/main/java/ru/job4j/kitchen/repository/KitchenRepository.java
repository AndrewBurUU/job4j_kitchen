package ru.job4j.kitchen.repository;

import org.springframework.data.repository.*;
import ru.job4j.kitchen.model.*;

import java.util.*;

public interface KitchenRepository extends CrudRepository<Kitchen, Integer> {

    Collection<Kitchen> findAll();
}
