package org.jackie.common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
		if (keys.length == 0) {
			return null;
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
	
	//比较两个list是否相等
	static public<T> boolean compareList(List<T> list1, List<T> list2){
		if(list1.size() != list1.size())
			return false;
		boolean result = list2.containsAll(list1) && list1.containsAll(list2);	
		return result;	
	}
	
	//比较两个list是否相等
	static public<T> boolean compareArrayList(List<List<T>> list1, List<List<T>> list2){
		if (list1.size() != list2.size()) 
			return false;
		for (List<T> l1 : list1) {
			boolean flag = false;  //l1是否包含在list2中的标识
			for (List<T> l2 : list2) {
				if (compareList(l1, l2)) {
					flag = true;
					break;
				}
			}
			if (!flag) 
				return false;
		}
		return true;	
	}
	
	//比较两个数组是否相等
    static public boolean compareArray(int[] array1, int[] array2){

        List<Integer> list1=IntStream.of(array1).boxed().collect(Collectors.toList());
        List<Integer> list2=IntStream.of(array2).boxed().collect(Collectors.toList());
        boolean result = list2.containsAll(list1) && list1.containsAll(list2);  
        return result;  
    }
	
    //将数组转换成list
	static public<T> List<T> generateList(T[] values){
		List<T> list = new ArrayList<T>();
		for (T element : values) {
			list.add(element);
		}
		return list;
	}
	
	public static void main(String[] args) {
		List<List<Integer>> list1 = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(1);
		l1.add(1);
		list1.add(l1);
		List<Integer> l11 = new ArrayList<Integer>();
		l11.add(1);
		l11.add(3);
		l11.add(5);	
		l11.add(5);
		list1.add(l11);
		List<List<Integer>> list2 = new ArrayList<List<Integer>>();
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(1);
		l2.add(1);
		l2.add(1);
		list2.add(l2);
		List<Integer> l22 = new ArrayList<Integer>();
		l22.add(1);
		l22.add(3);
		l22.add(5);	
		list2.add(l22);
		System.out.println(compareArrayList(list1,list2));
	}
}
