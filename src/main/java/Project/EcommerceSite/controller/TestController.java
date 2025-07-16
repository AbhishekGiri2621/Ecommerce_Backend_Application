package Project.EcommerceSite.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello, authenticated user!";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "Hello Admin, welcome to the dashboard!";
    }
}
