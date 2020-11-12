package org.jackie.n1000.normal;

import org.jackie.common.Tools;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

//1169. 查询无效交易
public class InvalidTransactions {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> result = new ArrayList<String>();
        List<String[]> list = new LinkedList<String[]>();

        //进行分割入到数组里
        for (int i = 0; i < transactions.length; i++) {
            String[] args = transactions[i].split(",");
            list.add(args);
        }

        //进行双重循环，暴力法逐个判断是不是不符合条件，列入result数组中
        for (int i = 0; i < transactions.length; i++)  {
            String[] strings = list.get(i);
            if (Integer.parseInt(strings[2]) > 1000) {
                result.add(transactions[i]);
                continue;
            }
            int time = Integer.parseInt(strings[1]);
            String name = strings[0];
            String city = strings[3];
            boolean unCountFlag = false;
            for (String[] str2 : list) {
                if (name.equals(str2[0]) && !city.equals(str2[3]) && Math.abs(time - Integer.parseInt(str2[1])) <=60) {
                    unCountFlag = true;
                    break;
                }
            }
            if (unCountFlag) {
                result.add(transactions[i]);
            }
        }
        return result;
    }

    @Test
    public void test1() {
        InvalidTransactions fun = new InvalidTransactions();
        List<String> list = new ArrayList<String>();
        list.addAll(Tools.generateList(new String[]{"alice,20,800,mtv","alice,50,100,beijing"}));
        assertEquals(fun.invalidTransactions(new String[]{"alice,20,800,mtv","alice,50,100,beijing"}), list);
    }
}
