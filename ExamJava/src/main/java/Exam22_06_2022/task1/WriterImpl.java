package Exam22_06_2022.task1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Map;

/**
 * Реализация записи сотрудников
 */
public class WriterImpl implements Writer {

    @Override
    public void writeFile(String pathFile, Map<String, Employee> employees) {
        try (var fileWriter = new FileWriter(pathFile)) {
            for (Employee e : employees.values()) {
                fileWriter.write(e.toString() + System.getProperty("line.separator"));
            }
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }
}
