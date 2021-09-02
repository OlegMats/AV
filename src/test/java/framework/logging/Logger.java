package framework.logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private static BufferedWriter log;

    public Logger(String filepath) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yy");
        String dateTime = LocalDateTime.now().format(dateTimeFormatter);
        try {
            log = new BufferedWriter(new FileWriter(filepath));
            log.append(String.format("Starting timestamp: %s", dateTime));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void WriteLine(String text){
        try{
            log.append("\n" + text);
        } catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    public void CloseStream(){
        try{
            log.close();
        } catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    public void Info(String message){
        WriteLine(String.format("[INFO]: %s", message));
    }
    public void Step(String message){
        WriteLine(String.format("    [STEP]: %s", message));
    }
    public void Warning(String message){
        WriteLine(String.format("[WARNING]: %s", message));
    }
    public void Error(String message){
        WriteLine(String.format("[ERROR]: %s", message));
    }
    public void Fatal(String message){
        WriteLine(String.format("[FATAL]: %s", message));
    }
}
