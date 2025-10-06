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
public class LionAlexTest {

    @Mock
    Feline feline;

    private LionAlex lionAlex;

    @Before
    public void serUp() throws Exception{
        lionAlex = new LionAlex("Самец",feline);
    }

    @Test
    public void getFriendsTest() {
        List<String> expected = List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
        List<String> actual = lionAlex.getFriends();
        assertEquals("Неверный список друзей", expected, actual);
    }

    @Test
    public void getPlaceOfLiving() {
        String expected = "Нью-Йоркский зоопарк";
        String actual = lionAlex.getPlaceOfLiving();
        assertEquals("Алекс живет в другом месте", expected, actual);
    }

    @Test
    public void getKittensTest() {
        int expected = 0;
        int actual = lionAlex.getKittens();
        assertEquals("У Алекса нет львят", expected, actual);
    }

    @Test
    public void haveManeTest(){
        assertTrue(lionAlex.doesHaveMane());
    }

    @Test
    public void getFoodTest() throws Exception {
        List<String> expected = List.of("Животные","Птицы","Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lionAlex.getFood();
        assertEquals("Неправильный рацион", expected, actual);
    }
}