package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp(){
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception {
        List<String> expected = List.of("Животные","Птицы","Рыба");
        List<String> actual = feline.eatMeat();
        assertEquals("Рацион не совпадает.", expected, actual);
    }

    @Test
    public void getFamily() {
        String expected = "Кошачьи";
        String actual = feline.getFamily();
        assertEquals("Не совпало семейство",expected, actual);
    }

    @Test
    public void getKittensTest() {
        int expected = 1;
        int actual = feline.getKittens();
        assertEquals("Не совпало количество котят",expected, actual);
    }
}