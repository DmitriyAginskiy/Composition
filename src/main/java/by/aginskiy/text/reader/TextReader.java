package by.aginskiy.text.reader;

import by.aginskiy.text.exception.FileReadingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

public class TextReader {

    private static final Logger logger = LogManager.getLogger();
    private static final String DEFAULT_PATH = "src\\main\\data.txt";

    public static String readFromFile(String path) throws FileReadingException {
        if(!Files.exists(Path.of(path))) {
            path = DEFAULT_PATH;
        }
        String text;
        try {
            text = Files.readString(Path.of(path));
        } catch(IOException e) {
            logger.error("Unable to read from file. Filepath: " + path);
            throw new FileReadingException("Unable to read from File");
        }
        return text;
    }
}
