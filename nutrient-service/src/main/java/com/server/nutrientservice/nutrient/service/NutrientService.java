package com.server.nutrientservice.nutrient.service;

import com.server.nutrientservice.common.exception.ApplicationException;
import com.server.nutrientservice.nutrient.dto.response.NutrientResponse;
import com.server.nutrientservice.nutrient.dto.response.NutrientResponses;
import com.server.nutrientservice.nutrient.dto.response.UserNutrientResponse;
import com.server.nutrientservice.nutrient.dto.response.UserNutrientResponses;
import com.server.nutrientservice.nutrient.entity.Category;
import com.server.nutrientservice.nutrient.entity.Nutrient;
import com.server.nutrientservice.nutrient.repository.NutrientRepository;
import com.server.nutrientservice.usernutrient.entity.UserNutrient;
import com.server.nutrientservice.usernutrient.repository.UserNutrientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.server.nutrientservice.common.exception.nutrient.NutrientErrorCode.NOT_FOUND_NUTRIENT;

@Service
@RequiredArgsConstructor
public class NutrientService {

    private final NutrientRepository nutrientRepository;
    private final UserNutrientRepository userNutrientRepository;

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

    @Transactional
    public void createMyNutrient(String userId, Long id){
        Nutrient nutrient = nutrientRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(NOT_FOUND_NUTRIENT));
        userNutrientRepository.save(UserNutrient.of(nutrient,Long.parseLong(userId)));
    }

    @Transactional
    public void deleteMyNutrient(String userId, Long id){
        Nutrient nutrient = nutrientRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(NOT_FOUND_NUTRIENT));
        userNutrientRepository.deleteByUserIdAndNutrient(Long.parseLong(userId),nutrient);
    }

    @Transactional(readOnly = true)
    public UserNutrientResponses getUserNutrients(Long userId){
        List<UserNutrient> nutrients = userNutrientRepository.findAllByUserId(userId);
        return UserNutrientResponses.from(nutrients.stream()
                .map(n -> UserNutrientResponse.from(n.getNutrient()))
                .collect(Collectors.toList()));
    }
}
