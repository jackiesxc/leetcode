package org.jackie.n50.normal;

import org.junit.Test;

//48. Ðý×ªÍ¼Ïñ
public class Rotate {
  @Test
  public void test1() {
      Rotate fun = new Rotate();
      int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
      System.out.println( matrix.length );
      fun.rotate(matrix);
      System.out.println( "success" );
      //assertEquals(fun.rotate(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}), 6);
  }
  
  public void rotate(int[][] matrix) {
      int n = matrix.length;
      int[][] result = new int[n][n];
      for ( int i = 0; i < n; i++ )
      {
          int[] element = new int[n];
          for ( int j = 0; j < n; j++ )
          {
              element[j] = matrix[n-1-j][i];
          }
          result[i] = element;
      }
      
      for ( int i = 0; i < n; i++ )
      {
          for ( int j = 0; j < n; j++ )
          {
              matrix[i][j] = result[i][j];
          }
      }
  }
}
