package com.server.nutrientservice.usernutrient.entity;

import com.server.nutrientservice.common.entity.BaseEntity;
import com.server.nutrientservice.nutrient.entity.Nutrient;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserNutrient extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_nutrient_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="nutrient_id")
    private Nutrient nutrient;

    private Long userId;


}
