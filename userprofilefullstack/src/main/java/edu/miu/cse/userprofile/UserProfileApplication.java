package edu.miu.cse.userprofile;

import edu.miu.cse.userprofile.model.dtos.ProfileRequestDTO;
import edu.miu.cse.userprofile.model.dtos.UserRequestDTO;
import edu.miu.cse.userprofile.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class UserProfileApplication {

    private final UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(UserProfileApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            //Add 1st user
            ProfileRequestDTO profileRequestDTO = new ProfileRequestDTO("I am username1.","Fairfield",  LocalDate.of(2020, 1, 1));
            UserRequestDTO userRequestDTO = new UserRequestDTO("username1", "password1", profileRequestDTO);
            System.out.println(userService.addUser(userRequestDTO) + " added");

            //Add 2nd user
            ProfileRequestDTO profileRequestDTO2 = new ProfileRequestDTO("I am username2.","Ottumwa",  LocalDate.of(2020, 1, 2));
            UserRequestDTO userRequestDTO2 = new UserRequestDTO("username2", "password2", profileRequestDTO2);
            System.out.println(userService.addUser(userRequestDTO2) + " added");
        };
    }
}
