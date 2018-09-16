package org.jackie.n50.normal;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.jackie.common.Tools;
import org.junit.Test;

public class LetterCombinations {

	@Test
	public void test() {
		LetterCombinations fun = new LetterCombinations();
		assertEquals(fun.letterCombinations("23"), null);
	}
	
	@Test
	public void testList() {
		List<String> list1 = new ArrayList<String>();
		list1.add("aaa");
		list1.add("bbb");
		list1.add("ccc");
		List<String> list2 = new ArrayList<String>();
		list2.add("aaa");
		list2.add(new String("ccc"));
		list2.add("bbb");
		assertEquals(Tools.compareList(list1, list2), true);
	}
	
	static final String[] strings = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	
    public List<String> letterCombinations(String digits) {
    	List<String> list = new ArrayList<String>();
    	if (digits.length()==0) {
    		return list;
		}
    	StringBuffer strb = new StringBuffer();
    	descartes(strb, digits, 0, list);
        return list;
    }

    //layer代表所有数组的层数，==1时代表取第一个数组，==2的时候代表取第二个数组
	private void descartes(StringBuffer strb, String digits, int layer, List<String> list) {
		if (layer == digits.length()) {
			list.add(strb.toString());
			return;
		}
		for (int i = 0; i < strings[digits.charAt(layer)-'0'].length(); i++) {
			strb.append(strings[digits.charAt(layer)-'0'].charAt(i));
			descartes(strb, digits, layer+1, list);
			strb.deleteCharAt(strb.length() - 1);
		}
		
	}
    
    

}
