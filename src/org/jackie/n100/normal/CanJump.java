package org.jackie.n100.normal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//55. ��Ծ��Ϸ
//˼·��ÿ��һ��jumpֵ-1��Ȼ���ж�jumpֵ������Ԫ���ĸ��󣬼�������ֱ���������һ�񣬻����ǵ�0ͣ����
public class CanJump {
	
    public boolean canJump(int[] nums) {
    	int jump = nums[0];
    	int index = 0;
    	while (jump > 0 && index <nums.length-1) {
			jump--;index++;
			if(nums[index] > jump)
				jump = nums[index];
			
		}
    	if (index+1 == nums.length) {
			return true;
		} else {
			return false;
		}
    }
    
    @Test
    public void test1() {
    	CanJump fun = new CanJump();
        assertEquals(fun.canJump(new int[]{2,3,1,1,4}), true);
    }  
    
    @Test
    public void test2() {
    	CanJump fun = new CanJump();
        assertEquals(fun.canJump(new int[]{3,2,1,0,4}), false);
    } 
}
