package org.jackie.n50.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * 13. 罗马数字转整数
 * 
 */
public class RomanToInt
{
    public int romanToInt(String s) {
        int sum = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put( 'I', 1 );
        map.put( 'V', 5 );
        map.put( 'X', 10 );
        map.put( 'L', 50 );
        map.put( 'C', 100 );
        map.put( 'D', 500 );
        map.put( 'M', 1000 );
        char[] charList = s.toCharArray();
        for ( int i = 0; i < charList.length; i++ )
        {
            if ( i != charList.length - 1 )
            {
                if ( (charList[i] == 'I' && (charList[i + 1] == 'V' || charList[i + 1] == 'X'))
                        || (charList[i] == 'X' && (charList[i + 1] == 'L' || charList[i + 1] == 'C'))
                        || (charList[i] == 'C' && (charList[i + 1] == 'D' || charList[i + 1] == 'M')) )
                {
                    sum += map.get( charList[i + 1] );
                    sum -= map.get( charList[i] );
                    i++;
                    continue;
                }
            }
            sum+=map.get( charList[i] );
        }
        
        return sum;
    }

    @Test
    public void test1() {
        RomanToInt fun = new RomanToInt();
        assertEquals(fun.romanToInt("III"), 3);
    }

    @Test
    public void test2() {
        RomanToInt fun = new RomanToInt();
        assertEquals(fun.romanToInt("MCMXCIV"), 1994);
    }

    @Test
    public void test3() {
        RomanToInt fun = new RomanToInt();
        assertEquals(fun.romanToInt("LVIII"), 58);
    }
}
