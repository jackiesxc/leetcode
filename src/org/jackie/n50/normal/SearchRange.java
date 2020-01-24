/**  
* <p>Description: 34. 在排序数组中查找元素的第一个和最后一个位置</p>  
* @author Jackie Su  
* @date 2020年1月24日  
* @version 1.0  
*/  
package org.jackie.n50.normal;

import static org.junit.Assert.assertEquals;

import org.jackie.common.Tools;
import org.junit.Test;

public class SearchRange {
    
    @Test
    public void test1() {
        SearchRange fun = new SearchRange();
        assertEquals(Tools.compareArray(fun.searchRange(new int[]{5,7,7,8,8,10}, 8),  
                new int[] {3,4}), true);
    }
    
    @Test
    public void test2() {
        SearchRange fun = new SearchRange();
        assertEquals(Tools.compareArray(fun.searchRange(new int[]{5,7,7,8,8,10}, 6),  
                new int[] {-1,-1}), true);
    }
    
    @Test
    public void test3() {
        SearchRange fun = new SearchRange();
        assertEquals(Tools.compareArray(fun.searchRange(new int[]{7,7}, 6),  
                new int[] {-1,-1}), true);
    }
    
    @Test
    public void test4() {
        SearchRange fun = new SearchRange();
        assertEquals(Tools.compareArray(fun.searchRange(new int[]{7,7}, 7),  
                new int[] {0,1}), true);
    }
    
    public int[] searchRange(int[] nums, int target) {
        int index = searchEqualIndex(nums, 0, nums.length-1, target);
        if ( index<0 )
            return new int[]{-1,-1};
        
        int low =index-1;
        int high =index+1;
        //确认上下限的坐标
        while ( low>=0 && nums[low] ==target )
        {
            low--;           
        }
        while ( high<=nums.length-1 && nums[high] == target )
        {
            high++;           
        }
        return new int[]{low+1,high-1};
    }
    
    //递归折中法搜寻与target相等的元素
    public int searchEqualIndex(int[] nums, int start, int end, int target) {
        if ( start>end )
            return -1;
        int middle = (start + end)/2;
        if ( target > nums[middle] )
        {
            return searchEqualIndex(nums, middle+1, end, target);
        } else if ( target < nums[middle] )
        {
            return searchEqualIndex(nums, start, middle-1, target);
        }
        return middle;
    }
}
