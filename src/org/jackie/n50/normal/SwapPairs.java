/**  
* <p>Description: </p>  
* @author Jackie Su  
* @date 2018年10月13日  
* @version 1.0  
*/  
package org.jackie.n50.normal;


import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.jackie.common.ListNode;
import org.jackie.common.Tools;
import org.junit.Test;

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
    	Integer[] intArray = convertList(head);
    	for (int i = 0; i < intArray.length; i++) {
			if (i%2 == 1) {
				//将相邻两个数组交换顺序
				int temp = intArray[i-1];
				intArray[i-1] = intArray[i];
				intArray[i] = temp;
			}
		}
        return convertListNode(intArray);
    }
    
    //将ListNode转成数组
    public Integer[] convertList(ListNode node){
    	List<Integer> list = new LinkedList<Integer>();
    	if (node==null) 
    		return new Integer[]{};
    	list.add(node.val);
    	ListNode temp = node;
    	while (temp.next != null) {
    		temp = temp.next;
    		list.add(temp.val);
		}
    	return list.toArray(new Integer[list.size()]);
    }
    
	public ListNode convertListNode(Integer[] keys) {
    	List<ListNode> list = new LinkedList<ListNode>();
		for (int i = 0; i < keys.length; i++) {
			int index = keys.length - i - 1;
			ListNode node = new ListNode(keys[index]);
			if (i > 0){
				node.next = list.get(i-1);
			}
			list.add(node);
		}
		if (keys.length == 0) {
			return null;
		}
		return list.get(list.size()-1);
	}
	
    @Test
    public void test1() {
    	SwapPairs fun = new SwapPairs();
    	ListNode node1 = fun.swapPairs(Tools.convertListNode(new int[]{1, 2, 3, 4}));
    	ListNode node2 = Tools.convertListNode(new int[]{2, 1, 4, 3});
    	assertEquals(node1.equals(node2), true);
    } 
}
