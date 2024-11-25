package edu.miu.cse.userprofile.model.dtos;

import lombok.*;

public record UserResponseDTO(
        String username,
        ProfileResponseDTO profileResponseDTO
) {
}
