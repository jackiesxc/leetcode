package org.jackie.n50.normal;


import static org.junit.Assert.assertEquals;

import org.junit.Test;


//50. Pow(x, n)
public class MyPow {
	private static final double DELTA = 1e-6;
    public double myPow(double x, int n) {
    	if (n==0) {
			return 1;
		} else if(n>0){
			return pow(x,n);
		}else {
			return (double)1/pow(x,-1*n);
			
		}
    }
    
    private double pow(double x, int n) {
        if ( n==0 )
            return 1;
        double result = pow(x, n/2);
        if ( n % 2 ==0 ){
            result = result*result;
        }
        else {
            result = x*result*result;
        }

        return result;
    }

	@Test
    public void test1() {
		MyPow fun = new MyPow();
		assertEquals(1024.00000, fun.myPow(2.00000, 10), DELTA);
    }
	
	@Test
    public void test2() {
		MyPow fun = new MyPow();
		assertEquals(9.26100, fun.myPow(2.10000, 3), DELTA);
    }
	
	@Test
    public void test3() {
		MyPow fun = new MyPow();
		assertEquals(0.25000, fun.myPow(2.00000, -2), DELTA);
    }
}
