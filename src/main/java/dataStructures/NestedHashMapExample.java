package dataStructures;

import java.util.*;

/** Demonstrates how to use a nested HashMap */
public class NestedHashMapExample {

    private List<String> wordList = new ArrayList<>();
    private TreeMap<String, Integer> wordTreeMap = new TreeMap<>();

    private Map<Integer, Set<String>> nestedMap = new HashMap<>();


    /**
     * Parses the given string into words and creates two maps:
     * - a TreeMap, where the keys are words, and the values are their frequency counts
     * - a HashMap (nested), where each key is the length of the word (integer),
     *              and the corresponding value is a set of words that are of this length
     * @param text input string
     */
    public void parseText(String text) {

        // split into words
        String[] words = text.split(" ");
        for (String word : words) {
            word = word.toLowerCase();
            wordList.add(word);

            if (wordTreeMap.get(word) == null) {
                wordTreeMap.put(word, 1);
            }
            else {
                wordTreeMap.put(word, wordTreeMap.get(word) + 1);
            }


            // Count number of characters in the word
            int numChars = word.length();
            /*if (!nestedMap.containsKey(numChars)) {
                nestedMap.put(numChars, new HashSet<>());
            }
            // add this word to the set that corresponds to numChars
            HashSet<String> nestedSet = nestedMap.get(numChars);
            nestedSet.add(word);*/

            if (!nestedMap.containsKey(numChars)) {

                Set<String> nestedSet = new HashSet<>();
                nestedSet.add(word);
                nestedMap.put(numChars, nestedSet);
            } else {
                Set<String> nestedSet = nestedMap.get(numChars);
                nestedSet.add(word);
            }

        }

        // Print out results in a consistent format
        System.out.println("ArrayList:" +  wordList);
        System.out.println("TreeMap: " +   wordTreeMap);

        // Tailmap will return a submap that contains keys >= "elderberry" and the corresponding values
        System.out.println("TreeMap, tailmap: " +   wordTreeMap.tailMap("elderberry"));
        System.out.println("NestedMap: " + nestedMap);

    }

    /**
     * Main method demonstrating the use of different maps
     * @param args
     */
    public static void main(String[] args) {
        NestedHashMapExample nm = new NestedHashMapExample();
        String test1 = "salt egg pepper juice carrot juice apple milk juice apple sandwich";
        nm.parseText(test1);

    }

}
