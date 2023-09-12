package ua.com.foxminded.similarlettercounterapplication;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ua.com.foxminded.similarlettercounterapplication.similarlettercounter.SimilarLetterCounter;

class SimilarLetterCounterTest {

    SimilarLetterCounter similarLetterCounter;

    @BeforeEach
    void init() {
        similarLetterCounter = new SimilarLetterCounter();
    }

    @Test
    @DisplayName("Count each the same letter")
    void methodSimilarLetterCounter_CountEachTheSameLetter() {

        String tempString = similarLetterCounter.counterProucesing("hello world!");

        assertEquals("hello world!\n" + "\"h\" - 1\n" + "\"e\" - 1\n" + "\"l\" - 3\n" + "\"o\" - 2\n" + "\" \" - 1\n"
                + "\"w\" - 1\n" + "\"r\" - 1\n" + "\"d\" - 1\n" + "\"!\" - 1\n", tempString);

    }

    @Test
    @DisplayName("Is not null")
    void methodCounterProucesing_IsNotNuul() {

        String tempString = similarLetterCounter.counterProucesing("hello world!");

        assertNotNull(tempString);

    }

    @Test
    @DisplayName("When put empty string, get back blank line indent")
    void methodCounterProucesing_WhenPutEmtyString_GetBackBlankLineIndent() {

        String tempString = similarLetterCounter.counterProucesing("");

        assertEquals("\n", tempString);
    }

    @Test
    @DisplayName("Should return counted space, when put only one space")
    void methodCounterProucesing_ShouldReturnCountedSpase_WhenPutOnlyOneSpace() {

        String tempString = similarLetterCounter.counterProucesing(" ");

        assertEquals(" \n" + "\" \" - 1\n", tempString);

    }

    @Test
    @DisplayName("Should return counted spaces, when put several spaces")
    void methodCounterProucesing_ShouldReturnCountedSpases_WhenPutSeveralSpaces() {

        String tempString = similarLetterCounter.counterProucesing("    ");

        assertEquals("    \n" + "\" \" - 4\n", tempString);

    }

    @Test
    @DisplayName("Should return single counted character, when put single character")
    void methodCounterProucesing_ShouldReturnSingleCountedCharacter_WhenPutSingleCharacter() {

        String tempString = similarLetterCounter.counterProucesing("a");

        assertEquals("a\n" + "\"a\" - 1\n", tempString);

    }

    @Test
    @DisplayName("Should return counted the same characters, when put the same characters")
    void methodCounterProucesing_ShouldReturnCountedTheSameCharacters_WhenPutTheSameCharacters() {

        String tempString = similarLetterCounter.counterProucesing("aaaa");

        assertEquals("aaaa\n" + "\"a\" - 4\n", tempString);

    }

    @Test
    @DisplayName("Should return counted characters in lower and upper case mixed")
    void methodCounterProucesing_ShouldReturnCountedCharactersInLowerAndUpperCaseMixed() {

        String tempString = similarLetterCounter.counterProucesing("AbAb");

        assertEquals("AbAb\n" + "\"A\" - 2\n" + "\"b\" - 2\n", tempString);

    }

    @Test
    @DisplayName("Should return counted special symbols, when put only special symbols")
    void methodCounterProucesing_ShouldReturnCountedSpecialSimbols_WhenPutOnlySpecialSimbols() {

        String tempString = similarLetterCounter.counterProucesing("!*)&?&*!?)");

        assertEquals("!*)&?&*!?)\n" + "\"!\" - 2\n" + "\"*\" - 2\n" + "\")\" - 2\n" + "\"&\" - 2\n" + "\"?\" - 2\n",
                tempString);

    }

}
