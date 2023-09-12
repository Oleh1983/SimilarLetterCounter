package ua.com.foxminded.similarlettercounterapplication.similarlettercounter;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import interfaces.ISimilarLetterCounter;

public class SimilarLetterCounter implements ISimilarLetterCounter {

    public String counterProucesing(String input) {

        StringBuilder countedLetters = new StringBuilder();
        
        countedLetters.append(input).append("\n");

        LinkedHashMap<String, Integer> difLetters = new LinkedHashMap<>();

        String[] dividedLatters = input.split("");

        for (int i = 0; i < input.length(); i++) {

            if (difLetters.containsKey(dividedLatters[i])) {
                difLetters.put(dividedLatters[i], difLetters.get(dividedLatters[i]) + 1);
            } else {
                difLetters.put(dividedLatters[i], 1);
            }
        }

        Iterator<Entry<String, Integer>> iterator = difLetters.entrySet().iterator();

        while (iterator.hasNext()) {
            Entry<String, Integer> charCounterEntry = iterator.next();

            countedLetters.append("\"").append(charCounterEntry.getKey()).append("\"").append(" - ")
                    .append(charCounterEntry.getValue()).append("\n");
        }
        return countedLetters.toString();
    }
}
