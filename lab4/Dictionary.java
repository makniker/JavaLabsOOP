package lab4;

import lab4.exception.FileReadException;
import lab4.exception.InvalidFileFormatException;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {
    private final Map< String, String > mapOfWords = new HashMap<>();

    public Dictionary(File file) throws InvalidFileFormatException, FileReadException {
        readFile(file);
    }

    private void readFile(File file) throws InvalidFileFormatException, FileReadException {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                String [] words = str.split("\\|");
                if (words.length != 2) {
                    scanner.close();
                    throw new InvalidFileFormatException();
                }
                mapOfWords.put(words[0].trim().toLowerCase(), words[1].trim().toLowerCase());
            }
            if (mapOfWords.isEmpty()) {
                scanner.close();
                throw new InvalidFileFormatException();
            }
        } catch(Exception e) {
            throw new FileReadException();
        }
    }

    public String getTranslate(String word) {
        return mapOfWords.get(word);
    }
}
