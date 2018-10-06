package org.jackie.common;

public class ListNode {
	public int val = -1;
	public ListNode next = null;

	public ListNode(int x) {
		val = x;
	}
	
	public void print() {
		if (next == null) {
			System.out.println(val);
		}
		else {
			System.out.println(val + "->" + next.val);
		}
	}
	
	@Override
	public String toString() {
		return val +"";
	}
	
	@Override
	public boolean equals(Object object) {
		if(this==object)
			return true;
		if(object instanceof ListNode){
			ListNode anotherListNode = (ListNode) object;
			if (this.next == null && anotherListNode.next==null && this.val == anotherListNode.val) {
				return true;
			}
			else {
				return this.next.equals(anotherListNode.next);
			}
		}
		return false;
	}
	
}
