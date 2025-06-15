package com.calabrowsers.api.repository;

import com.calabrowsers.api.model.ReactionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactionsRepository extends JpaRepository<ReactionModel, Integer> {
}
