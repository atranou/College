package gr.codehub.College.repository;

import gr.codehub.College.model.Mark;
import gr.codehub.College.model.Module;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class MarkModule {
    private Module module;
    private List<Mark> marks;
    private Mark achievedMark;
    private final int MIN_PASS_MARK = 5;

    public MarkModule() {
        marks = new ArrayList<>();
        achievedMark = new Mark();
    }

    public void addMark(Mark m) {
        marks.add(m);
        checkIfPassModule(m);
    }

    public boolean checkIfPassModule(Mark m) {
        if (m.getMark() >= MIN_PASS_MARK  && achievedMark.getMark()<m.getMark()) {
            achievedMark = m;
            return true;
        }
        else {
            return false;
        }
    }
}
