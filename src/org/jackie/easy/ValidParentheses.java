package org.jackie.easy;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

public class ValidParentheses {
	ValidParentheses fun = new ValidParentheses();
	@Test
	public void test1() {
		assertEquals(fun.isValid("()[]{}"), true);
	}
	
	@Test
	public void test2() {
		assertEquals(fun.isValid("{[]}"), true);
	}
	
	@Test
	public void test3() {
		assertEquals(fun.isValid("([)]"), false);
	}
	
    public boolean isValid(String s) {
    	Stack<Character> stack = new Stack<>();
        if(s.length()%2 != 0){
            return false;
        }    	
    	
        for(int i=0;i<s.length();i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else if(stack.peek()=='(' && s.charAt(i)==')'){
                stack.pop();
            }else if(stack.peek()=='[' && s.charAt(i)==']'){
                stack.pop();
            }else if(stack.peek()=='{' && s.charAt(i)=='}'){
                stack.pop();
            }else{
               stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

}
