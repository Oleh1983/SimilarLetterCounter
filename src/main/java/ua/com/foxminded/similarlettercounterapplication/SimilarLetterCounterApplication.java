package ua.com.foxminded.similarlettercounterapplication;

import interfaces.ISimilarLetterCounter;
import ua.com.foxminded.similarlettercounterapplication.similarlettercounter.SimilarLetterCounter;
import ua.com.foxminded.similarlettercounterapplication.similarlettercounterproxy.SimilarLetterCounterProxy;

public class SimilarLetterCounterApplication {

    public static void main(String[] args) {

        ISimilarLetterCounter similarLetterCounterProxy = new SimilarLetterCounterProxy(new SimilarLetterCounter());
        System.out.println(similarLetterCounterProxy.counterProucesing("hello world!"));
        System.out.println(similarLetterCounterProxy.counterProucesing("the world is beautiful!"));
        System.out.println(similarLetterCounterProxy.counterProucesing("hello world!"));

    }
}
