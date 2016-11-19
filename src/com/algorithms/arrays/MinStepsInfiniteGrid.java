package com.algorithms.arrays;

import java.util.ArrayList;

/*
 * You are in an infinite 2D grid where you can move in any of the 8 directions :

 (x,y) to 
    (x+1, y), 
    (x - 1, y), 
    (x, y+1), 
    (x, y-1), 
    (x-1, y-1), 
    (x+1,y+1), 
    (x-1,y+1), 
    (x+1,y-1) 

You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.

Example :

Input : [(0, 0), (1, 1), (1, 2)]
Output : 2

It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 */
public class MinStepsInfiniteGrid {

	// X and Y co-ordinates of the points in order.
	// Each point is represented by (X.get(i), Y.get(i))
	public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
		int count = 0;
		for (int i = 0; i <= X.size() - 2; i++) {
			if (X.get(i) == X.get(i + 1) && Y.get(i) == Y.get(i + 1)) {
				continue;
			} else {
				int diffX = Math.abs(X.get(i) - X.get(i + 1));
				int diffY = Math.abs(Y.get(i) - Y.get(i + 1));
				count += (diffX >= diffY) ? diffX : diffY;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
