/**  
* <p>Description: 39. 组合总和</p>  
* @author Jackie Su  
* @date 2020年1月25日  
* @version 1.0  
*/  
package org.jackie.n50.normal;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jackie.common.Tools;
import org.junit.Test;

public class CombinationSum {
	
	@Test
	public void test1() {
		CombinationSum fun = new CombinationSum();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(Tools.generateList(new Integer[]{7}));
		list.add(Tools.generateList(new Integer[]{2,2,3}));
        assertEquals(Tools.compareArrayList(fun.combinationSum(new int[]{2,3,6,7}, 7),  
        		list), true);
	}
	
	@Test
	public void test2() {
		CombinationSum fun = new CombinationSum();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(Tools.generateList(new Integer[]{2,2,2,2}));
		list.add(Tools.generateList(new Integer[]{2,3,3}));
		list.add(Tools.generateList(new Integer[]{3,5}));
        assertEquals(Tools.compareArrayList(fun.combinationSum(new int[]{2,3,5}, 8),  
        		list), true);
	}
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        
        if (candidates == null || candidates.length == 0 || target < 0) {
            return lists;
        }
        
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        processCalculate(0, target, candidates, lists, list);
        return lists;
    }
    
    public void processCalculate(int index, int target, int[] candidates, 
            List<List<Integer>> lists, List<Integer> list) {
        if(target < 0) {
            return;
        }
        if ( target == 0 )
        {
            lists.add( new ArrayList<Integer>(list) );
        } else if( target > 0 )
        {
            for ( int i = index; i < candidates.length; i++ )
            {
                int j = candidates[i];
                list.add( j );
                int newTarget = target-j;
                processCalculate(i, newTarget, candidates, lists, list);
                list.remove(list.size() - 1);
                if(newTarget <= 0)   //数组已按序排序，如果相等或者小于，则说明已超过范围，后续数无需再比较
                	break;
            }
        }
    }
}
