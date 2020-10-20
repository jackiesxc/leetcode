package org.jackie.n50.difficult;

import org.jackie.common.ListNode;
import org.jackie.common.Tools;

import java.util.LinkedList;
import java.util.List;

/*����һ������ÿ k ���ڵ�һ����з�ת�������ط�ת�������

k ��һ��������������ֵС�ڻ��������ĳ��ȡ�����ڵ��������� k ������������ô�����ʣ��ڵ㱣��ԭ��˳��

ʾ�� :

�����������1->2->3->4->5

�� k = 2 ʱ��Ӧ������: 2->1->4->3->5

�� k = 3 ʱ��Ӧ������: 3->2->1->4->5

˵�� :

����㷨ֻ��ʹ�ó����Ķ���ռ䡣
�㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����*/
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
    	//�����е�Ԫ�ع���ɽڵ�list
    	while (head.next != null) {
    		head = head.next;
    		list.add(head);
		}
    	
    	int flag = 0;
		for (int index = 0; index < list.size(); index++) {
			// ��k�������б�
			if (index % k == 0) { //
				flag = index;
				subList = new LinkedList<ListNode>();
			}
			subList.add(list.get(index));
			// ��ÿ����subList����������
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
