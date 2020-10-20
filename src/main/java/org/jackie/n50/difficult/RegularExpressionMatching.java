package org.jackie.n50.difficult;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RegularExpressionMatching {
	
	@Test
	public void test1() {
		RegularExpressionMatching fun = new RegularExpressionMatching();
		assertEquals(fun.isMatch("aa", "a"), false);
	}
	
	@Test
	public void test2() {
		RegularExpressionMatching fun = new RegularExpressionMatching();
		assertEquals(fun.isMatch("aa", "a*"), true);
	}
	
	@Test
	public void test3() {
		RegularExpressionMatching fun = new RegularExpressionMatching();
		assertEquals(fun.isMatch("ab", ".*"), true);
	}
	
	@Test
	public void test4() {
		RegularExpressionMatching fun = new RegularExpressionMatching();
		assertEquals(fun.isMatch("aab", "c*a*b"), true);
	}
	
	@Test
	public void test5() {
		RegularExpressionMatching fun = new RegularExpressionMatching();
		assertEquals(fun.isMatch("mississippi", "mis*is*p*."), false);
	}
	
	@Test
	public void test6() {
		RegularExpressionMatching fun = new RegularExpressionMatching();
		assertEquals(fun.isMatch("aaa", "a.a"), true);
	}
	
	@Test
	public void test7() {
		RegularExpressionMatching fun = new RegularExpressionMatching();
		assertEquals(fun.isMatch("a", ".*..a*"), false);
	}
	
    public boolean isMatch(String s, String p) {
    	if(p.isEmpty())
    		return s.isEmpty();
        if (p.length() == 1) {
            return (s.length() == 1 && (s.equals(p) || p.equals(".")));
        }
        //如果p的第二个字符不为*，则判断p和s的第一个字符和剩下的
        if (p.charAt(1) != '*') {
        	if (s.isEmpty()) {
				return false;
			}
			return match(getChar(p, 0), getChar(s, 0)) 
					&& isMatch(s.substring(1), p.substring(1));
		}
        
        while (!s.isEmpty() && (match(getChar(p, 0), getChar(s, 0)) || getChar(p, 0)=='.')) {
			if (isMatch(s, p.substring(2))) {
				return true;
			}
			s = s.substring(1);
		}
        return isMatch(s, p.substring(2));
    }
    
    private boolean match(char p, char s) {
        return s == p || p == '.';
    }

    private char getChar(String s, int p) {
        if (s.length() > p) {
            return s.charAt(p);
        }
        return 0;
    }

}
