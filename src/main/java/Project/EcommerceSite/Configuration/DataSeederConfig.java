package Project.EcommerceSite.Configuration;

import Project.EcommerceSite.model.User;
import Project.EcommerceSite.repository.UserRepo;
import Project.EcommerceSite.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeederConfig {

    @Bean
    CommandLineRunner runner(UserService userService, UserRepo userRepo) {
        return args -> {
            if (userRepo.findByUsername("Admin").isEmpty()) {
                User user = new User();
                user.setUsername("Admin");
                user.setPassword("password");
                user.setRole("ADMIN");
                userService.registerUser(user);
                System.out.println("✅ User 'Admin' created at startup.");
            } else {
                System.out.println("ℹ️ User 'Admin' already exists.");
            }
        };
    }
}
