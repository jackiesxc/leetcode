package org.jackie.n50.normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.jackie.common.ListNode;
import org.jackie.common.Tools;

public class AddTwoNumbers {

	public static void main(String[] args) {
		int[] l1 = {2,4,3};
		int[] l2 = {5,6,4};
		//int[] l1 = {0};
		//int[] l2 = {1};
		//int[] l1 = {9};
		//int[] l2 = {1,9,9,9,9,9,9,9,9,9};
		ListNode node1 = Tools.convertListNode(l1);
		ListNode node2 = Tools.convertListNode(l2);
		AddTwoNumbers function = new AddTwoNumbers();
		ListNode node = function.addTwoNumbers(node1, node2);
		System.out.println(807/10);
	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int num1=0;
    	int num2=0;
    	int carry = 0;
    	ListNode result = new ListNode(0);
    	ListNode curr = result;
    	while (l1 !=null || l2 != null) {
			num1 = l1 !=null?l1.val:0;
			num2 = l2 !=null?l2.val:0;
			int val = (num1 + num2 + carry)%10;
			carry = (num1 + num2 + carry)/10;
			//第一步：curr和result指向同一个对象(id:x)
			//第二步：curr和result的next对象指向同一个对象(id:y)
			curr.next = new ListNode(val);
			//第三步：此时curr指向y，而y仍是result的next对象指向
			curr = curr.next;
			if(l1 != null)
				l1 = l1.next;
			if(l2 != null)
				l2 = l2.next;
		}
    	
    	if (carry>0) {
    		curr.next = new ListNode(carry);
		}
        return result.next;
    }
    
/*    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }*/

}
