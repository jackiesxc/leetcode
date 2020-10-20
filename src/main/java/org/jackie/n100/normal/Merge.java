package org.jackie.n100.normal;

import org.jackie.common.Tools;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

//56 合并区间  
//思路：一次循环，判断下一个元素的last值是否大于当前元素的first值
public class Merge {

    public int[][] merge(int[][] intervals) {
    	List<int[]> result = new ArrayList<>();
    	Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    	if (intervals.length==0 || intervals == null) {
			return result.toArray(new int[0][]);
		}
    	int first = 0;
    	int last = 0;
    	for (int i = 0; i < intervals.length; i++) {
    		if(i ==0){
    	    	first = intervals[0][0];
    	    	last = intervals[0][1];
    		}
			if(intervals[i][0] <= last){
				last = Math.max(last, intervals[i][1]);
				if (i!=intervals.length-1) continue;
			}
			else{
				int[] array = {first, last};
				result.add(array);
		    	first = intervals[i][0];
		    	last = intervals[i][1];				
			}
			if (i==intervals.length-1) { //处理最后一个元素
				int[] array = {first, last};
				result.add(array);
			}
		}
    	return result.toArray(new int[0][]);
    }
    
    @Test
    public void test1() {
    	Merge fun = new Merge();
        assertEquals(Tools.compareArray(
        		fun.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}}), 
        		new int[][]{{1,6},{8,10},{15,18}}), true);
    }  
    
    @Test
    public void test2() {
    	Merge fun = new Merge();
        assertEquals(Tools.compareArray(
        		fun.merge(new int[][]{{1,4},{4,5}}), 
        		new int[][]{{1,5}}), true);
    }  
    
    @Test
    public void test3() {
    	Merge fun = new Merge();
        assertEquals(Tools.compareArray(
        		fun.merge(new int[][]{{1,4},{0,4}}), 
        		new int[][]{{0,4}}), true);
    } 

    //[[1,4],[2,3]]
    @Test
    public void test4() {
    	Merge fun = new Merge();
        assertEquals(Tools.compareArray(
        		fun.merge(new int[][]{{1,4},{2,3}}), 
        		new int[][]{{1,4}}), true);
    }
}
