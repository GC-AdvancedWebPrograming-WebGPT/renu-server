package com.server.nutrientservice.common.exception.nutrient;

import com.server.nutrientservice.common.exception.ErrorEnumCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NutrientErrorCode implements ErrorEnumCode {

    UNSUPPORTED_CATEGORY("N001","지원하지 않는 영양제 종류입니다.");

    private final String code;
    private String message;
}
