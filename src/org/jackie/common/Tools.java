package org.jackie.common;

import java.util.LinkedList;
import java.util.List;

public class Tools {
	public static ListNode convertListNode(int[] keys) {
    	List<ListNode> list = new LinkedList<ListNode>();
		for (int i = 0; i < keys.length; i++) {
			int index = keys.length - i - 1;
			ListNode node = new ListNode(keys[index]);
			if (i > 0){
				node.next = list.get(i-1);
			}
			list.add(node);
		}
		return list.get(list.size()-1);
	}
	
	public static ListNode convertListNode(List<Integer> keys) {
		if (keys.size()==0) {
			return new ListNode(0);
		}
    	List<ListNode> list = new LinkedList<ListNode>();
		for (int i = 0; i < keys.size(); i++) {
			int index = keys.size() - i - 1;
			ListNode node = new ListNode(keys.get(index));
			if (i > 0){
				node.next = list.get(i-1);
			}
			list.add(node);
		}
		return list.get(list.size()-1);
	}
	
	//比较两个数组是否相等
	static public<T> boolean compareList(List<T> list1, List<T> list2){
/*		if(list1.size() != list1.size())
			return false;*/
		boolean result = list2.containsAll(list1) && list1.containsAll(list2);	
		return result;	
	}
}
