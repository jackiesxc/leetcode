package org.jackie.n50.easy;

import static org.junit.Assert.assertEquals;

import org.jackie.common.Tools;
import org.junit.Test;

//1. 两数之和
public class TwoSum {
	
	@Test
	public void test1() {
		TwoSum fun = new TwoSum();
		assertEquals(Tools.compareArray(fun.twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1}), true);
	}
	@Test
	public void test2() {
		TwoSum fun = new TwoSum();
		assertEquals(Tools.compareArray(fun.twoSum(new int[]{12, 7, 11, 15}, 23), new int[]{0, 2}), true);
	}
	
    public int[] twoSum(int[] nums, int target) {
        for ( int i = 0; i < nums.length; i++ )
        {
            for ( int j = i+1; j < nums.length; j++ )
            {
                if(nums[i] + nums[j]==target){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    } 
}
