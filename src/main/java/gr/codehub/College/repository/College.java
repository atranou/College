package gr.codehub.College.repository;


import gr.codehub.College.model.Student;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class College {
    private List<Student> students;

    public College(){
        students = new ArrayList<>();
    }

    public void addStudent(Student s){
        students.add(s);
    }

    public Double calculateStudentAvgMarks(){
        return students
                .stream()
                .filter(student -> student.getAverageMark() != 0)
                .mapToDouble(Student::getAverageMark)
                .average()
                .getAsDouble();
    }

    public int calculateStudentCount(){
        return students.size();
    }

}
