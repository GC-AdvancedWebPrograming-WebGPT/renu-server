package com.server.nutrientservice.nutrient.controller;

import com.server.nutrientservice.nutrient.dto.response.NutrientResponses;
import com.server.nutrientservice.nutrient.dto.response.UserNutrientResponses;
import com.server.nutrientservice.nutrient.service.NutrientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nutrients")
@RequiredArgsConstructor
public class NutrientController {

    private final NutrientService nutrientService;

    @GetMapping("/categories")
    public NutrientResponses getNutrientsByCategories(@RequestParam String category){
        return nutrientService.getNutrientsByCategories(category);
    }

    @GetMapping("/conditions")
    public NutrientResponses getNutrientsByConditions(@RequestParam String category){
        return nutrientService.getNutrientByConditions(category);
    }

    @PostMapping("{id}")
    public void createMyNutrient(@RequestHeader("user_id") String userId,
                                 @PathVariable Long id)
    {
        nutrientService.createMyNutrient(userId, id);
    }

    @DeleteMapping("{id}")
    public void deleteMyNutrient(@RequestHeader("user_id") String userId,
                                 @PathVariable Long id)
    {
        nutrientService.deleteMyNutrient(userId, id);
    }

    @GetMapping("")
    public UserNutrientResponses getUserNutrients(@RequestHeader("user_id") String userId){
        return nutrientService.getUserNutrients(userId);
    }
}
