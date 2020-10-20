package org.jackie.n50.difficult;

import java.util.ArrayList;
import java.util.List;

public class FindMedianSortedArrays {

	public static void main(String[] args) {
		FindMedianSortedArrays solution = new FindMedianSortedArrays();
		int[] nums1 = {1,2};
		int[] nums2 = {3,4};
		System.out.println(solution.findMedianSortedArrays(nums1, nums2));

	}
	
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	double result =0;
    	List<Integer> list = new ArrayList<Integer>();
    	int i=0,j=0;
        while (i<nums1.length || j<nums2.length) {
			if (j==nums2.length || (i!=nums1.length && nums1[i] < nums2[j])) {
				list.add(nums1[i]);
				i++;
			}
			else {
				list.add(nums2[j]);
				j++;
			}			
		}
        
        int size = list.size();
        if (size==0) {
			return 0;
		}
        if (size%2==0) {  //list中包含偶数个元素
        	result = (double)(list.get(size/2) + list.get(size/2-1))/2;
		} else {
			result = list.get(size/2);
		}
        
        return result;
    }

}
