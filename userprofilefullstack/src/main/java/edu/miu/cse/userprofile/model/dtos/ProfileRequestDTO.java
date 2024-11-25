package edu.miu.cse.userprofile.model.dtos;

import java.time.LocalDate;

public record ProfileRequestDTO(
        String bio,
        String location,
        LocalDate dob
) {
}
