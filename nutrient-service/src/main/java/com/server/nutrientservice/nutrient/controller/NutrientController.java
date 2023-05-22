package com.server.nutrientservice.nutrient.controller;

import com.server.nutrientservice.nutrient.dto.response.NutrientResponses;
import com.server.nutrientservice.nutrient.service.NutrientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nutrients")
@RequiredArgsConstructor
public class NutrientController {

    private final NutrientService nutrientService;

    @GetMapping("/categories")
    public NutrientResponses getNutrientsByCategories(@RequestParam String category){
        return nutrientService.getNutrientsByCategories(category);
    }
}
