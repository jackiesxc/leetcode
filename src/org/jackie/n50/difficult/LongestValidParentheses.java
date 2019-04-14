/**  
* <p>Description: </p>  
* @author Jackie Su  
* @date 2019��4��14��  
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
        //ʹ��������ջ��һ�����ַ���һ�����ַ�λ��
        Stack<Character> stack = new Stack<Character>();
        Stack<Integer> charIndex = new Stack<Integer>();
        //1��ѭ��һ�齫�Ա����ڶ�ջ����ַ�λ�÷���charIndex��ջ��
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
        //2�������ж�
        if ( charArray.length==0 )
        {
            return 0;
        }
        else if (stack.isEmpty()) {
            return charArray.length;
        }
        //3����¼����λ��
        charIndex.push( charArray.length );
        //4���ֱ�������ڵ�λ�ò���ǺϷ����ŵ��ַ���
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
