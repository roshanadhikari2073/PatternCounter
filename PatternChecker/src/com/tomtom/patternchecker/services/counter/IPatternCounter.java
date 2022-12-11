package com.tomtom.patternchecker.services.counter;

import java.util.Map;

/**
 * Interface to be implemented for the pattern counter
 */
public interface IPatternCounter {
    /**
     * Get Distinct counts of word/number/phrase from given input string
     * @param file - file contents as string
     * @param fileName - name of the file
     * @return  Map&lt;String,Integer&gt;- The unique item as key and count as number
     */
    public Map<String, Integer> getCount(String file, String fileName);
}
