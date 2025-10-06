package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    @Mock
    Feline feline;

    private String sex;
    private Boolean hasMane;

    public LionParametrizedTest(String sex, boolean hasMane){
        this.sex = sex;
        this.hasMane = hasMane;

        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters (name ="Пол льва: {0},{1}")
    public static Object[] setSexLionData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void lionHasManeTest() throws Exception{
        Lion lion = new Lion(sex,feline);
        boolean expected = hasMane;
        boolean actual = lion.doesHaveMane();
        assertEquals("Пол льва не соответствует", expected, actual);
    }
}