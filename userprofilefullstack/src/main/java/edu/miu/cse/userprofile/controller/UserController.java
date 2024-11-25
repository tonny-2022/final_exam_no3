package edu.miu.cse.userprofile.controller;

import edu.miu.cse.userprofile.model.dtos.UserResponseDTO;
import edu.miu.cse.userprofile.model.entities.User;
import edu.miu.cse.userprofile.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        List<UserResponseDTO> userResponseDTOS = userService.getAllUsers();
        model.addAttribute("userResponseDTOS", userResponseDTOS);
        return "users_page";
    }
}
