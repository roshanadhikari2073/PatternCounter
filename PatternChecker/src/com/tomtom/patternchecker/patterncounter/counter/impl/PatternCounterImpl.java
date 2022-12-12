package com.tomtom.patternchecker.patterncounter.counter.impl;

import com.tomtom.patternchecker.patterncounter.PatternCounterConstants;
import com.tomtom.patternchecker.patterncounter.counter.IPatternCounter;
import com.tomtom.patternchecker.utils.PatternCounterUtils;
import java.util.ArrayList;
import java.util.HashMap;



public class PatternCounterImpl implements IPatternCounter {
    @Override
    public HashMap<String, ?> getCounts(String path, Integer patternType) throws Exception {
        ArrayList<String> content = PatternCounterUtils.stringToArrayList(path);
        HashMap<String, ?> counts = new HashMap<>();
        switch (patternType){
            case PatternCounterConstants.WORD_COUNTER:
                PatternCounterUtils.getWordCounts(content);
                break;
            case PatternCounterConstants.INT_COUNTER:
                PatternCounterUtils.getNumberCounts(content);
                break;
            case PatternCounterConstants.PHRASE_COUNTER:
                PatternCounterUtils.getPhraseCounts(content);
                break;
            case PatternCounterConstants.ALL_PATTERNS_COUNTER:
                PatternCounterUtils.getAllPattern(content);
                break;
        }
        return counts;
    }
}
