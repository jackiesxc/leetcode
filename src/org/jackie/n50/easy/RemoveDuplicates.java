/**  
* <p>Description: </p>  
* @author Jackie Su  
* @date 2019Äê4ÔÂ14ÈÕ  
* @version 1.0  
*/  
package org.jackie.n50.easy;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if ( nums == null || nums.length==0 ) return 0;
        
        int i=0;
        for ( int j = 1; j < nums.length; j++ )
        {
            if ( nums[j] != nums[j-1] )
            {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
