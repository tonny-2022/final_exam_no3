package edu.miu.cse.userprofile.service;

import edu.miu.cse.userprofile.model.dtos.UserRequestDTO;
import edu.miu.cse.userprofile.model.dtos.UserResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    Optional<UserResponseDTO> addUser(UserRequestDTO userRequestDTO);
    List<UserResponseDTO> getAllUsers();
}
