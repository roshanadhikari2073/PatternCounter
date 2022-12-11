package com.tomtom.patternchecker.services.PatternCounterUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PatternCounterUtils {

    /**
     * @param str input to check
     * @return if value is numeric or not in Boolean
     */

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * @param filePath input of the path from the user
     * @return strings in list from the read path file
     */
    public ArrayList<String> argsToStringList(String filePath) throws IOException {
        ArrayList<String> words = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();
        while (!line.isEmpty()) {
            String[] lineWords = line.split(" ");
            for (String word : lineWords) {
                words.add(word);
            }
            line = reader.readLine();
        }
        reader.close();
        return words;
    }
}
