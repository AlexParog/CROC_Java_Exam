package Exam22_06_2022.task1;

import java.util.HashMap;
import java.util.Map;

public class Task1 {

    private static final String PATH_EMPLOYEE = "D:/УЧЕБА/Java/ExamJava/src/main/resources/files/employees.txt";
    private static final String PATH_POSITIONS = "D:/УЧЕБА/Java/ExamJava/src/main/resources/files/positions.txt";
    private static final String PATH_OUTPUT_FILE = "D:/УЧЕБА/Java/ExamJava/src/main/resources/files/employees_with_positions.txt";

    public static void main(String[] args) {
        // хранение
        Map<String, Employee> employees = new HashMap<>();
        Map<String, String> positions = new HashMap<>();

        // Reader`ы
        ReaderEmployeeImpl readerEmployee = new ReaderEmployeeImpl();
        ReaderPositionsImpl readerPositions = new ReaderPositionsImpl();

        // Writer
        WriterImpl writer = new WriterImpl();

        readerPositions.readFile(PATH_POSITIONS, positions);
        readerEmployee.readFile(PATH_EMPLOYEE, employees, positions);
        writer.writeFile(PATH_OUTPUT_FILE, employees);
    }
}
