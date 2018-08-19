package org.jackie.n50.normal;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

//16. ��ӽ�������֮��
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
    	//����֮����target�Ĳ�ֵ
    	int diff = Integer.MAX_VALUE;
    	int result = 0;
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length-2; i++) {
    		//�ȶ����һ������Ȼ���ʣ��������j��p�����ƶ�
    		int j = i+1;
    		int p = nums.length-1;
    		while (j < p) {
    			int sum = nums[i] + nums[j] + nums[p];
    			int temp_diff = Math.abs(sum - target);
    			if (temp_diff  < diff) {
    				result = sum;
    				diff = temp_diff;
				}
    			
    			//���sum�Ƚ�С��������jֵʹ������sumֵ
    			if (sum < target) {
					j++;
				}
    			//���sum�Ƚϴ�������pֵʹ�ü���sumֵ
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
