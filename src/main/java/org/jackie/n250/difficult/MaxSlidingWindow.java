package org.jackie.n250.difficult;

import java.util.LinkedList;
import java.util.Queue;

//239. 滑动窗口最大值
//思路：将移动窗口作为一个队列，每次移动的时候，判断进队列的新值与出队列的值。
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	int[] reslut = new int[nums.length-k+1];
    	Queue<Integer> queue = new LinkedList<Integer>();
    	int max = 0;
    	for (int i = 0; i < nums.length; i++) {
    	    queue.offer( nums[i] );
    	    if ( i < k-1 )   continue;
    	    if ( i == k-1 ){
                max = getMaxFromQueue(queue);
                reslut[i-k+1] = max;
                continue;
            }
    	    
    	    int temp = queue.peek() ;
    	    queue.poll();
			if ( nums[i]>max )//如果进队列的新值大于最大值，则直接赋值
            {
			    max = nums[i];
            }
			else if (temp == max) {//如果出队列的值是最大值，则需要对队列中的数重新计算最大值
                max = getMaxFromQueue(queue);
            }
			reslut[i-k+1] = max;
		}
    	return reslut;
    }

	private int getMaxFromQueue(Queue<Integer> queue) {
	    return queue.stream().max((e1, e2) -> e1.compareTo(e2)).get();
	}
}
