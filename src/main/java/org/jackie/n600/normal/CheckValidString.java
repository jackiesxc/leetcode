package org.jackie.n600.normal;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

//678. 有效的括号字符串
public class CheckValidString {
    public boolean checkValidString(String s) {
        int min = 0, max = 0; //左括号最少可能数和最多可能
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
                //例如(* 左括号min为0，max为2； (** 左括号min为0，max为3
                if (min > 0) {
                    min--;
                }
                max++;
            }
            //左括号不够的情况
            if (max < 0) {
                return false;
            }
        }
        //左括号过剩的情况
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
