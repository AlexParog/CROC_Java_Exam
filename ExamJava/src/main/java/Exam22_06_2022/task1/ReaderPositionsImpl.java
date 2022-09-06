package Exam22_06_2022.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Map;

/**
 * Реализация чтения должностей
 */
public class ReaderPositionsImpl implements ReaderPositions {

    @Override
    public Map<String, String> readFile(String pathFile, Map<String, String> positions) {

        try (var reader = new BufferedReader(new FileReader(pathFile))) {
            String values = "";
            // считываем код должности
            while ((values = reader.readLine()) != null) {
                String[] info = values.split(" ");
                // очищаем код должности от лишних кавычек
                String wrongCode = info[0] + " " + info[1];
                String positionCode = wrongCode.replaceAll("\"", "");
                positions.put(positionCode, info[2]);
            }
            System.out.println(positions);
            return positions;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
