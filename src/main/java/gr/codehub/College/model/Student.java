package gr.codehub.College.model;

import gr.codehub.College.repository.MarkModule;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Student {
    private int id;
    private Course course;
    private List<MarkModule> markModules;
    private List<Module> enrolledModules;


    public Student(){
        markModules = new ArrayList<>();
        enrolledModules = new ArrayList<>();
    }

    public void addMarkModule(MarkModule m){
        markModules.add(m);
    }

    public void enroll(Module m){
        enrolledModules.add(m);
    }

    public double getAverageMark() {
        final double AVG_ALL_FAILED_MODULES = 0.;

        for(MarkModule markModule:markModules)
            if (markModule.getAchievedMark().getMark() != 0)
               break;
            else return AVG_ALL_FAILED_MODULES;

            return markModules
                    .stream()
                    .filter(markModule -> !enrolledModules.contains(markModule.getModule()))
                    .filter(markModule -> markModule.getAchievedMark().getMark() != 0)
                    .map(MarkModule::getAchievedMark)
                    .mapToInt(Mark::getMark)
                    .average()
                    .getAsDouble();}


    public boolean checkIfAllModulesPassed() {
        boolean result = true;
        for (MarkModule markModule : markModules) {
            if (markModule.getAchievedMark().getMark() == 0) {
                result = false;
                break;
            }
        }
        return result;
    }
}
