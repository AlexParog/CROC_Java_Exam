package Exam22_06_2022.task1;

import java.util.Comparator;

/**
 * Comparator для {@link Employee} по стажу работы
 */
public class OldExperienceComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getExperience() - o2.getExperience();
    }
}
