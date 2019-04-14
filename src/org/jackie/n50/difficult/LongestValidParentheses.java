/**  
* <p>Description: </p>  
* @author Jackie Su  
* @date 2019年4月14日  
* @version 1.0  
*/  
package org.jackie.n50.difficult;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int result=0;
        char[] charArray = s.toCharArray();
        //使用两个堆栈，一个存字符，一个存字符位置
        Stack<Character> stack = new Stack<Character>();
        Stack<Integer> charIndex = new Stack<Integer>();
        //1，循环一遍将仍保留在堆栈里的字符位置放在charIndex堆栈中
        for ( int i = 0; i < charArray.length; i++ )
        {
            if ( !stack.isEmpty() && charArray[i] == ')' && stack.peek()=='(')
            {
                stack.pop();
                charIndex.pop();
            } else
            { 
                stack.push( charArray[i] );
                charIndex.push( i );
            }
            
        }
        //2，特殊判断
        if ( charArray.length==0 )
        {
            return 0;
        }
        else if (stack.isEmpty()) {
            return charArray.length;
        }
        //3，记录最后的位置
        charIndex.push( charArray.length );
        //4，分别算出相邻的位置差，即是合法括号的字符数
        while ( !charIndex.isEmpty() )
        {
            int a = charIndex.peek();
            charIndex.pop();
            int b = charIndex.isEmpty()?-1:charIndex.peek();
            result = Math.max( a-b, result );
        }
        return result-1;
    }
    
	@Test
	public void test1() {
		LongestValidParentheses fun = new LongestValidParentheses();
		assertEquals(fun.longestValidParentheses("(()"), 2);
	}
	
	@Test
	public void test2() {
		LongestValidParentheses fun = new LongestValidParentheses();
		assertEquals(fun.longestValidParentheses(")()())"), 4);
	}	
}
