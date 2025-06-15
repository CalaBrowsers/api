package com.calabrowsers.api.repository;

import com.calabrowsers.api.model.RantsModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RantsRepository extends JpaRepository<RantsModel, Integer> {
}
