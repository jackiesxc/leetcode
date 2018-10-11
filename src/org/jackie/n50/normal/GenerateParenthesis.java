/**  
* <p>Description: 22 括号生成</p>  
* @author Jackie Su  
* @date 2018年10月11日  
* @version 1.0  
*/  
package org.jackie.n50.normal;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.jackie.common.Tools;
import org.junit.Test;

public class GenerateParenthesis {
	
    public List<String> generateParenthesis(int n) {
    	if (n==0) 
    		return null;
    	List<String> result = new ArrayList<String>();
    	generateP("", n, n, result);
        return result;
    }
    
	private void generateP(String strb, int left, int right, List<String> result) {
		if (left==0 && right ==0) {
			result.add(strb.toString());
			return;
		}
		if (left>0) {
			generateP(strb + '(', left-1, right, result);
		}
		if (right>0 && right>left) {
			generateP(strb + ')', left, right-1, result);
		}
	}

	@Test
	public void test1() {
		GenerateParenthesis fun = new GenerateParenthesis();
		boolean flag = Tools.compareList(fun.generateParenthesis(3), 
				Tools.generateList(new String[]{  "((()))",
						  "(()())",
						  "(())()",
						  "()(())",
						  "()()()"}));
		assertEquals(flag, true);
	}
}
