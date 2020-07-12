package org.jackie.n550.easy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReverseStr {
	@Test
	public void test1() {
		ReverseStr fun = new ReverseStr();
		assertEquals(fun.reverseStr("abcdefg", 2), "bacdfeg");
	}
	
	@Test
	public void test2() {
		ReverseStr fun = new ReverseStr();
		assertEquals(fun.reverseStr("a", 1), "a");
	}
	
	@Test
	public void test3() {
		ReverseStr fun = new ReverseStr();
		assertEquals(fun.reverseStr("abcd", 2), "bacd");
	}
	
	@Test
	public void test4() {
		ReverseStr fun = new ReverseStr();
		assertEquals(fun.reverseStr("abcdefg", 4), "dcbaefg");
	}

    public String reverseStr(String s, int k) {
    	StringBuffer stb = new StringBuffer();
    	int index = 0;
    	while((index+1)*k <= s.length()) {
    		stb.append(reverseSubStr(s.substring(index*k, ++index*k), index-1));
    	}
    	stb.append(reverseSubStr(s.substring(index*k, s.length()), index));
    	
    	return stb.toString();
    }

    //根据k的判断str是否翻转
	private String reverseSubStr(String str, int index) {
		if(index%2==0)
			return reverseSubStr(str);
		else
			return str;
		
	}
	
	private String reverseSubStr(String str) {
		StringBuffer stb = new StringBuffer(str);
		return stb.reverse().toString();
	}
}
