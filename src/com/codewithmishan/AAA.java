package com.codewithmishan;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;


public class AAA {
    public static void main(String[] args) {
        String encoding = "UTF-8";

        // Array of Sinhala words (including hyphenated words)
        String[] sinhalaWords = {
                "නමස්කාරය", "කරුණාකර", "ස්තූතියි", "ආයුබෝවන්",
                "සුබ-උදෑසනක්", "සුබ-දවසක්", "සුබ-රාත්‍රියක්", "ආයුබෝවන්-කරුණාකර", "අම්මා - කාර", "අම්මා - ඇර", "අමමා - ආර", "ඇය - අම්මා", "01 - ඇය - අම්මා"
        };

        // Sort the words based on the first word before the hyphen
        Arrays.sort(sinhalaWords, (word1, word2) -> {
            // Split words if hyphenated
            String[] parts1 = word1.split("-");
            String[] parts2 = word2.split("-");
            // Compare first words based on Sinhala character order
            int comparison = Character.compare(parts1[0].charAt(0), parts2[0].charAt(0));
            if (comparison != 0) return comparison;
            // If first words are identical, compare remaining parts (if any)
            if (parts1.length > 1 && parts2.length > 1) {
                comparison = Arrays.compare(parts1, 1, parts1.length, parts2, 1, parts2.length);
                if (comparison != 0) return comparison;
            }
            // Handle different word lengths and hyphen usage
            return word1.length() - word2.length();
        });

        // Print the sorted words with proper encoding
        for (String word : sinhalaWords) {
            System.out.println(word);
        }

//        // Handle user input with UTF-8 encoding (optional)
//        Scanner scanner = new Scanner(System.in, encoding);
//        System.out.print("Enter a Sinhala word: ");
//        String userInput = scanner.nextLine();
//        System.out.println("You entered: " + userInput);

    }

}
