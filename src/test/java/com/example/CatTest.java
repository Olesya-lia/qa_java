package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;
    private Cat cat;

    @Before
    public void setCat(){
        cat = new Cat(feline);
    }

    @Test
    public void getSoundTest() {
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals("Неправильный звук кошки", expected, actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> expected = List.of("Животные","Птицы","Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expected);
        List<String> actual = cat.getFood();
        assertEquals("Неправильное питание", expected, actual);
    }
}