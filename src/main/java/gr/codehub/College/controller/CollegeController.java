package gr.codehub.College.controller;

import gr.codehub.College.model.Course;
import gr.codehub.College.service.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class CollegeController {
    @GetMapping("college/courses")
    public List<Course> getCourses() {
        Service service = new Service();
        try {
            return service.getCourses("courses.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
