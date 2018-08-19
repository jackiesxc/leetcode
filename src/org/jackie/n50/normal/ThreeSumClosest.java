package org.jackie.n50.normal;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

//16. 最接近的三数之和
public class ThreeSumClosest {

	@Test
	public void test1() {
		ThreeSumClosest fun = new ThreeSumClosest();
		assertEquals(fun.threeSumClosest(new int[]{-1, 2, 1, -4}, 1), 2);
	}
	
	@Test
	public void test2() {
		ThreeSumClosest fun = new ThreeSumClosest();
		assertEquals(fun.threeSumClosest(new int[]{1, 1, 1, 1}, 0), 3);
	}
	
    public int threeSumClosest(int[] nums, int target) {
    	//三数之和与target的差值
    	int diff = Integer.MAX_VALUE;
    	int result = 0;
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length-2; i++) {
    		//先定义好一个数，然后对剩下两个数j和p进行移动
    		int j = i+1;
    		int p = nums.length-1;
    		while (j < p) {
    			int sum = nums[i] + nums[j] + nums[p];
    			int temp_diff = Math.abs(sum - target);
    			if (temp_diff  < diff) {
    				result = sum;
    				diff = temp_diff;
				}
    			
    			//如果sum比较小，则右移j值使得增加sum值
    			if (sum < target) {
					j++;
				}
    			//如果sum比较大，则左移p值使得减少sum值
    			else if (sum > target){
					p--;
				}
    			else {
					return result;
				}
    		}
    	}
    	return result;
    }

}
