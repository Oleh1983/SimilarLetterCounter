package ua.com.foxminded.similarlettercounterapplication.similarlettercounterproxy;

import interfaces.ISimilarLetterCounter;

import java.util.HashMap;
import java.util.Map;

public class SimilarLetterCounterProxy implements ISimilarLetterCounter {

    private ISimilarLetterCounter similarLetterCounter;
    private Map<String, String> cache;

    public SimilarLetterCounterProxy(ISimilarLetterCounter similarLetterCounter) {

        this.similarLetterCounter = similarLetterCounter;
        cache = new HashMap<>();
    }

    @Override
    public String counterProucesing(String input) {

        String cachedString;

        if (cache.containsKey(input)) {

            cachedString = cache.get(input);

        } else {

            cachedString = similarLetterCounter.counterProucesing(input);
            cache.put(input, cachedString);

        }

        return cachedString;
    }
}
