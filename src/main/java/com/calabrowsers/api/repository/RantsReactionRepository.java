package com.calabrowsers.api.repository;

import com.calabrowsers.api.dto.ReactionCountDTO;
import com.calabrowsers.api.model.RantReactionsModel;
import com.calabrowsers.api.model.RantsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RantsReactionRepository extends JpaRepository<RantReactionsModel, Integer> {

    List<RantReactionsModel> findAllByRantId(Integer id);

    @Query(value = "SELECT reaction_id, COUNT(reaction_id) as quantity FROM rants_reactions WHERE rant_id = :rantId " +
            "group by reaction_id", nativeQuery = true)
    List<Object[]> countByRantIdGrouped(@Param("rantId") Integer rantId);
}
