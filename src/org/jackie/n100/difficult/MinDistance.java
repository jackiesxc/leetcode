package org.jackie.n100.difficult;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//72. ±‡º≠æ‡¿Î
public class MinDistance {
	
    public int minDistance(String word1, String word2) {
    	int m = word1.length();
    	int n = word2.length();
    	int[][] array = new int[m+1][n+1];
    	for (int i = 0; i <= m; i++) {
			array[i][0] = i;
		}
    	for (int i = 0; i <= n; i++) {
			array[0][i] = i;
		}
    	for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				char char1 = word1.charAt(i-1);
				char char2 = word2.charAt(j-1);
				if(char1 == char2)
					array[i][j] = array[i-1][j-1];
				else
					array[i][j] = Math.min(array[i][j-1], Math.min(array[i-1][j],array[i-1][j-1])) + 1;
			}
		}
    	return array[m][n];
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
	
	@Test
    public void test3() {
		MinDistance fun = new MinDistance();
        assertEquals(fun.minDistance("", ""), 0);
    }
}
