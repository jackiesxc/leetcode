package org.jackie.other.easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//������ 17.09. �� k ����
public class GetKthMagicNumber {

    //������ָ�룬�����е�list[k]������*3, *5, *7����
    //ע��������ָ�벻��ָ3��5��7��ָ��������
    public int getKthMagicNumber(int k) {
        int index1=0, index2=0, index3=0;
        int[] list = new int[k+1];
        list[0] = 1;
        for (int i = 1; i <= k-1; i++) {
            list[i] = Math.min(Math.min(list[index1]*3, list[index2]*5), list[index3]*7);
            if (list[i] == list[index1]*3) index1++;
            if (list[i] == list[index2]*5) index2++;
            if (list[i] == list[index3]*7) index3++;
        }
        return list[k-1];
    }

    @Test
    public void test1() {
        GetKthMagicNumber fun = new GetKthMagicNumber();
        assertEquals(3, fun.getKthMagicNumber(2));
    }

    @Test
    public void test2() {
        GetKthMagicNumber fun = new GetKthMagicNumber();
        assertEquals(9, fun.getKthMagicNumber(5));
    }

    @Test
    public void test3() {
        GetKthMagicNumber fun = new GetKthMagicNumber();
        assertEquals(21, fun.getKthMagicNumber(7));
    }
}
