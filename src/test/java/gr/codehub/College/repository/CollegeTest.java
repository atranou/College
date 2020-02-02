package gr.codehub.College.repository;

import gr.codehub.College.model.*;
import gr.codehub.College.model.Module;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CollegeTest {
    private Student st1;
    private Student st2;

    private MarkModule markModule;
    private MarkModule markModule1;
    private Module m1;
    private Module m2;
    private Mark mk1;
    private Mark mk2;
    private Mark mk3;
    private College col;

    @BeforeEach
    void setUp() {
        m1 = new Module("Linear Algebra"
                , new Course("Science", "Athens", Cohort.SEPT_2019_JUN_2020)
                , "Giorgos Papadopoulos", ModuleType.MANDATORY);
        m2 = new Module("Machine Learning"
                , new Course("Data Science", "Athens", Cohort.SEPT_2019_JUN_2020)
                , "Aliki Papaoikonomou", ModuleType.MANDATORY);

        mk1 = new Mark(new Date(119, 0, 2), 5);
        mk2 = new Mark(new Date(119, 0, 2), 4);
        mk3 = new Mark(new Date(119, 0, 2), 6);

        markModule = new MarkModule();
        markModule1 = new MarkModule();

        st1 = new Student();
        st2 = new Student();
        col = new College();

        col.addStudent(st1);
        col.addStudent(st2);

    }

    @Test
    void calculateStudentAvgMarks() {
        markModule.addMark(mk1);
        markModule.addMark(mk2);

        markModule1.addMark(mk3);
        markModule1.addMark(mk1);

        st1.enroll(m1);
        st2.enroll(m2);

        st1.addMarkModule(markModule);
        st2.addMarkModule(markModule1);
        assertEquals(5.5, col.calculateStudentAvgMarks());
    }

    @Test
    void calculateStudentAvgMarks2() {
        markModule.addMark(mk1);
        markModule.addMark(mk2);

        markModule1.addMark(mk2);
        markModule1.addMark(mk2);

        st1.enroll(m1);
        st2.enroll(m2);

        st1.addMarkModule(markModule);
        st2.addMarkModule(markModule1);

        assertEquals(5, col.calculateStudentAvgMarks());
    }

    @Test
    void calculateStudentCount() {

        assertEquals(2,col.calculateStudentCount());
    }
}