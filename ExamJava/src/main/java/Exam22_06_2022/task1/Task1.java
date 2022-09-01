package Exam22_06_2022.task1;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Task1 {

    private static Map<String, Employee> employees = new HashMap<>();
    private static Map<String, String> positions = new HashMap<>();

    private static final String PATH_EMPLOYEE = "D:/УЧЕБА/Java/ExamJava/src/main/resources/files/employees.txt";
    private static final String PATH_POSITIONS = "D:/УЧЕБА/Java/ExamJava/src/main/resources/files/positions.txt";
    private static final String PATH_OUTPUT_FILE = "D:/УЧЕБА/Java/ExamJava/src/main/resources/files/employees_with_positions.txt";

    public static void main(String[] args) {
        readPositions();
        readEmployee();
        writingToFile();
    }

    private static void readEmployee() {
        try (var reader = new BufferedReader(new FileReader(PATH_EMPLOYEE))) {
            String values = "";
            // считываем
            while ((values = reader.readLine()) != null) {
                String[] info = values.split(" ");
                System.out.println(Arrays.toString(info));

                String position = info[4];
                Employee employee = employees.get(position);

                if (employee != null) {
                    // определяем сотрудника с наибольшим стажем
                    int currentExp = Integer.parseInt(info[3]);
                    int actualExp = employee.getExperience();
                    // TODO если одинаковый стаж?
                    if (actualExp < currentExp) {
                        createEmployee(info, position);
                    }

                } else {
                    // создаем нового сотрудника
                    createEmployee(info, position);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void readPositions() {
        try (var reader = new BufferedReader(new FileReader(PATH_POSITIONS))) {
            String values = "";
            // считываем код должности
            while ((values = reader.readLine()) != null) {
                String[] info = values.split(" ");
                positions.put(info[0], info[1]);
            }
            //System.out.println(positions);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writingToFile() {
        try (var fos = new FileOutputStream(PATH_OUTPUT_FILE)) {
            for (Employee e : employees.values()) {
                byte[] buffer = e.toString().getBytes();
                fos.write(buffer, 0, buffer.length);
            }

        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }


    private static void createEmployee(String[] info, String position) {
        Employee newEmployee = new Employee(info[0], info[1], info[2],
                Integer.parseInt(info[3]), info[4]);
        newEmployee.setJobTitle(positions.get(newEmployee.getPositionCode()));

        employees.put(position, newEmployee);
    }
}
