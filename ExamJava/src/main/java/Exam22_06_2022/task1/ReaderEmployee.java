package Exam22_06_2022.task1;

import java.util.Map;

/**
 * Интерфейс для работы с информацией о сотруднике
 */
public interface ReaderEmployee {
    /**
     * Чтение информации о сотруднике
     *
     * @param pathFile  - путь к файлу
     * @param employees - Map для хранения сотрудников по коду должности
     * @param positions - Map для хранения кодов должности
     */
    Map<String, Employee> readFile(String pathFile,
                                   Map<String, Employee> employees,
                                   Map<String, String> positions);
}
