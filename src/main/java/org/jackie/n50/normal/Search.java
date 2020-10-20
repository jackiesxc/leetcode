/**  
* <p>Description: 33. ������ת��������</p>  
* @author Jackie Su  
* @date 2020��1��24��  
* @version 1.0  
*/  
package org.jackie.n50.normal;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Search {
	@Test
    public void test1() {
        Search fun = new Search();
        assertEquals(fun.search(new int[]{4,5,6,7,0,1,2}, 0), 4);
    }
    
    @Test
    public void test2() {
        Search fun = new Search();
        assertEquals(fun.search(new int[]{4,5,6,7,0,1,2}, 3), -1);
    }
    
    @Test
    public void test3() {
        Search fun = new Search();
        assertEquals(fun.search(new int[]{1,3}, 3), 1);
    }    
    public int search(int[] nums, int target) {
        if ( nums.length==0 )
        {
            return -1;
        }
        return search(nums, 0, nums.length-1, target);
    }
    
    //�ݹ�2�ַ�
    private int search(int[] nums, int low, int high, int target) {
        int middle = (high+low)/2;
        if ( nums[middle] == target)
        {
            return middle;
        }
        else if (low>=high) {
            return -1;
        }
        //����[8,1,2,3,4,5,6,7] ����
        else if (nums[middle] < nums[high]) {
            if ( nums[middle] < target && target <= nums[high]){
                return search(nums, middle+1, high, target);
            }
            else {
                return search(nums, low, middle, target);
            }
        }
        //nums[middle] > nums[high] ����[2,3,4,5,6,7,8,1] ����
        else{
            if ( nums[middle] > target && target >= nums[low]){
                return search(nums, low, middle, target);
            }
            else {
                return search(nums, middle+1, high, target);
            }           
        }
    }
}
