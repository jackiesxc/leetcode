package org.jackie.n250.difficult;

import java.util.LinkedList;
import java.util.Queue;

//239. �����������ֵ
//˼·�����ƶ�������Ϊһ�����У�ÿ���ƶ���ʱ���жϽ����е���ֵ������е�ֵ��
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
			if ( nums[i]>max )//��������е���ֵ�������ֵ����ֱ�Ӹ�ֵ
            {
			    max = nums[i];
            }
			else if (temp == max) {//��������е�ֵ�����ֵ������Ҫ�Զ����е������¼������ֵ
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
