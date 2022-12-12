package com.tomtom.patternchecker.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PatternCounterUtils {
    
    public static Map<String, Long> getWordCounts(ArrayList<String> content){
        content.removeIf(e -> (isNumeric(e)));
        Map<String, Long> result = content.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return result;
    }

    public static Map<String, Long> getNumberCounts(ArrayList<String> content){
        content.removeIf(e -> !(isNumeric(e)));
        Map<String, Long> result = content.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return result;
    }

    public static HashMap<String, Integer> getPhraseCounts(ArrayList<String> content) throws Exception{
        HashMap<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < content.size() - 2; i++) {
            String phrase = content.get(i) + " " +content.get(i+1) + " " +content.get(i+2);
            int count = counts.getOrDefault(phrase, 0);
            counts.put(phrase, count + 1);
        }
        return counts;
    }

    public static HashMap<String, Map<String, Long>> getAllPattern(ArrayList<String> content){
        HashMap<String, Map<String, Long>> notificationItem = new HashMap<>();
        notificationItem.put("WORD COUNTS", getWordCounts(content));
        notificationItem.put("\n NUMERIC COUNTS", getWordCounts(content));
        notificationItem.put("\n PHRASE COUNTS", getWordCounts(content));
        return notificationItem;
    }


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
    public static ArrayList<String> stringToArrayList(String filePath) throws IOException {
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

    public void consolePrintMap(Map<String, ?> result) {
        for (Map.Entry<String, ?> entry : result.entrySet()) {
            String key = entry.getKey().toString();
            Object value = entry.getValue();
            if ((key != null) && (value == null)) {
                System.out.println(key + "\n");
            } else {
                System.out.println(key + ", " + value+"\n");
            }
        }

    }
}
