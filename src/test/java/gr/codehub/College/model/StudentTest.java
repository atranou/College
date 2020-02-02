package gr.codehub.College.model;

import gr.codehub.College.repository.MarkModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Student st;
    private MarkModule markModule;
    private MarkModule markModule1;
    private Module m1;
    private Module m2;
    private Mark mk1;
    private Mark mk2;
    private Mark mk3;


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

        st = new Student();

    }

    @Test
    void getAverageMark() {
        markModule.addMark(mk1);
        markModule.addMark(mk2);

        markModule1.addMark(mk2);
        markModule1.addMark(mk3);

        st.enroll(m1);
        st.enroll(m2);

        st.addMarkModule(markModule);
        st.addMarkModule(markModule1);

        assertEquals(5.5, st.getAverageMark(),"Not expected value");
    }

    @Test
    void checkIfAllModulesPassed1() {
        markModule.addMark(mk1);
        markModule.addMark(mk2);

        markModule1.addMark(mk2);
        markModule1.addMark(mk3);

        st.enroll(m1);
        st.enroll(m2);

        st.addMarkModule(markModule);
        st.addMarkModule(markModule1);
        assertTrue(st.checkIfAllModulesPassed());
    }

    @Test
    void getAverageMark2() {
        markModule.addMark(mk3);
        markModule.addMark(mk2);

        markModule1.addMark(mk2);
        markModule1.addMark(mk2);

        st.enroll(m1);
        st.enroll(m2);

        st.addMarkModule(markModule);
        st.addMarkModule(markModule1);

        assertEquals(6, st.getAverageMark());
    }


    @Test
    void checkIfAllModulesPassed2() {
        markModule.addMark(mk3);
        markModule.addMark(mk2);

        markModule1.addMark(mk2);
        markModule1.addMark(mk2);

        st.enroll(m1);
        st.enroll(m2);

        st.addMarkModule(markModule);
        st.addMarkModule(markModule1);
        assertFalse(st.checkIfAllModulesPassed());

    }
}