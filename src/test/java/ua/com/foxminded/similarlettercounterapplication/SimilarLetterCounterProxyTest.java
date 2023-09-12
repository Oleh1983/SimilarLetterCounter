package ua.com.foxminded.similarlettercounterapplication;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import interfaces.ISimilarLetterCounter;
import ua.com.foxminded.similarlettercounterapplication.similarlettercounterproxy.SimilarLetterCounterProxy;

class SimilarLetterCounterProxyTest {

    @Test
    @DisplayName("Gets the value from the cache, when put the same string more than once")
    void methodCounterProucesingProxy_GetsTheValueFromTheCache_WhenPutTheSameStringMoreThanOnce() {

        ISimilarLetterCounter isimilarLetterCounterMock = mock(ISimilarLetterCounter.class);

        SimilarLetterCounterProxy similarLetterCounterProxySpy = spy(new SimilarLetterCounterProxy(isimilarLetterCounterMock));
        
        when(isimilarLetterCounterMock.counterProucesing("hello world!"))
                .thenReturn("\"h\" - 1\n" + "\"e\" - 1\n" + "\"l\" - 3\n" + "\"o\" - 2\n" + "\" \" - 1\n"
                        + "\"w\" - 1\n" + "\"r\" - 1\n" + "\"d\" - 1\n" + "\"!\" - 1\n");

        similarLetterCounterProxySpy.counterProucesing("hello world!");
        similarLetterCounterProxySpy.counterProucesing("hello world!");
        
         verify(isimilarLetterCounterMock, atMost (1)).counterProucesing("hello world!");
        
    }

    @Test
    @DisplayName("Is null, when put the null")
    void methodCounterProucesingProxy_IsNuul_WhenPutTheNull() {

        ISimilarLetterCounter isimilarLetterCounterMock = mock(ISimilarLetterCounter.class);

        SimilarLetterCounterProxy mySimilarLetterCounterProxy = new SimilarLetterCounterProxy(
                isimilarLetterCounterMock);

        when(isimilarLetterCounterMock.counterProucesing(null)).thenReturn(null);

        assertNull(mySimilarLetterCounterProxy.counterProucesing(null));
    }

    @Test
    @DisplayName("Is empty")
    void methodCounterProucesingProxy_IsEmpty() {

        ISimilarLetterCounter isimilarLetterCounterMock = mock(ISimilarLetterCounter.class);

        SimilarLetterCounterProxy mySimilarLetterCounterProxy = new SimilarLetterCounterProxy(
                isimilarLetterCounterMock);

        when(isimilarLetterCounterMock.counterProucesing("")).thenReturn("");
        assertEquals("", mySimilarLetterCounterProxy.counterProucesing(""));

    }

    @Test
    @DisplayName("Is empty, when call the same empty string twice")
    void methodCounterProucesing_IsEmpty_WhenCallTheSameEmptyStringTwice() {

        ISimilarLetterCounter isimilarLetterCounterMock = mock(ISimilarLetterCounter.class);

        SimilarLetterCounterProxy mySimilarLetterCounterProxy = new SimilarLetterCounterProxy(
                isimilarLetterCounterMock);

        when(isimilarLetterCounterMock.counterProucesing("")).thenReturn("");

        mySimilarLetterCounterProxy.counterProucesing("");

        assertEquals("", mySimilarLetterCounterProxy.counterProucesing(""));
    }

    @Test
    @DisplayName("Calls at least twice")
    void methodCounterProucesing_CallsAtLeastTwice() {

        ISimilarLetterCounter isimilarLetterCounterMock = mock(ISimilarLetterCounter.class);

        SimilarLetterCounterProxy mySimilarLetterCounterProxy = new SimilarLetterCounterProxy(
                isimilarLetterCounterMock);

        mySimilarLetterCounterProxy.counterProucesing(isimilarLetterCounterMock.counterProucesing("hello world!"));
        mySimilarLetterCounterProxy.counterProucesing(isimilarLetterCounterMock.counterProucesing("hello world!"));

        verify(isimilarLetterCounterMock, atLeast(2)).counterProucesing("hello world!");
    }
}
