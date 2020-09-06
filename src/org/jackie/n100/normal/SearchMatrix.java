package org.jackie.n100.normal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//74. 搜索二维矩阵
//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

//  每行中的整数从左到右按升序排列。
//  每行的第一个整数大于前一行的最后一个整数。

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if ( matrix.length==0 )
            return false;        
        int m = matrix[0].length;
        int indexRow = countIndexRow(matrix, target, m);
    	return isExist(matrix[indexRow], target, 0, m-1);
    }
    
    private boolean isExist( int[] matrix, int target, int start, int end )
    {
        while ( start <= end )
        {
        	int index = (start + end)/2;
            if ( target > matrix[index] )
            {
                start = index+1;
            }
            else if ( target < matrix[index]) {
                end = index-1;
            }
            else {
                return true;
            }
        }
        return false;
    }

    private int countIndexRow( int[][] matrix, int target, int m)
    {
        int n = matrix.length;
    	int start= 0; 
    	int end = n-1;
        while ( end > start )
        {
        	int index = (start + end)/2;
        	
            if ( target < matrix[index][0] )
            {
            	end = index-1;
            }
            else if ( target > matrix[index][m-1] ){
            	start = index+1;
            }
            else {
            	return index;
			}
        }
        return start;
    }
    
	@Test
    public void test1() {
		SearchMatrix fun = new SearchMatrix();
		assertEquals(true, fun.searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 3));
    }
	
	@Test
    public void test2() {
		SearchMatrix fun = new SearchMatrix();
		assertEquals(false, fun.searchMatrix(new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 13));
    }
	
	@Test
    public void test3() {
		SearchMatrix fun = new SearchMatrix();
		assertEquals(true, fun.searchMatrix(new int[][] {{1}}, 1));
    }
	
	@Test
    public void test4() {
		SearchMatrix fun = new SearchMatrix();
		assertEquals(true, fun.searchMatrix(new int[][] {{1},{3}}, 3));
    }
}
