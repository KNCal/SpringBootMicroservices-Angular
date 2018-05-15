package com.example.foodapi.repositories;

import com.example.foodapi.models.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Long> {

}


