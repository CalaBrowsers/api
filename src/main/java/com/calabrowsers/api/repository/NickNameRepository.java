package com.calabrowsers.api.repository;

import com.calabrowsers.api.model.NicknameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface NickNameRepository extends JpaRepository<NicknameModel, Integer> {

    @Query(
            value = "SELECT nickname FROM public.nicknames ORDER BY RANDOM() LIMIT 1",
            nativeQuery = true
    )
    Optional<String> findNicknameRandom();
}
