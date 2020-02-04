package gr.codehub.College.controller;

import gr.codehub.College.model.Course;
import gr.codehub.College.service.Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;
import java.util.List;

@Controller
public class WelcomeCollegeController {
    @GetMapping("college")
    public String WelcomePage() {
        return "WelcomePage";
    }
}
