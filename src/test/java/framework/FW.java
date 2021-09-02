package framework;

import com.google.gson.Gson;
import framework.logging.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FW {
    public static String WORKSPACE_DIRECTORY = System.getProperty("user.dir");
    public static Path currentTestDirectory;
    public static FWConfig configuration;
    public static Logger logger;

    public static void CreateTestDirectory() {
        Path testDirectory = Paths.get(WORKSPACE_DIRECTORY + "\\TestResults");
        if (!Files.exists(testDirectory)) {
            try {
                Files.createDirectory(testDirectory);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public static void SetConfig() {
        if (configuration == null) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader("framework-configuration.json"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            configuration = new Gson().fromJson(reader, FWConfig.class);
        }
    }

    public static FWConfig Config() {
        if (configuration != null)
            return configuration;
        throw new NullPointerException("Config is null. Call FW.SetConfig() first");
    }

    public static void SetLogger(String testName) {
        Path methodLogPath = Paths.get(WORKSPACE_DIRECTORY + String.format("\\TestResults\\%s", testName));
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd_MM_yy_hh_mm_ss");
        String dateTime = LocalDateTime.now().format(dateTimeFormatter);
        if (!Files.exists(methodLogPath)) {
            try {
                Path testDirectory = Files.createDirectory(methodLogPath);
                logger = new Logger(testDirectory + String.format("\\%s_log.txt", dateTime));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } else
            logger = new Logger(methodLogPath + String.format("\\%s_log.txt", dateTime));
    }

    public static Logger Log() {
        if (logger != null)
            return logger;
        throw new NullPointerException("logger is null. SetLogger() first");
    }
}
