package edu.miu.cse.userprofile.repository;

import edu.miu.cse.userprofile.model.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
