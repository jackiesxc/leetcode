package org.jackie.n50.difficult;

import org.jackie.common.ListNode;
import org.jackie.common.Tools;

import java.util.LinkedList;
import java.util.List;

/*给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。

示例 :

给定这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5

说明 :

你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。*/
public class ReverseKGroup {
	public static void main(String[] args) {
		int k = 2;
		int[] keys = {1,2,3,4,5,6};
		ListNode head = Tools.convertListNode(keys);
		ReverseKGroup reverse = new ReverseKGroup();
		ListNode node = reverse.reverseKGroup(head, k);
		node.print();
		while (node.next != null) {
			node = node.next;
			node.print();			
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head==null) {
			return null;
		}
    	List<ListNode> list = new LinkedList<ListNode>();
    	List<ListNode> subList = null;
    	list.add(head);
    	//将所有的元素构造成节点list
    	while (head.next != null) {
    		head = head.next;
    		list.add(head);
		}
    	
    	int flag = 0;
		for (int index = 0; index < list.size(); index++) {
			// 按k构造子列表
			if (index % k == 0) { //
				flag = index;
				subList = new LinkedList<ListNode>();
			}
			subList.add(list.get(index));
			// 对每个的subList进行排序处理
			if (index + 1 - flag == k) {
				reverseSubGroup(subList);
			}
		}
        return list.get(0);
        		
    }
    
    private void reverseSubGroup(List<ListNode> subList) {
    	int size = subList.size();
		for (int i = 0; i < size/2; i++) {
			swapListNode(subList.get(i), subList.get(size - 1 - i));
		}
		
	}
    
    private void swapListNode(ListNode nodeA, ListNode nodeB) {
		int temp = nodeA.val;
		nodeA.val = nodeB.val;
		nodeB.val = temp;
	}
    
/*    private Pair<ListNode, ListNode> swapListNode(ListNode nodeA, ListNode nodeB) {
		Pair<ListNode, ListNode> pair = new Pair<ListNode, ListNode>();
		int temp = nodeA.val;
		nodeA.val = nodeB.val;
		nodeB.val = temp;
		return pair;
	}*/
    
}
