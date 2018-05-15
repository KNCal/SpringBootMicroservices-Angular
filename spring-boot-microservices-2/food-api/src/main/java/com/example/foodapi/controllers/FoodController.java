package com.example.foodapi.controllers;

import com.example.foodapi.models.Food;
import com.example.foodapi.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RestController
public class FoodController {

    //Ask spring to get dependency injection
    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/")
    public Iterable<Food> findAllFood() {
        return foodRepository.findAll();
    }

    //Same name as long as add @PathVariable
    @GetMapping("/{foodId}")
    public Food findFoodById(@PathVariable Long foodId) {
        return foodRepository.findOne(foodId);
    }

    //Delete a food by ID
    @DeleteMapping("/{foodId}")
    public HttpStatus deleteFoodById(@PathVariable Long foodId) {
        foodRepository.delete(foodId);
        return HttpStatus.OK;
    }

    //Posting
    @PostMapping("/")
    public Food createNewFood(@RequestBody Food newFood) {
        return foodRepository.save(newFood);
    }

    //Naive update
    @PatchMapping("/{foodId}")
    public Food updateFoodById(@PathVariable Long foodId, @RequestBody Food foodRequest) {

        Food foodFromDb = foodRepository.findOne(foodId);

        foodFromDb.setProductcode(foodRequest.getProductcode());
        foodFromDb.setDescription(foodRequest.getDescription());
        foodFromDb.setDistribution(foodRequest.getDistribution());
        foodFromDb.setRecallinitiationdate(foodRequest.getRecallinitiationdate());
        foodFromDb.setRecallingfirm(foodRequest.getRecallingfirm());
        foodFromDb.setStatus(foodRequest.getStatus());

        return foodRepository.save(foodFromDb);
    }

}
