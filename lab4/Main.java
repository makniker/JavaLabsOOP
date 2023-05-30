package lab4;

import lab4.exception.FileReadException;
import lab4.exception.InvalidFileFormatException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("dictionary.txt");
            Dictionary dict = new Dictionary(file);
            Translator translator = new Translator(dict);
            System.out.println(translator.translate(readFile("example.txt", StandardCharsets.UTF_8)));
        } catch (InvalidFileFormatException | FileReadException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String readFile(String path, Charset encoding) throws FileReadException {
        try {
            return Files.readString(Paths.get(path), encoding);
        } catch (IOException e) {
            throw new FileReadException();
        }
    }
}
