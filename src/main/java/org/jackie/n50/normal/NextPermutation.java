/**  
* <p>Description: </p>  
* @author Jackie Su  
* @date 2019��4��14��  
* @version 1.0  
*/  
package org.jackie.n50.normal;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int index = -1;
        //1����ĩβ��ǰ�������ҳ������������x ��843 76�е�76
        for ( int i = nums.length-1; i > 0; i-- )
        {
            if(nums[i-1] < nums[i]){
                index = i-1;
                break;
            }
        }
        //2������������������� 843 167
        Arrays.sort(nums , index+1, nums.length);
        //3����С���󽫸�λ����������ǰһλ����(3)���бȽϣ��������д��ڸ�����(6)��������С��������ֽ��н��������õ����    
        if ( index>-1 )
        {
            for ( int i = index+1; i < nums.length; i++ )
            {
                //������������λ��
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
