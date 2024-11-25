package edu.miu.cse.userprofile.model.dtos;

import lombok.*;

public record UserRequestDTO(
        String username,
        String password,
        ProfileRequestDTO profileRequestDTO
) {
}
