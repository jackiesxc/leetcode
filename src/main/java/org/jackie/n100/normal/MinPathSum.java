package org.jackie.n100.normal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//64. 最小路径和
public class MinPathSum {
    public int minPathSum(int[][] grid) {
    	int m = grid.length;
    	int n = grid[0].length;
    	//建一个二维数组存放每个节点总和最大
    	int[][] maxCount = new int[m][n];
    	int count = 0;
    	for (int i = 0; i < n; i++) {
    		maxCount[0][i] = (count+= grid[0][i]);
		}
    	count = 0;
    	for (int i = 0; i < m; i++) {
    		maxCount[i][0] = (count+= grid[i][0]);
		}
    	for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				maxCount[i][j] = Math.min(maxCount[i-1][j], maxCount[i][j-1]) + grid[i][j];
			}
		}
    	return maxCount[m-1][n-1];
    }
    
	@Test
    public void test1() {
		MinPathSum fun = new MinPathSum();
        assertEquals(fun.minPathSum(new int[][] {{1,3,1}, {1,5,1}, {4,2,1}}), 7);
    }

}
