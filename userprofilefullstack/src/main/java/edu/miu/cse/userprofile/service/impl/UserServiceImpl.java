package edu.miu.cse.userprofile.service.impl;

import edu.miu.cse.userprofile.model.dtos.ProfileResponseDTO;
import edu.miu.cse.userprofile.model.dtos.UserRequestDTO;
import edu.miu.cse.userprofile.model.dtos.UserResponseDTO;
import edu.miu.cse.userprofile.model.entities.Profile;
import edu.miu.cse.userprofile.model.entities.User;
import edu.miu.cse.userprofile.repository.UserRepository;
import edu.miu.cse.userprofile.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Optional<UserResponseDTO> addUser(UserRequestDTO userRequestDTO) {
        User newUser = new User();
        newUser.setUsername(userRequestDTO.username());
        newUser.setPassword(userRequestDTO.password());
        Profile profile = new Profile();
        profile.setBio(userRequestDTO.profileRequestDTO().bio());
        profile.setDob(userRequestDTO.profileRequestDTO().dob());
        profile.setLocation(userRequestDTO.profileRequestDTO().location());
        newUser.setProfile(profile);
        User savedUser = userRepository.save(newUser);
        ProfileResponseDTO profileResponseDTO = new ProfileResponseDTO(savedUser.getProfile().getBio(), savedUser.getProfile().getLocation());
        UserResponseDTO userResponseDTO = new UserResponseDTO(savedUser.getUsername(), profileResponseDTO);
        return Optional.of(userResponseDTO);
    }


    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponseDTO> userResponseDTOS = new ArrayList<>();
        for (User user : users) {
            ProfileResponseDTO profileResponseDTO = new ProfileResponseDTO(user.getProfile().getBio(), user.getProfile().getLocation());
            UserResponseDTO userResponseDTO = new UserResponseDTO(user.getUsername(), profileResponseDTO);
            userResponseDTOS.add(userResponseDTO);
        }
        return userResponseDTOS;
    }
}
