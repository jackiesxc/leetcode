package org.jackie.other.easy;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

//844. 比较含退格的字符串
public class BackspaceCompare {
    public boolean backspaceCompare(String S, String T) {
    	String finalS = translate(S);
    	String finalT = translate(T);
        return finalS.equals(finalT);
    	
    }
    
	private String translate(String str) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c != '#') {
				stack.add(c);
			}
			else if (stack.size() == 0) {
				continue;
			}
			else {
				stack.pop();
			}
		}
		return stack.toString();
	}

	@Test
    public void test1() {
		BackspaceCompare fun = new BackspaceCompare();
        assertEquals(fun.backspaceCompare("ab#c", "ad#c"), true);
    }
	
	@Test
    public void test2() {
		BackspaceCompare fun = new BackspaceCompare();
        assertEquals(fun.backspaceCompare("ab##", "c#d#"), true);
    }
	
	@Test
    public void test3() {
		BackspaceCompare fun = new BackspaceCompare();
        assertEquals(fun.backspaceCompare("a##c", "#a#c"), true);
    }
	
	@Test
    public void test4() {
		BackspaceCompare fun = new BackspaceCompare();
        assertEquals(fun.backspaceCompare("a#c", "b"), false);
    }
}
