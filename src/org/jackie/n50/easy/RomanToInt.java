package org.jackie.n50.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 * 
 */
public class RomanToInt
{

    /**
     * <对方法的基本功能进行简单描述>
     * <详细描述方法实现的具体功能，用户需要遵循的约束，采用的特殊算法或者业务逻辑等>
     * @param args
     */
    public static void main( String[] args )
    {
        // TODO Auto-generated method stub

    }
    
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

}
