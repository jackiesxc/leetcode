package org.jackie.n50.easy;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class ValidParentheses {
	@Test
	public void test1() {
        ValidParentheses fun = new ValidParentheses();
		assertEquals(fun.isValid("()[]{}"), true);
	}
	
	@Test
	public void test2() {
        ValidParentheses fun = new ValidParentheses();
		assertEquals(fun.isValid("{[]}"), true);
	}
	
	@Test
	public void test3() {
        ValidParentheses fun = new ValidParentheses();
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
