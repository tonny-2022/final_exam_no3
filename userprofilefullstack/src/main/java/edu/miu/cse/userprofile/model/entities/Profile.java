package edu.miu.cse.userprofile.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "profiles")
@Data
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer profileId;
    private String bio;
    private String location;
    private LocalDate dob;
    @OneToOne(mappedBy = "profile", fetch = FetchType.LAZY)
    private User user;
}
