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
public class LionTest {

    @Mock
    private Feline feline;

    private Lion lion;


    @Before
    public void setLion() throws Exception{
       lion = new Lion("Самец", feline);
    }

    @Test
    public void haveManeThrowsExceptionTest() {
        try {
          new Lion("Некорректный пол", feline);
        } catch (Exception exception){
            String expected = "Используйте допустимые значения пола животного - Cамец или Cамка";
            assertEquals(expected, exception.getMessage());
        }
    }

    @Test
    public void getKittensTest() {
        int expected = 1;
        Mockito.when(feline.getKittens()).thenReturn(expected);
        int actual = lion.getKittens();
        assertEquals("Не совпало количество львят",expected, actual);
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> expected = List.of("Животные","Птицы","Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion.getFood();
        assertEquals("Неправильный рацион", expected, actual);
    }
}