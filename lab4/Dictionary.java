package lab4;

import lab4.exception.FileReadException;
import lab4.exception.InvalidFileFormatException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Dictionary {
    private final Map< String, String > mapOfWords = new HashMap<>();
    private final String[] punctuationArray = {".", ","};

    public Dictionary(File file) throws InvalidFileFormatException, FileReadException {
        readFile(file);
    }

    private void readFile(File file) throws InvalidFileFormatException, FileReadException {
        try (Scanner scanner = new Scanner(file)) {
            boolean isWordsGood = true;
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                String[] words = str.split("\\|");
                if (words.length != 2) {
                    isWordsGood = false;
                    break;
                }
                mapOfWords.put(words[0].trim().toLowerCase(), words[1].trim().toLowerCase());
            }
            if (mapOfWords.isEmpty() || !isWordsGood) {
                scanner.close();
                throw new InvalidFileFormatException();
            }
        } catch (FileNotFoundException e) {
            throw new FileReadException();
        }
    }

    public String getTranslate(String word) {
        StringBuilder trWord = new StringBuilder();
        StringBuilder orWord = new StringBuilder(word.toLowerCase());
        boolean isTranslatable = false;
        String punct = isContainsPunctuation(word);
        if (!punct.isEmpty()) {
            orWord.deleteCharAt(word.length() - 1);
        }
        for (int i = 0; i < orWord.length(); i++) {
            trWord.append(orWord.charAt(i));
            isTranslatable = mapOfWords.containsKey(trWord.toString());
        }
        return isTranslatable ? mapOfWords.get(trWord.toString()).concat(punct) : trWord.append(punct).toString();
    }

    private String isContainsPunctuation(String word) {
        for (String ch : punctuationArray) {
            if (word.endsWith(ch)) {
                return ch;
            }
        }
        return "";
    }
}
