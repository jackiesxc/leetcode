package org.jackie.n50.normal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxArea {
	@Test
	public void test() {
		MaxArea fun = new MaxArea();
		assertEquals(fun.maxArea(new int[]{1,8,6,2,5,4,8,3,7}), 49);
	}
	
    public int maxArea(int[] height) {
        int maxArea=0, i = 0, j= height.length-1;
        while (i < height.length) {
        	int a = height[i];
        	int b= height[j];
        	maxArea = Math.max(maxArea, countArea(i, j, a, b));
			if( a <= b || j<=i+1){
				i++;
				j = height.length-1;
			}
			else {
				j--;
			}
			
		}
        return maxArea;
    }
    
    private int countArea(int i, int j, int a, int b){  
    	return (Math.min(a, b))*(j-i);//高取小的值，长则等于两者相减
    }
	
}
