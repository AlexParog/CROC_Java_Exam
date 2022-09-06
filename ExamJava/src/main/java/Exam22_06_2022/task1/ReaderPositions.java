package Exam22_06_2022.task1;

import java.util.Map;

/**
 * Интерфейс для работы с информацией о должностях
 */
public interface ReaderPositions {
    /**
     * Чтение информации о должностях
     *
     * @param pathFile  - путь к файлу
     * @param positions - Map для хранения кодов должности
     */
    Map<String, String> readFile(String pathFile, Map<String, String> positions);
}
