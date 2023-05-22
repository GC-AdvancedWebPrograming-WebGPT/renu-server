package com.server.nutrientservice.nutrient.repository;

import com.server.nutrientservice.nutrient.entity.Category;
import com.server.nutrientservice.nutrient.entity.Nutrient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NutrientRepository extends CrudRepository<Nutrient, Long> {

    List<Nutrient> findAllByCategory(Category category);
}
