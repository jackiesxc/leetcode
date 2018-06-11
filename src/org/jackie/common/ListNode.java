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
	
}
