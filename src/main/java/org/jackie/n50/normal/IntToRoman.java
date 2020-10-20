package org.jackie.n50.normal;

/**
 * 12. ����ת��������
 * 
 */
public class IntToRoman
{

    /**
     * <�Է����Ļ������ܽ��м�����>
     * <��ϸ��������ʵ�ֵľ��幦�ܣ��û���Ҫ��ѭ��Լ�������õ������㷨����ҵ���߼���>
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

    //�����������char���������ֹ���ƴ��string
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
