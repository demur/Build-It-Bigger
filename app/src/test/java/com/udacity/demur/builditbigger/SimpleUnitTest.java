package com.udacity.demur.builditbigger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class SimpleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(3, 1 + 2);
    }

    @Test
    public void multiplication_isCorrect() throws Exception {
        assertEquals(9, 3 * 3);
    }
}