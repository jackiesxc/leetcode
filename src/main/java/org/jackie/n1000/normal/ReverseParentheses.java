package org.jackie.n1000.normal;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

//1190. 反转每对括号间的子串
public class ReverseParentheses {
    public String reverseParentheses(String s) {
        char[] charList = s.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        String str = "";
        for (int i = 0; i < charList.length ; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);  //将左括号的标号记在stack中
            } else if (c == ')') {
                reverseStr(charList, stack.pop() + 1, i-1);
            }
        }
        StringBuffer strb = new StringBuffer();
        for (char c : charList) {
            if (c != '(' && c != ')') {
                strb.append(c);
            }
        }
        return strb.toString();
    }

    //交换字符串
    private void reverseStr(char[] charList, int start, int end) {
        while (start < end ){
            char temp = charList[start];
            charList[start] = charList[end];
            charList[end] = temp;
            start++; end--;
        }
    }


    @Test
    public void test1() {
        ReverseParentheses fun = new ReverseParentheses();
        assertEquals(fun.reverseParentheses("(abcd)" ), "dcba");
    }

    @Test
    public void test2() {
        ReverseParentheses fun = new ReverseParentheses();
        assertEquals("iloveu", fun.reverseParentheses("(u(love)i)" ));
    }

    @Test
    public void test3() {
        ReverseParentheses fun = new ReverseParentheses();
        assertEquals("leetcode", fun.reverseParentheses( "(ed(et(oc))el)" ));
    }

    @Test
    public void test4() {
        ReverseParentheses fun = new ReverseParentheses();
        assertEquals("apmnolkjihgfedcbq", fun.reverseParentheses("a(bcdefghijkl(mno)p)q" ));
    }

    @Test
    public void test5() {
        ReverseParentheses fun = new ReverseParentheses();
        assertEquals("tauswa", fun.reverseParentheses("ta()usw((((a))))" ));
    }
}
