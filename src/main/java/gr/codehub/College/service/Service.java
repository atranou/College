package gr.codehub.College.service;

import gr.codehub.College.model.Cohort;
import gr.codehub.College.model.Course;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {

    public List<Course> getCourses(String filename) throws FileNotFoundException {
        List<Course> courses = new ArrayList<>();
        Scanner sc = new Scanner(new File(filename));
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] words = line.split(",");
            Course course = new Course(words[0]
                                       ,words[1]
                                       ,Cohort.valueOf(words[2]));
            courses.add(course);
        }
        return courses;
    }
}
