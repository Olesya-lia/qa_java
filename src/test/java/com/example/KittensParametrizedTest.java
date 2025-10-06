package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class KittensParametrizedTest {

    @Mock
    Feline feline;

    int kittensCount;

    public KittensParametrizedTest(int kittensCount) {
        this.kittensCount = kittensCount;

        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters (name ="Количество котят: {0}")
    public static Object[] setKittensData() {
        return new Object[][]{
                {0},
                {3},
                {11},
                {999}
        };
    }

    @Test
    public void getKittensCountTest() {
        Mockito.when(feline.getKittens(kittensCount)).thenReturn(kittensCount);
        int actual = feline.getKittens(kittensCount);
        assertEquals("Количество котят не совпало",kittensCount, actual);
    }
}