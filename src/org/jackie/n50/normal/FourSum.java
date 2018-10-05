/**    
* <p>18. 四数之和 </p>  
* @author Jackie Su  
* @date 2018年10月1日  
* @version 1.0  
*/ 
package org.jackie.n50.normal;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jackie.common.Tools;
import org.junit.Test;

public class FourSum {	
	
	@Test
	public void test1() {
		FourSum fun = new FourSum();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(Tools.generateList(new Integer[]{-3,-1,2,4}));
		boolean flag = Tools.compareList(fun.fourSum(new int[]{-3,-1,0,2,4,5}, 2), list);
		assertEquals(flag, true);
	}
	
	@Test
	public void test2() {
		FourSum fun = new FourSum();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(Tools.generateList(new Integer[]{-79583480, -70078020, -65863359, -21202664}));
		list.add(Tools.generateList(new Integer[]{-76072023, -59608044, -58094433, -42953023}));
		boolean flag = Tools.compareList(fun.fourSum(new int[]{91277418,66271374,38763793,4092006,11415077,60468277,1122637,72398035,-62267800,22082642,60359529,-16540633,92671879,-64462734,-55855043,-40899846,88007957,-57387813,-49552230,-96789394,18318594,-3246760,-44346548,-21370279,42493875,25185969,83216261,-70078020,-53687927,-76072023,-65863359,-61708176,-29175835,85675811,-80575807,-92211746,44755622,-23368379,23619674,-749263,-40707953,-68966953,72694581,-52328726,-78618474,40958224,-2921736,-55902268,-74278762,63342010,29076029,58781716,56045007,-67966567,-79405127,-45778231,-47167435,1586413,-58822903,-51277270,87348634,-86955956,-47418266,74884315,-36952674,-29067969,-98812826,-44893101,-22516153,-34522513,34091871,-79583480,47562301,6154068,87601405,-48859327,-2183204,17736781,31189878,-23814871,-35880166,39204002,93248899,-42067196,-49473145,-75235452,-61923200,64824322,-88505198,20903451,-80926102,56089387,-58094433,37743524,-71480010,-14975982,19473982,47085913,-90793462,-33520678,70775566,-76347995,-16091435,94700640,17183454,85735982,90399615,-86251609,-68167910,-95327478,90586275,-99524469,16999817,27815883,-88279865,53092631,75125438,44270568,-23129316,-846252,-59608044,90938699,80923976,3534451,6218186,41256179,-9165388,-11897463,92423776,-38991231,-6082654,92275443,74040861,77457712,-80549965,-42515693,69918944,-95198414,15677446,-52451179,-50111167,-23732840,39520751,-90474508,-27860023,65164540,26582346,-20183515,99018741,-2826130,-28461563,-24759460,-83828963,-1739800,71207113,26434787,52931083,-33111208,38314304,-29429107,-5567826,-5149750,9582750,85289753,75490866,-93202942,-85974081,7365682,-42953023,21825824,68329208,-87994788,3460985,18744871,-49724457,-12982362,-47800372,39958829,-95981751,-71017359,-18397211,27941418,-34699076,74174334,96928957,44328607,49293516,-39034828,5945763,-47046163,10986423,63478877,30677010,-21202664,-86235407,3164123,8956697,-9003909,-18929014,-73824245}, -236727523), list);
		assertEquals(flag, true);
	}	
	
	@Test
	public void test3() {
		FourSum fun = new FourSum();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(Tools.generateList(new Integer[]{-5,2,2,4}));
		list.add(Tools.generateList(new Integer[]{-1,0,2,2}));
		boolean flag = Tools.compareList(fun.fourSum(new int[]{-1,2,2,-5,0,-1,4}, 3), list);
		assertEquals(flag, true);
	}
	
	@Test
	public void test4() {
		FourSum fun = new FourSum();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(Tools.generateList(new Integer[]{-1,  0, 0, 1}));
		list.add(Tools.generateList(new Integer[]{-2, -1, 1, 2}));
		list.add(Tools.generateList(new Integer[]{-2,  0, 0, 2}));
		boolean flag = Tools.compareList(fun.fourSum(new int[]{1,0,-1,0,-2,2}, 0), list);
		assertEquals(flag, true);
	}
	
	@Test
	public void test5() {
		FourSum fun = new FourSum();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(Tools.generateList(new Integer[]{-5,1,3,5}));
		boolean flag = Tools.compareList(fun.fourSum(new int[]{5,5,3,5,1,-5,1,-2}, 4), list);
		assertEquals(flag, true);
	}
	
	@Test
	public void test6() {
		FourSum fun = new FourSum();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		list.add(Tools.generateList(new Integer[]{-5,-4,-3,1}));
		boolean flag = Tools.compareList(fun.fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11), list);
		assertEquals(flag, true);
	}
	
    public List<List<Integer>> fourSum(int[] nums, int target) {    
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	Arrays.sort(nums);
    	for (int k = 0; k < nums.length; k++) {
    		if(k>0 && nums[k]== nums[k-1]) continue;
    		for (int j = k+1; j < nums.length; j++) {
    			int p = nums.length-1;
    			int y = nums.length-2;
    			if(j>k+1 && nums[j]== nums[j-1]) continue;
    			while (j < p-1) {
    				if(j >= y || (p < nums.length-1 && nums[p] == nums[p+1])){
    					p--;
    					y=p-1;
    					continue;
    				}
					if (y < p-1 - 2 && nums[y] == nums[y+1]) {
						y--;
						continue;
					}
					int sum = nums[k] + nums[j] + nums[y] + nums[p];
					if(sum == target){
						List<Integer> list = new ArrayList<Integer>();
						list.add(nums[k]);
						list.add(nums[j]);
						list.add(nums[y]);
						list.add(nums[p]);
						result.add(list);
    					p--;
    					y=p-1;
    					continue;
					}
					else if(sum < target && y==p-1){
						break;
					}
					else if(sum < target){
    					p--;
    					y=p-1;
    					continue;
					}
					else if(sum > target && k==p-3){
						return result;
					}
					else {
						y--;
					}
    			}
    		}
    	}
        return result;
    }
}
