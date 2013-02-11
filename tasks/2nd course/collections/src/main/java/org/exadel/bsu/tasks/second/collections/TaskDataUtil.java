package org.exadel.bsu.tasks.second.collections;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author skrauchenia
 */
public class TaskDataUtil {

    /**
     * Возвращает содержимое текстового файла в виде строки
     * @param bookName - имя файла. Должен лежать на classpath. Например
     *                 в папке resources
     * @return текст
     */
    public static String bookText(String bookName) {
        StringBuilder text = new StringBuilder();
        try {
            Charset cs = Charset.forName("UTF-8");
            Path bookPath = Paths.get(TaskDataUtil.class.getClassLoader().getResource(bookName).toURI());
            List<String> lines = Files.readAllLines(bookPath, cs);
            for (String line : lines) {
                text.append(line);
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }
}
