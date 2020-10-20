package org.jackie.n50.normal;

/**
 * 12. 整数转罗马数字
 * 
 */
public class IntToRoman
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
    
    public String intToRoman(int num) {
        StringBuffer result = new StringBuffer(  );
        int n = num/1000;
        result.append( intToRoman(n, 'M', ' ', ' ') );
        num = num%1000;
        
        n = num/100;
        result.append( intToRoman(n, 'C', 'D', 'M') );
        num = num%100;
        
        n = num/10;
        result.append( intToRoman(n, 'X', 'L', 'C') );
        
        num = num%10;
        result.append( intToRoman(num, 'I', 'V', 'X') );
        return result.toString();
    }

    //根据所填入的char按罗马数字规则拼成string
    private String intToRoman( int num, char oneChar, char fiveChar, char tenChar )
    {
        StringBuffer result = new StringBuffer(  );
        if ( num == 9 )
        {
            result.append( oneChar ).append( tenChar );
        } else if ( num == 4 )
        {
            result.append( oneChar ).append( fiveChar );
        } else
        {
            if ( num>=5 )
            {
                result.append( fiveChar );
                num-=5;
            }
            
            for ( int i = 0; i < num; i++ )
            {
                result.append( oneChar );
            }
        }
        return result.toString();
    }

}
