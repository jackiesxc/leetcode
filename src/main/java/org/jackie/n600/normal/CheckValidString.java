package org.jackie.n600.normal;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

//678. ��Ч�������ַ���
public class CheckValidString {
    public boolean checkValidString(String s) {
        int min = 0, max = 0; //���������ٿ�������������
        for (char c : s.toCharArray()) {
            if (c == '(') {
                min++; max++;
            }
            else if (c == ')') {
                if (min > 0) {
                    min--;
                }
                max--;
            }
            else {
                //����(* ������minΪ0��maxΪ2�� (** ������minΪ0��maxΪ3
                if (min > 0) {
                    min--;
                }
                max++;
            }
            //�����Ų��������
            if (max < 0) {
                return false;
            }
        }
        //�����Ź�ʣ�����
        if (min > 0) {
            return false;
        }
        return true;
    }

    @Test
    public void test0() {
        CheckValidString fun = new CheckValidString();
        assertEquals(fun.checkValidString("()" ), true);
    }

    @Test
    public void test1() {
        CheckValidString fun = new CheckValidString();
        assertEquals(fun.checkValidString("(*)" ), true);
    }

    @Test
    public void test2() {
        CheckValidString fun = new CheckValidString();
        assertEquals(fun.checkValidString("(*))" ), true);
    }

    @Test
    public void test3() {
        CheckValidString fun = new CheckValidString();
        assertEquals(fun.checkValidString("(***)" ), true);
    }

    @Test
    public void test4() {
        CheckValidString fun = new CheckValidString();
        assertEquals(fun.checkValidString("((())()()(*)(*()(())())())()()((()())((()))(*" ), false);
    }
}
