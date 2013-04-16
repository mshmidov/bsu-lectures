package org.exadel.bsu.tasks.second.midtest;

import com.google.common.collect.Sets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author skrauchenia
 */
@Component
public class WordSequenceAnswersStorage {

    private static final Path STORAGE_FILE_PATH = Paths.get(System.getProperty("user.home")).resolve("students.properties");
    private static final Logger LOGGER = LoggerFactory.getLogger(WordSequenceAnswersStorage.class);

    private Set<String> students = Sets.newHashSet();
    private Properties storage;

    public synchronized void register(String studentId) {
        students.add(studentId);
        storage.put(studentId, String.valueOf(System.currentTimeMillis()));
        saveStorage(studentId);
    }

    public synchronized void wipeAnswers(String studentId) {
        students.remove(studentId);
        storage.remove(studentId);
        saveStorage(studentId);
    }

    public Set<Map.Entry<Object,Object>> getAll() {
        return Collections.unmodifiableSet(storage.entrySet());
    }

    @PostConstruct
    private void initialLoadFromDisk() throws IOException {
        createIfStorageFileNotExist();
        Properties properties = new Properties();
        properties.load(Files.newInputStream(STORAGE_FILE_PATH));

        for (Object studentId : properties.keySet()) {
            students.add(studentId.toString());
        }

        this.storage = properties;
    }

    private void createIfStorageFileNotExist() throws IOException {
        if (Files.notExists(STORAGE_FILE_PATH)) {
            Files.createFile(STORAGE_FILE_PATH);
        }

    }

    private void saveStorage(String studentId) {
        try {
            storage.store(Files.newOutputStream(STORAGE_FILE_PATH), studentId);
        } catch (IOException e) {
            LOGGER.error("Failed to save result for {}", studentId, e);
        }
    }
}
