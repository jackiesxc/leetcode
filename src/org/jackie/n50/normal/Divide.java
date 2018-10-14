/**  
* <p>Description:29	两数相除 </p>  
* @author Jackie Su  
* @date 2018年10月14日  
* @version 1.0  
*/  
package org.jackie.n50.normal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**  
* 1, dividend - 2^n*divisor = temp
* 将除数被除数转成Long型是有必要的，解决test6的问题
* 重点算出被除数间的存在几个除数（利用移位）
* 
*/  
public class Divide {
    public int divide(int dividend, int divisor) {
    	boolean isNegated = true;
    	int divide = 0;
    	if ((dividend>0 && divisor<0) || (dividend<0 && divisor>0)) {
    		isNegated = false;
		}
    	if (dividend == Integer.MIN_VALUE && divisor == -1) {
    		return Integer.MAX_VALUE;
		}
    	if(Math.abs(divisor)==1 && isNegated)
    		return Math.abs(dividend);
    	else if(Math.abs(divisor)==1)
    		return -Math.abs(dividend);
    		
    	long dividendLong = Math.abs((long)dividend);
    	long divisorLong = Math.abs((long)divisor);
		while (dividendLong - divisorLong >= 0) {
			long t = divisorLong, p=1;
			while (dividendLong >= (t << 1) ) {
				t <<= 1;   //divisor*2
				p <<= 1;   //p=2^n
			}
			divide +=p;
			dividendLong -=t;
		}
		
		return isNegated ? divide : -divide;
    }
    
    @Test
    public void test1() {
    	Divide fun = new Divide();
    	assertEquals(fun.divide(10, 3), 3);
    }
    
    @Test
    public void test2() {
    	Divide fun = new Divide();
    	assertEquals(fun.divide(7, -3), -2);
    }
    
    @Test
    public void test3() {
    	Divide fun = new Divide();
    	assertEquals(fun.divide(1, 1), 1);
    }
    
    @Test
    public void test4() {
    	Divide fun = new Divide();
    	assertEquals(fun.divide(-2147483648, -1), 2147483647);
    }
    
    @Test
    public void test5() {
    	Divide fun = new Divide();
    	assertEquals(fun.divide(-1, 1), -1);
    }
    
    @Test
    public void test6() {
    	Divide fun = new Divide();
    	assertEquals(fun.divide(2147483647, 2), 1073741823);
    }
    
    @Test
    public void test7() {
    	Divide fun = new Divide();
    	assertEquals(fun.divide(-2147483648, -2147483648), 1);
    }
}
