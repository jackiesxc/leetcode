/**  
* <p>Description: </p>  
* @author Jackie Su  
* @date 2018年10月12日  
* @version 1.0  
*/  
package org.jackie.n50.difficult;

import org.jackie.common.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
    	List<Integer> list = new ArrayList<Integer>();
    	for (int i = 0; i < lists.length; i++) {
    		list.addAll(convertList(lists[i]));
		}
    	Collections.sort(list);
        return convertListNode(list);
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
}
