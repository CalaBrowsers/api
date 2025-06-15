package com.calabrowsers.api.repository;

import com.calabrowsers.api.model.PsychologistsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PsychologistsRepository extends JpaRepository<PsychologistsModel, Integer> {

    @Query(value = "SELECT * FROM public.psychologists  WHERE email ILIKE :email;", nativeQuery = true)
    Optional<PsychologistsModel> findByEmail(@Param("email") String email);
}
