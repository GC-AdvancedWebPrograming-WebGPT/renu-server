package com.server.nutrientservice.usernutrient.repository;

import com.server.nutrientservice.usernutrient.entity.UserNutrient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserNutrientRepository extends CrudRepository<UserNutrient, Long> {
}
