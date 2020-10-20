/**  
* <p>Description: </p>  
* @author Jackie Su  
* @date 2019年4月14日  
* @version 1.0  
*/  
package org.jackie.n50.normal;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int index = -1;
        //1，从末尾往前遍历，找出最大逆序排列x 即843 76中的76
        for ( int i = nums.length-1; i > 0; i-- )
        {
            if(nums[i-1] < nums[i]){
                index = i-1;
                break;
            }
        }
        //2，对逆序进行正序排列 843 167
        Arrays.sort(nums , index+1, nums.length);
        //3，从小到大将各位数字与逆序前一位数字(3)进行比较，将排列中大于该数字(6)且数字最小的与该数字进行交换，即得到结果    
        if ( index>-1 )
        {
            for ( int i = index+1; i < nums.length; i++ )
            {
                //将两个数交换位置
                if ( nums[i] > nums[index] )
                {
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    break;
                }
            }
        }
    }
    
    @Test
    public void test1() {
        NextPermutation fun = new NextPermutation();
        int[] nums = {8,4,3,7,6,1};
        int[] expectNums = {8,4,6,1,3,7};
        fun.nextPermutation(nums);
        assertEquals(Arrays.equals(nums, expectNums), true);
    }
    
    @Test
    public void test2() {
        NextPermutation fun = new NextPermutation();
        int[] nums = {3,44, 6, 5};
        int[] expectNums = {5, 3, 6, 44};
        fun.nextPermutation(nums);
        assertEquals(Arrays.equals(nums, expectNums), true);
    }
    
    @Test
    public void test3() {
        NextPermutation fun = new NextPermutation();
        int[] nums = {9,8,6,5};
        int[] expectNums = {5,6,8,9};
        fun.nextPermutation(nums);
        assertEquals(Arrays.equals(nums, expectNums), true);
    } 
}
