/**  
* <p>Description: </p>  
* @author Jackie Su  
* @date 2018年10月6日  
* @version 1.0  
*/  
package org.jackie.n50.easy;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.jackie.common.ListNode;
import org.jackie.common.Tools;
import org.junit.Test;

public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	List<Integer> list1 = convertList(l1);
    	List<Integer> list2 = convertList(l2);
    	list1.addAll(list2);
    	Collections.sort(list1);
    	return convertListNode(list1);
    }
    
    //将ListNode转成list
    public List<Integer> convertList(ListNode node){
    	List<Integer> list = new LinkedList<Integer>();
    	if (node==null) 
    		return list;
    	list.add(node.val);
    	ListNode temp = node;
    	while (temp.next != null) {
    		temp = temp.next;
    		list.add(temp.val);
		}
    	return list;
    }
    
    //将数组转成ListNode
	public ListNode convertListNode(List<Integer> keys) {
    	List<ListNode> list = new LinkedList<ListNode>();
		for (int i = 0; i < keys.size(); i++) {
			int index = keys.size() - i - 1;
			ListNode node = new ListNode(keys.get(index));
			if (i > 0){
				node.next = list.get(i-1);
			}
			list.add(node);
		}
		if (list.size()==0) {
			return null;
		}
		return list.get(list.size()-1);
	}
    
    @Test
    public void test1() {
    	MergeTwoLists fun = new MergeTwoLists();
    	ListNode node1 = fun.mergeTwoLists(Tools.convertListNode(new int[]{1, 2, 4}), 
    			Tools.convertListNode(new int[]{1, 3, 4}));
    	ListNode node2 = Tools.convertListNode(new int[]{1, 1, 2, 3, 4, 4});
    	assertEquals(node1.equals(node2), true);
    } 
    
    @Test
    public void test2() {
    	MergeTwoLists fun = new MergeTwoLists();
    	ListNode node1 = fun.mergeTwoLists(Tools.convertListNode(new int[]{}), 
    			Tools.convertListNode(new int[]{}));
    	assertEquals(node1==null, true);
    } 
}
