

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCounter {

    private static final Set<String> STOP_WORDS = new HashSet<>(Arrays.asList(
            "a", "an", "the", "is", "this", "of", "and", "or", "but", "not"
    ));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Word Counter!");


        System.out.println("Enter 'text' to input text, or 'file' to input a file path:");
        String inputType = scanner.nextLine();

        if (inputType.equalsIgnoreCase("text")) {

            System.out.println("Enter your text:");
            String text = scanner.nextLine();
            processText(text);
        } else if (inputType.equalsIgnoreCase("file")) {

            System.out.println("Enter the file path:");
            String filePath = scanner.nextLine();
            processFile(filePath);
        } else {
            System.out.println("Invalid input. Please try again.");
        }

        scanner.close();
    }

    private static void processText(String text) {

        String[] words = text.split("[\\s\\p{Punct}]+");


        List<String> filteredWords = filterStopWords(Arrays.asList(words));


        int totalWords = filteredWords.size();
        System.out.println("Total words (excluding stop words): " + totalWords);


        Map<String, Integer> wordFrequency = countWordFrequency(filteredWords);
        System.out.println("Unique words: " + wordFrequency.size());


        displayWordFrequencies(wordFrequency);
    }

    private static void processFile(String filePath) {
        try {

            File file = new File(filePath);
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }

            br.close();

            String fileContent = sb.toString();
            processText(fileContent);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static List<String> filterStopWords(List<String> words) {
        List<String> filteredWords = new ArrayList<>();
        for (String word : words) {
            String cleanedWord = word.toLowerCase();
            if (!STOP_WORDS.contains(cleanedWord)) {
                filteredWords.add(cleanedWord);
            }
        }
        return filteredWords;
    }

    private static Map<String, Integer> countWordFrequency(List<String> words) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        return wordFrequency;
    }

    private static void displayWordFrequencies(Map<String, Integer> wordFrequency) {

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordFrequency.entrySet());
        sortedEntries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));


        System.out.println("\nTop 10 Most Frequent Words:");
        int count = 0;
        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            count++;
            if (count == 10) {
                break;
            }
        }
    }
}