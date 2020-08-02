package org.jackie.n100.normal;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
//62. 不同路径
public class UniquePaths {
	//采用动态规划方法，f(m,n) = f(m-1, n) + f(m, n-1)
    public int uniquePaths(int length, int heigth) {
    	int[][] array = new int[length][heigth];
    	for (int i = 0; i < length; i++) {
    		array[i][0] =1;
		}
    	for (int i = 0; i < heigth; i++) {
    		array[0][i] =1;
		}
    	for (int i = 1; i < length; i++) {
			for (int j = 1; j < heigth; j++) {
				array[i][j] = array[i][j-1] + array[i-1][j];
			}
		}
    	return array[length-1][heigth-1];
    }
    
//    //使用递归方式，但不符合性能要求
//    private int run(int length, int heigth, int curX, int curY, int count) {
//		if(curX < length)
//			count = run(length, heigth, curX+1, curY, count);
//		if(curY < heigth)
//			count = run(length, heigth, curX, curY+1, count);
//		if(curX == length && curY == heigth){
//    		count++;
//    	}
//		return count;
//	}

	@Test
    public void test1() {
    	UniquePaths fun = new UniquePaths();
        assertEquals(fun.uniquePaths(3,2), 3);
    }
    
    @Test
    public void test2() {
    	UniquePaths fun = new UniquePaths();
        assertEquals(fun.uniquePaths(7,3), 28);
    }
    
    @Test
    public void test3() {
    	UniquePaths fun = new UniquePaths();
        assertEquals(fun.uniquePaths(19,13), 86493225);
    }
}
