package org.jackie.n600.normal;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

//621. 任务调度器
public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : tasks) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            }
            else {
                map.put(c, 1);
            }
        }

        int maxLetterCount =0, duplMaxLetter = 0;
        //算出出现次数最多的任务次数
        for (Character character : map.keySet()) {
            maxLetterCount = Math.max(maxLetterCount, map.get(character));
        }
        //算出次数最多的任务有多少
        for (Character character : map.keySet()) {
            if (map.get(character) == maxLetterCount) duplMaxLetter++;
        }
        // test1范例：A__A__A minCount为6；
        // test3范例：ABCD_ABCD_ABCD_ABCD minCount为15；
        int minCount = (maxLetterCount-1) * (n+1);
        //当剩余的字母数量大于空格数（test1范例中为4，范例3为3）
        if (tasks.length - maxLetterCount * duplMaxLetter >
                (maxLetterCount-1) * (n - duplMaxLetter+1) ) {
            return tasks.length;
        }

        // test3范例：count(ABCD_ABCD_ABCD_) + count(ABCD)： 15 + 4；
        return minCount + duplMaxLetter ;
    }

    @Test
    public void test1() {
        LeastInterval fun = new LeastInterval();
        assertEquals(8, fun.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }

    @Test
    public void test2() {
        LeastInterval fun = new LeastInterval();
        assertEquals(16, fun.leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2));
    }

    @Test
    public void test3() {
        LeastInterval fun = new LeastInterval();
        assertEquals(19, fun.leastInterval(new char[]{'A','A','A','A','B','B','B','B','C','C','C','C','D','D','D','D','E','F'}, 4));
    }
}
