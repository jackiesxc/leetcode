package org.jackie.n100.difficult;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//85. 最大矩形
//给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
    	return 0;
    }
	@Test
    public void test1() {
		MaximalRectangle fun = new MaximalRectangle();
		assertEquals(6, fun.maximalRectangle(
				new char[][] {{'1','0','1','0','0'},
							  {'1','0','1','1','1'},
							  {'1','1','1','1','1'},
							  {'1','0','0','1','0'}}));
    }
}
