package org.jackie.normal;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyAtoi {
	@Test
	public void test1() {
		MyAtoi fun = new MyAtoi();
		assertEquals(fun.myAtoi("4193 with words"), 4193);
	}
	
	@Test
	public void test2() {
		MyAtoi fun = new MyAtoi();
		assertEquals(fun.myAtoi("words and 987"), 0);
	}
	
	@Test
	public void test3() {
		MyAtoi fun = new MyAtoi();
		assertEquals(fun.myAtoi("-91283472332"), -2147483648);
	}
	
	@Test
	public void test4() {
		MyAtoi fun = new MyAtoi();
		assertEquals(fun.myAtoi("-4193 with words"), -4193);
	}
	
	@Test
	public void test5() {
		MyAtoi fun = new MyAtoi();
		assertEquals(fun.myAtoi("-+1"), 0);
	}
	
	@Test
	public void test6() {
		MyAtoi fun = new MyAtoi();
		assertEquals(fun.myAtoi("20000000000000000000"), 2147483647);
	}
	
	@Test
	public void test7() {
		MyAtoi fun = new MyAtoi();
		assertEquals(fun.myAtoi("-9223372036854775809"), -2147483648);
	}
	
	@Test
	public void test8() {
		MyAtoi fun = new MyAtoi();
		assertEquals(fun.myAtoi("3.14159"), 3);
	}
	
	@Test
	public void test9() {
		MyAtoi fun = new MyAtoi();
		assertEquals(fun.myAtoi("+344tt"), 344);
	}
	
    public int myAtoi(String str) {
        str = str.trim();
        int result = 0;
        boolean isPos = true;
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(i==0 && (c=='-'||c=='+')){
                isPos = c=='+'?true:false;
            } else if (c>='0' && c<='9'){
                // 检查溢出情况
                if(result>(Integer.MAX_VALUE - (c - '0'))/10){
                    return isPos? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result *= 10;
                result += c - '0';
            } else {
                return isPos?result:-result;
            }
        }
        return isPos?result:-result;
    }

}
