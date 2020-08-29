package dataStructures;

import java.util.HashMap;
import java.util.Map;

/** Simple example of using a hash map to store word frequencies */
public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> counterMap = new HashMap<>();
        String[] words = { "cat", "dog", "cat", "bird", "elephant", "monkey", "dog", "bull" };
        for (String word: words) {
            if (counterMap.get(word) != null) {
                int count  = counterMap.get(word);
                counterMap.put(word, count + 1);
            }
            else {
                counterMap.put(word, 1);
            }
        }

        for (String word: counterMap.keySet()) {
            System.out.println(word + ": " + counterMap.get(word));
        }
    }

}
