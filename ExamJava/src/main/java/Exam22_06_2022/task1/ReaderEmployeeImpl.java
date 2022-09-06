package Exam22_06_2022.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Реализация чтения сотрудника
 */
public class ReaderEmployeeImpl implements ReaderEmployee {

    @Override
    public Map<String, Employee> readFile(String pathFile, Map<String, Employee> employees, Map<String, String> positions) {

        List<Employee> allEmployees = new ArrayList<>();

        try (var reader = new BufferedReader(new FileReader(pathFile))) {
            String values = "";
            // считываем
            while ((values = reader.readLine()) != null) {
                String[] info = values.split(" ");
                // очищаем код должности от лишних кавычек
                String wrongCode = info[4] + " " + info[5];
                String positionCode = wrongCode.replaceAll("\"", "");
                // создаем сотрудника
                Employee newEmployee = new Employee(info[0], info[1], info[2],
                        Integer.parseInt(info[3]), positionCode);
                newEmployee.setJobTitle(positions.get(newEmployee.getPositionCode()));

                employees.put(positionCode, newEmployee);

                allEmployees.add(newEmployee); // для сортировки
            }
            // TODO пройтись по листу и исключить сотрудника с одинаковым кодом должности, с наименьшим стажем
            Comparator<Employee> expComparator = new OldExperienceComparator(); // сортировка
            allEmployees.sort(expComparator);
            System.out.println(employees);
            return employees;

        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
