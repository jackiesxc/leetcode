package org.jackie.n100.normal;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

//166. 分数到小数
public class FractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        long num = Math.abs(Long.valueOf(numerator));
        long divide = Math.abs(Long.valueOf(denominator));
        StringBuffer strb = new StringBuffer();
        if ((numerator>0 && denominator<0) || (numerator<0 && denominator>0) ) {
            strb.append('-');
        }
        strb.append(num/divide);
        long mod = (int) (num % divide);
        if (mod ==0) {
            return strb.toString();
        }
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        strb.append(".");
        while (mod != 0){
            if (map.containsKey(mod)) {
                strb.insert(map.get(mod), "("); //记录循环开始的位置
                strb.append(')');
                break;
            }else {
                map.put(mod, strb.length());
            }
            mod *= 10;
            strb.append(mod / divide);
            mod = (long) (mod % divide);
        }
        return strb.toString();
    }

    @Test
    public void test1() {
        FractionToDecimal fun = new FractionToDecimal();
        assertEquals(fun.fractionToDecimal(1, 2 ), "0.5");
    }
    @Test
    public void test2() {
        FractionToDecimal fun = new FractionToDecimal();
        assertEquals(fun.fractionToDecimal(2, 3 ), "0.(6)");
    }
    @Test
    public void test3() {
        FractionToDecimal fun = new FractionToDecimal();
        assertEquals(fun.fractionToDecimal(4, 333 ), "0.(012)");
    }
    @Test
    public void test4() {
        FractionToDecimal fun = new FractionToDecimal();
        assertEquals(fun.fractionToDecimal(-2, 3 ), "-0.(6)");
    }
    @Test
    public void test5() {
        FractionToDecimal fun = new FractionToDecimal();
        assertEquals(fun.fractionToDecimal(-1, -2147483648 ), "0.0000000004656612873077392578125");
    }
}
