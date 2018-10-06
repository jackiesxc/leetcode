/**  
* <p>Description: </p>  
* @author Jackie Su  
* @date 2018年10月6日  
* @version 1.0  
*/  
package org.jackie.n50.normal;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.jackie.common.ListNode;
import org.jackie.common.Tools;
import org.junit.Test;

public class RemoveNthFromEnd {

	
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	int size = 1;
    	ListNode temp = head;
    	List<Integer> list = new LinkedList<Integer>();
    	list.add(temp.val);
    	//计算链表的个数
    	while (temp.next != null) {
    		temp = temp.next;
    		list.add(temp.val);
    		size++;
		}
    	
    	list.remove(size - n);

    	return convertListNode(list);
    }
    
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
    	RemoveNthFromEnd fun = new RemoveNthFromEnd();
    	ListNode node1 = fun.removeNthFromEnd(Tools.convertListNode(new int[]{1, 2, 3, 4, 5}), 2);
    	ListNode node2 = Tools.convertListNode(new int[]{1, 2, 3, 5});
    	assertEquals(node1.equals(node2), true);
    } 
    
    @Test
    public void test2() {
    	RemoveNthFromEnd fun = new RemoveNthFromEnd();
    	ListNode node1 = fun.removeNthFromEnd(Tools.convertListNode(new int[]{1}), 1);
    	//ListNode node2 = Tools.convertListNode(new int[]{});
    	assertEquals(node1, null);
    }  
}
