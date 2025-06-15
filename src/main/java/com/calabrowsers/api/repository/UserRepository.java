package com.calabrowsers.api.repository;

import com.calabrowsers.api.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
}
