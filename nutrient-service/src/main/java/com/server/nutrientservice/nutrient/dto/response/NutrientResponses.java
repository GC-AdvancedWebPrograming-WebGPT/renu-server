package com.server.nutrientservice.nutrient.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NutrientResponses {

    private List<NutrientResponse> nutrients = new ArrayList<>();

    public static NutrientResponses from(List<NutrientResponse> nutrients){
        return NutrientResponses.builder()
                .nutrients(nutrients)
                .build();
    }
}
