package com.unitest.junitest.logic;

import java.util.ArrayList;

public class Formula {
	public static int getMultiple(int x, int y) {
		return x*y;
	}
	
	public static int findMax(int arr[]) {
		int max = 0;
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i])
				max = arr[i];
		}
		return max;
	}
	
	public static String getConcat(NewFormula newFormula) throws NullPointerException {
		ArrayList<String> tmpArr = new ArrayList<String>();
		String tmp = tmpArr.get(1);
//		String tmp = "h";
		return newFormula.concatString(tmp, "world");
	}
}
