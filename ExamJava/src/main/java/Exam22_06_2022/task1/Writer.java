package Exam22_06_2022.task1;

import java.util.Map;

/**
 * Интерфейс для вывода информации
 */
public interface Writer {

    /**
     * Запись информации о сотруднике
     *
     * @param pathFile  - путь к файлу
     * @param employees - Map для хранения сотрудников по коду должности
     */
    void writeFile(String pathFile, Map<String, Employee> employees);
}
