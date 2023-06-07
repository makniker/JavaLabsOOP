package lab4;


public class Translator {
    private final Dictionary dictionary;
    public Translator(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public String translate(String text) {
        String[] words = text.split("\\ ");
        StringBuilder returnText = new StringBuilder();
        for(String word : words) {
            word = word.toLowerCase();
            returnText.append(dictionary.getTranslate(word.toLowerCase())).append(' ');
        }
        return returnText.toString();
    }
}
