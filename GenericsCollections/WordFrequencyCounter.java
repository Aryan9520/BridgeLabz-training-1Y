import java.util.*;
import java.io.*;

public class WordFrequencyCounter {

    public static Map<String, Integer> countWords(String text) {
        Map<String, Integer> map = new HashMap<>();

        text = text.toLowerCase().replaceAll("[^a-zA-Z ]", "");

        String[] words = text.split("\\s+");

        for (String word : words) {
            if (!word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        return map;
    }

    public static void main(String[] args) {

        String input = "Hello world, hello Java!";

        Map<String, Integer> result = countWords(input);
        System.out.println(result);
    }
}