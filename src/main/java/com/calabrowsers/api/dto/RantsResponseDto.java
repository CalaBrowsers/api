package com.calabrowsers.api.dto;

import java.util.List;

public record RantsResponseDto(Integer rantId, Integer userId, String description, List<ReactionCountDTO> reactionCountDTO) {
}
