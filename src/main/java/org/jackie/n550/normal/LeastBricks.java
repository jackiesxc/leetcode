package org.jackie.n550.normal;

import org.jackie.common.Tools;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

//554. 砖墙
public class LeastBricks {
    public int leastBricks(List<List<Integer>> wall) {
        //Map：key：砖缝宽度；value：总个数
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (List<Integer> wallRow : wall) {
            int sum = 0;
            for (int i = 0; i < wallRow.size()-1; i++) {
                Integer wallLength = wallRow.get(i);
                sum += wallLength;
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }

        int wallHight = wall.size();
        int max = 0; //找出砖缝宽度相等最多的个数
        for (Integer value : map.values()) {
            max = Math.max(max, value);
        }
        return wallHight - max;//同样砖缝宽度，每层只有一个，
    }

    @Test
    public void test1() {
        LeastBricks fun = new LeastBricks();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(Tools.generateList(new Integer[]{1,2,2,1}));
        list.add(Tools.generateList(new Integer[]{3,1,2}));
        list.add(Tools.generateList(new Integer[]{1,3,2}));
        list.add(Tools.generateList(new Integer[]{2,4}));
        list.add(Tools.generateList(new Integer[]{3,1,2}));
        list.add(Tools.generateList(new Integer[]{1,3,1,1}));

        assertEquals(2, fun.leastBricks( list ));
    }

    @Test
    public void test2() {
        LeastBricks fun = new LeastBricks();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.add(Tools.generateList(new Integer[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        list.add(Tools.generateList(new Integer[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        list.add(Tools.generateList(new Integer[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));

        assertEquals(0, fun.leastBricks( list ));
    }
}
