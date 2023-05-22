package com.server.nutrientservice.nutrient.service;

import com.server.nutrientservice.nutrient.dto.response.NutrientResponse;
import com.server.nutrientservice.nutrient.dto.response.NutrientResponses;
import com.server.nutrientservice.nutrient.entity.Category;
import com.server.nutrientservice.nutrient.repository.NutrientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NutrientService {

    private final NutrientRepository nutrientRepository;

    @Transactional(readOnly = true)
    public NutrientResponses getNutrientsByCategories(String category){
        return NutrientResponses.from(nutrientRepository.findAllByCategory(Category.toEnum(category))
                .stream()
                .map(NutrientResponse::from)
                .collect(Collectors.toList()));
    }

    @Transactional(readOnly = true)
    public NutrientResponses getNutrientByConditions(String category){
        return NutrientResponses.from(nutrientRepository.findAllByCategory(Category.toEnum(category))
                .stream()
                .map(NutrientResponse::from)
                .collect(Collectors.toList()));
    }
}
