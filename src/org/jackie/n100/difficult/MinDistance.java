package org.jackie.n100.difficult;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//72. ±‡º≠æ‡¿Î
public class MinDistance {
	
    public int minDistance(String word1, String word2) {
    	return 0;
    }
    
	@Test
    public void test1() {
		MinDistance fun = new MinDistance();
        assertEquals(fun.minDistance("horse", "ros"), 3);
    }
	
	@Test
    public void test2() {
		MinDistance fun = new MinDistance();
        assertEquals(fun.minDistance("intention", "execution"), 5);
    }
}
