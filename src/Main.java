import WincentsFiles.WincentsFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        try {
            // Hitta längsta ordet i filen words.txt
            String longestWord = findLongestWord("words.txt");
            System.out.println("Det längst ordet i words.txt är: " + longestWord);
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        try {
            // Hitta den vanligaste bokstaven i filen words.txt
            char mostCommonLetter = findMostCommonLetter("words.txt");
            System.out.println("Det mest använda ordet i words.txt är: " + mostCommonLetter);
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

        System.out.println("Hello world!");
    }

    // Hitta längsta ordet i filen
    private static String findLongestWord(String fileName) throws IOException {
        String longestWord = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Dela upp raden i ord
                for (String word : words) {
                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                }
            }
        }
        return longestWord;
    }

    // Hitta den vanligaste bokstaven i filen
    private static char findMostCommonLetter(String fileName) throws IOException {
        Map<Character, Integer> letterCount = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            int currentChar;
            while ((currentChar = reader.read()) != -1) {
                char character = (char) currentChar;
                if (Character.isLetter(character)) {
                    character = Character.toLowerCase(character);
                    letterCount.put(character, letterCount.getOrDefault(character, 0) + 1);
                }
            }
        }

        char mostCommonLetter = ' ';
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : letterCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommonLetter = entry.getKey();
            }
        }

        return mostCommonLetter;
    }
}

